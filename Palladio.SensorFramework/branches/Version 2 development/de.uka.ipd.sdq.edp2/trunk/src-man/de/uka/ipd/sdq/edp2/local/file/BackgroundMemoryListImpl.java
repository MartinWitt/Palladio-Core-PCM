package de.uka.ipd.sdq.edp2.local.file;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.AbstractList;
import java.util.logging.Logger;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;


/**
 * A generic list implementation that consumes a constant amount of main memory regardless of the number of elements in the 
 * list. It relies on HDD memory as background storage. It uses views on the data stored in form of chunks.
 * A chunk contains a limited number of data elements. Chunks are (de-)serialized to disk depending on the
 * requested data elements. 
 * The list has some restrictions:
 * First, all elements have to be serializable with constant memory footprint.
 * Second, deletion of elements in the list is not implemented.
 * Third, insertion is only possible at the end of the list.
 * @param <T> The generic type parameter of the list's elements
 * @author Henning Groenda
 * @author Steffen Becker
 */
@SuppressWarnings("unchecked")
public class BackgroundMemoryListImpl<T extends Measure> 
	extends AbstractList<T>
	implements BackgroundMemoryList<T> {

	private static final String ACCESS_MODIFIER_READ_WRITE = "rw";
//	/**Serialization UID for this class. Change upon altered serialization. */
//	private static final long serialVersionUID = 1L;
	/** Logger for this class. */
	transient private static Logger logger = Logger.getLogger(BackgroundMemoryListImpl.class.getName());

	/** Number of data elements per chunk. */
	static final public int DEFAULT_CHUNK_SIZE = 10000;
	
	/**Describes the representation and storage of the values in binary format.
	 * @author groenda
	 */
	public enum BinaryRepresentation {
		/** Binary representation of type long. */
		LONG,
		/** Binary representation of type double. */
		DOUBLE
	};
	
	/** Access to chunks. */
	transient private ChunkedFile chunks = null;
	/** Name of the file which is used to store the chunks. Absolute path to the file. */
	private String absoluteFilename = null;
	/** The link to the attached background storage in which all chunks are persisted. */
	transient private RandomAccessFile raf = null;
	/** Status of the link to the attached file on background storage. Operations are only allowed in open state. */
	transient boolean closed = true;
	/** The serializer for the elements of the list on the background storage. */
	private Serializer<?> serialiser;
	/** Total number of elements in the list. */
	private int listSize;
	/** The size of the chunk in elements */
	private int chunkSize;
	/** Binary format of values stored in this list. */
	private BinaryRepresentation binaryRepresentation;
	/** Unit of the measurements stored in this list. */
	private Unit unit; 
	
	/**
	 * Constructor for background memory lists.
	 * @param absoluteFilename Path to the file used as background storage.
	 * @param serialiser The (de-)serializer to use upon serialization of data to the background storage.
	 * @throws IOException Thrown if file IO fails.
	 */
	public BackgroundMemoryListImpl(String absoluteFilename, Serializer<?> serialiser, BinaryRepresentation binaryRepresentation, Unit unit) throws IOException {
		this(absoluteFilename, serialiser, DEFAULT_CHUNK_SIZE, binaryRepresentation, unit);
	}

	/**
	 * Constructor for background memory lists.
	 * @param absoluteFilename Path to the file used as background storage.
	 * @param serialiser The (de-)serializer to use upon serialization of data to the background storage.
	 * @param chunkSize The size of the chunk in elements which should be used.
	 * @throws IOException Thrown if file IO fails.
	 */
	public BackgroundMemoryListImpl(String absoluteFilename, Serializer<?> serialiser, int chunkSize, BinaryRepresentation binaryRepresentation, Unit unit) throws IOException {
		this.absoluteFilename = absoluteFilename;
		this.serialiser = serialiser;
		this.chunkSize = chunkSize;
		this.binaryRepresentation = binaryRepresentation;
		this.unit = unit;
		open();
		listSize = (int) chunks.getElementsInFile();
	}
	
	public synchronized void open() throws IOException {
		if (!closed) {
			String msg = "Tried to open an already open background list.";
			logger.warning(msg);
			throw new IllegalStateException(msg);
		}
		raf = new RandomAccessFile(absoluteFilename, ACCESS_MODIFIER_READ_WRITE);
		if (binaryRepresentation == BinaryRepresentation.LONG) {
			chunks = new ChunkedFile<Long>(raf, (Serializer<Long>) serialiser, chunkSize);
		}
		if (binaryRepresentation == BinaryRepresentation.DOUBLE) {
			chunks = new ChunkedFile<Double>(raf, (Serializer<Double>) serialiser, chunkSize);
		}
		closed = false;
		// list size is calculated in open() and readObject() to allow error detection.
	}

	public synchronized boolean isClosed() {
		return closed;
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	@Override
	public synchronized void add(int index, T element) {
		if (closed) {
			String msg = "Tried to add data to a closed background list.";
			logger.severe(msg);
			throw new IllegalStateException(msg);
		}
		if (index != listSize) {
			String msg = "The background list currently only supports adding elements at the end of the list";
			logger.info(msg);
			throw new IllegalArgumentException(msg);
		}
		if (element == null) {
			String msg = "Null values must not be added to the list.";
			logger.severe(msg);
			throw new IllegalArgumentException(msg);
		}
		try {
			ensureCorrectChunkLoaded(index);
			if (binaryRepresentation == BinaryRepresentation.LONG) {
				chunks.add(element.longValue(unit));
			}
			if (binaryRepresentation == BinaryRepresentation.DOUBLE) {
				chunks.add((Double) element.doubleValue(unit));
			}
			this.listSize++;
			if (chunks.isFull()) {
				chunks.saveChunk();
				chunks.createChunk();
			}
		} catch(IOException ex) {
			String msg = "Error during IO of background list for file \"" + absoluteFilename +"\"";
			logger.severe(msg);
			throw new RuntimeException(msg, ex);
		}
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractList#get(int)
	 */
	public synchronized T get(int index) {
		if (closed) {
			String msg = "Tried to get data from a closed background list.";
			logger.severe(msg);
			throw new IllegalStateException(msg);
		}
		if (index < 0 || index >= size()) {
			String msg;
			if (index >= size()) {
				msg = "Tried to get data element beyond the number of elements in the background list.";
			} else {
				msg = "Tried to get data element with a negative index from the background list.";
			}
			logger.severe(msg);
			throw new ArrayIndexOutOfBoundsException(msg);
		}
		try {
			ensureCorrectChunkLoaded(index);
			Measure<?, Quantity> measure = null;
			//Measure measure;
			if (binaryRepresentation == BinaryRepresentation.LONG) {
				measure = Measure.valueOf((Long) chunks.get((int)(index - chunks.indexStartingElementForChunk())), unit);
			}
			if (binaryRepresentation == BinaryRepresentation.DOUBLE) {
				measure = Measure.valueOf((Double)chunks.get((int)(index - chunks.indexStartingElementForChunk())), unit);
			}
			return (T) measure;
		} catch(IOException ex) {
			String msg = "Error during IO of background list for file \"" + absoluteFilename +"\"";
			logger.severe(msg);
			throw new RuntimeException(msg, ex);
		}
	}
	
	public T set(int index, T element) {
		if (closed) {
			String msg = "Tried to get data to a closed background list.";
			logger.severe(msg);
			throw new IllegalStateException(msg);
		}
		if (index < 0 || index >= size()) {
			String msg;
			if (index >= size()) {
				msg = "Tried to set data element beyond the number of elements in the background list.";
			} else {
				msg = "Tried to set data element with a negative index from the background list.";
			}
			logger.severe(msg);
			throw new ArrayIndexOutOfBoundsException(msg);
		}
		try {
			ensureCorrectChunkLoaded(index);
			if (binaryRepresentation == BinaryRepresentation.LONG) {
				long newValue = element.longValue(unit);
				long oldValue = (Long) chunks.set((int)(index - chunks.indexStartingElementForChunk()), newValue);
				return (T) Measure.valueOf(oldValue, unit);
			}
			if (binaryRepresentation == BinaryRepresentation.DOUBLE) {
				double newValue = element.doubleValue(unit);
				double oldValue = (Double) chunks.set((int)(index - chunks.indexStartingElementForChunk()), newValue);
				return (T) Measure.valueOf(oldValue , unit);
			}
			return null;
		} catch(IOException ex) {
			String msg = "Error during IO of background list for file \"" + absoluteFilename +"\"";
			logger.severe(msg);
			throw new RuntimeException(msg, ex);
		}
	};
	
	@Override
	public T remove(int index) {
		// TODO Add support for removal of elements from background memory list.
		throw new UnsupportedOperationException();
	}

	/**Ensures that the chunk containing the requested element is loaded.
	 * Serializes the current chunk and load the requested chunk if necessary.
	 * @param dataIndex index of the requested element in the list.
	 * @throws IOException Thrown if an error during IO occurs.
	 */
	private void ensureCorrectChunkLoaded(int dataIndex) throws IOException {
		if (chunks.acceptsDataElementIndex(dataIndex)) {
			return;
		} else {
			if (chunks.isChunkLoaded() && chunks.isChanged()) {
				chunks.saveChunk();
			}
			chunks.loadChunkForElement(dataIndex);
		}
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	public synchronized int size() {
		return listSize;
	}

	public synchronized void close() throws IOException {
		if (closed) {
			String msg = "Tried to close a closed list.";
			logger.warning(msg);
			throw new IllegalStateException(msg);
		}
		if (!closed) {
			if (chunks.isChunkLoaded() && chunks.isChanged()) {
				chunks.saveChunk();
			}
			raf.close();
			closed = true;
		}
	}

	/**Used for serialization.
	 * @param in stream to deserialize.
	 * @throws IOException Error when accessing the stream.
	 * @throws ClassNotFoundException Conversion errors.
	 */
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		// default behavior
		in.defaultReadObject();

		// customization on load
		open();
		if (chunks.getElementsInFile() != listSize) {
			String msg = "Number of elements of this list and elements saved to file on background mismatch.";
			logger.severe(msg);
		}
		listSize = (int) chunks.getElementsInFile();
	}
}