package cst135.lab7logfileparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReadLogData {
	//Class data
	private List<Integer> logData = new ArrayList<Integer>();
	private String logFileName;
	
	//Constructor
	public ReadLogData(String logFileName) {
		this.logFileName = logFileName;
	}

	/**
	 * @return the logData
	 */
	public List<Integer> getLogData() {
		return logData;
	}

	/**
	 * @param logData the logData to set
	 */
	public void setLogData(List<Integer> logData) {
		this.logData = logData;
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
	public void readLogData() throws FileNotFoundException {
		try {
			//Open log file that is in the form yyyy/mm/dd hh:mm:ss,integer,String
			Scanner sc = new Scanner(new File(this.logFileName));
			//Read each line and parse the integer and store in logData
			String[] line = new String[3];
			while(sc.hasNextLine()) {
				line = sc.nextLine().split(",");
				logData.add(Integer.parseInt(line[1]));
			}
			sc.close();
		}
		catch(FileNotFoundException e) {
			System.out.println();
		}
	}
	
	public void sortLogData() {
		Collections.sort(logData);
	}
	
	public void printLogData() {
		System.out.println("\nThe data from the log file " + this.logFileName);
		for(Integer d : logData) {
			System.out.print(d + " ");
		}
	}
}
