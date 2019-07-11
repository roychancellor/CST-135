package cst135.lab7logfileparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogStatistics {
	private int sum;
	private double average;
	private List<Integer> data = new ArrayList<Integer>();
	private String statsFileName;
	
	//Constructor
	public LogStatistics(String statsFileName, List<Integer> data) {
		this.statsFileName = statsFileName;
		this.data = data;
		this.sum = 0;
		this.average = 0;
	}

	//Accessors / mutators
	public int getSum() {
		return sum;
	}

	public double getAverage() {
		return average;
	}
	
	public String getStatsFileName() {
		return statsFileName;
	}

	//Class methods
	private void computeSum() {
		for(Integer d : this.data)
			this.sum += d;
	}
	
	private void computeAverage() {
		computeSum();
		if(this.data.size() > 0)
			this.average = (double)this.sum / this.data.size();
		else {
			this.average = 0;
			this.sum = -1;
		}
	}
	
	public void writeStats() throws IOException {
		try {
			FileWriter fw = new FileWriter(this.statsFileName, false);
			computeAverage();
			fw.write(this.sum + "," + this.average);
			fw.close();
		}
		catch(IOException e) {
			System.out.println("ERROR: Unable to write to stats file " + this.statsFileName);
		}
	}
	
	public void readStats() throws FileNotFoundException {
		try {
			Scanner sc = new Scanner(new File(this.statsFileName));
			while(sc.hasNextLine()) {
				String[] line = new String[2];
				line = sc.nextLine().split(",");
				this.sum = Integer.parseInt(line[0]);
				this.average = Double.parseDouble(line[1]);
			}
			sc.close();
			System.out.println("\n\nSummary statistics:");
			printStats();
		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR: Unable to read from stats file " + this.statsFileName);
		}
	}
	
	private void printStats() {
		System.out.println("\t* Sum = " + this.sum);
		System.out.println("\t* Count = " + this.data.size());
		System.out.printf("\t* Average = %.3f", this.average);
	}
}
