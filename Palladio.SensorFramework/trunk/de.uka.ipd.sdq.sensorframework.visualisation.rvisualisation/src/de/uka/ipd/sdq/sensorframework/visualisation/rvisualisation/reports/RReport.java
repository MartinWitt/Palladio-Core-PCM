package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;

/**Abstract class for R reports.
 * The interface of this class is used by the viewers to access the reports.
 * @author groenda
 */
public abstract class RReport {
	
	/**Template method for subclasses to implement. Subclasses can create
	 * IReportItems from the given <code>SensorAndMeasurements</code>. They 
	 * can use the <code>storeMeasurementsInRVector(SensorAndMeasurements, int)
	 * </code> to transfer data to R.
	 * 
	 * @param measurements List of the measurements for a sensor.
	 * @param rConnection connection to the R engine.
	 * @return List of Items.
	 */
	public abstract ArrayList<IReportItem> prepareReportItems(
			Collection<SensorAndMeasurements> measurements, 
			RConnection rConnection);
	
	/**Export the measurements of a sensor to R. 
	 * There are two alternatives. Normally, the measurements are transferred 
	 * via an array, which has certain size restrictions. An Alternative is 
	 * to use a temporary file and use the R command line to import this data 
	 * is returned. The behavior can only be switched in source code.
	 * 
	 * @param measurements Measurements for a sensor.
	 * @param sensorNumber number of the sensor vector in R.
	 * @return R command to read measurements. 
	 *         It is stored in the vector <code>sensor</code>i.
	 */
	protected String storeMeasurementsInRVector(
			final SensorAndMeasurements measurements, final int sensorNumber) {
//		// Activate to transfer data via memory
//		double[] measurementsArray = prepareExportToRByMemory(measurements);
//		RConnection.getRConnection().assign(
//				"sensor" + sensorNumber, measurementsArray);
//		return "";
		
		// Activate to transfer data via temporary file
		String rCommand = prepareExportToRByFile(measurements);
		if (rCommand != "") {
			rCommand = "sensor" + sensorNumber + " <- " + rCommand + "\n";
		}
		return rCommand;
	}
	
	/**Prepares the export the measurements of a sensor to R. Therefore an 
	 * array is filled with the measurements. 
	 * 
	 * @param measurements Measurements for a sensor.
	 * @return R command to read measurements. 
	 *         Can be used to store data in a r vector.
	 */
	private double[] prepareExportToRByMemory(
			final SensorAndMeasurements measurements) {
		double[] measurementsArray = 
			new double[measurements.getMeasurements().size()];
		if (measurements.getMeasurements().size() == Integer.MAX_VALUE) {
			RVisualisationPlugin.log(IStatus.ERROR,
					"Too much measurements. Results might be inaccurate.");
		}
		int position = 0;
		for (Measurement time : measurements.getMeasurements()) {
			TimeSpanMeasurement tsm = (TimeSpanMeasurement) time;
			measurementsArray[position++] = tsm.getTimeSpan();
		}
		return measurementsArray;
	}

	/**Prepares the export the measurements of a sensor to R. Therefore 
	 * a temporary file is created and the R command line to import this 
	 * data is returned. 
	 * 
	 * @param measurements Measurements for a sensor.
	 * @return R command to read measurements. 
	 *         Can be used to store data in a r vector.
	 */
	private String prepareExportToRByFile(
			final SensorAndMeasurements measurements) {
		File temporaryFile;
		try {
			temporaryFile = File.createTempFile("data", ".txt");
			temporaryFile.deleteOnExit();
			FileWriter temporaryFileWriter = new FileWriter(temporaryFile);
			StringBuffer result = new StringBuffer();
			for (Measurement time : measurements.getMeasurements()) {
				TimeSpanMeasurement tsm = (TimeSpanMeasurement) time;
				result.append(tsm.getTimeSpan());
				result.append(" ");
			}
			temporaryFileWriter.write(result.toString());
			temporaryFileWriter.close();
			return "scan(file=\"" 
				+ temporaryFile.getAbsolutePath().replace(File.separator, 
						"\\\\")
				+ "\")";
		} catch (IOException e) {
			RVisualisationPlugin.log(IStatus.ERROR,
				"Error accessing temporary file to transfer sensordata "
				+ "to R. \n\n Details: "	+ e.getMessage());
		}
		return "";
	}
}
