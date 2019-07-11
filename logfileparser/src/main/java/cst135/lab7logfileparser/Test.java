package cst135.lab7logfileparser;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		//Make objects
		WriteLog w = new WriteLog("log.txt");
		ReadLogData r = new ReadLogData(w.getLogFileName());
		LogStatistics s = new LogStatistics("stats.txt", r.getLogData());
		//Write values to log file of the form: yyyy/mm/dd hh:mm:ss,integer,String
		w.writeLogFile();
		//Read data from log file
		r.readLogData();
		r.sortLogData();
		r.printLogData();
		//Compute sum and average and write to/read from log statistics file
		s.writeStats();
		s.readStats();
	}
}
