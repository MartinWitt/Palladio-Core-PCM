package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.InputStream;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.Storage;

public class BusinessFacade {
	
	private static Logger logger = Logger.getLogger("BusinessFacade");
	private CopyrightedMaterialDatabase copyDB;
	private ExistingFilesDatabase fileDB;
	private Storage storageSubSystem;
	
	public BusinessFacade() {
		this.copyDB = new CopyrightedMaterialDatabase();
		this.fileDB = new ExistingFilesDatabase();
	}

	public void uploadFile(InputStream[] inputStream, FileType fileType) {
		byte[] fileHash;
		InputStream currentInputStream;
		
		for(int x = 0; x < inputStream.length; x++) {
			currentInputStream = inputStream[x];
			
			if(fileType != FileType.Archive)
			{
				compress(currentInputStream);
				fileHash = md5(currentInputStream);				
			} else {
				fileHash = md5(currentInputStream);
				compress(currentInputStream);
			}	
			
			if(isCopyrightedMaterial(fileHash)) {
				logger.debug("Copyrighted file found.");
				//reject file // do not store
			} else {
				if(!isFileExistingInDB(fileHash)) {
					storageSubSystem.storeFile(null, fileHash);
				}
			}
		}
	}
	
	private byte[] md5(InputStream inputStream) {		
		return null;
	}

	private void compress(InputStream inputStream) {
		
	}
	
	private boolean isCopyrightedMaterial(byte[] hash) {
		return this.copyDB.isCopyrightedMaterial(hash);	
	}
	
	private boolean isFileExistingInDB(byte[] hash) {
		return this.fileDB.existsInDatabase(hash);				
	}

}
