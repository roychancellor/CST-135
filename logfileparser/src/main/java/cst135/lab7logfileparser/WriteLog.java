package cst135.lab7logfileparser;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteLog {
	//Class data
	private final String[] colors = {"red", "orange", "yellow", "green", "blue", "indigo"};
	private final int numValues;
	private String logFileName;
	
	//Constructor
	public WriteLog(String logFileName) {
		numValues = (int)(Math.random() * 16 + 5);
		this.logFileName = logFileName;
	}

	/**
	 * @return the colors
	 */
	public String[] getColors() {
		return colors;
	}

	/**
	 * @return the numValues
	 */
	public int getNumValues() {
		return numValues;
	}
	
	/**
	 * @return the logFileName
	 */
	public String getLogFileName() {
		return logFileName;
	}

	/**
	 * @param logFileName the logFileName to set
	 */
	public void setLogFileName(String logFileName) {
		this.logFileName = logFileName;
	}

	//Class methods
	public void writeLogFile() throws IOException {
		//Create Date object for date-time stamp
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		//Open the log file in overwrite mode
		try {
			FileWriter log = new FileWriter(this.logFileName, false);
			//Generate numValues random numbers between -50 and 50 and
			//write to log file with date-time stamp prefix
			//and serial color suffix
			int c = 0;
			for(int i = 0; i < numValues; i++) {
				log.write(dateFormat.format(date) + "," + ((int)(Math.random() * 101 - 50)) + "," + colors[c] + "\n");
				c++;
				if(c == colors.length)
					c = 0;
			}
			log.close();
		}
		catch(IOException e) {
			System.out.println("ERROR: Unable to open or write to " + this.logFileName);
		}
	}
}
