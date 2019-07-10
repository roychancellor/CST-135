package cst135.commonbeginningofwords;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Writer {
	//Class data
	private Scanner sc = new Scanner(System.in);
	private String fileName;
	private String[] words = new String[3];
	
	//Constructor
	public Writer() {
		this.fileName = "words.txt";
	}
	
	//Getters & setters
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	//Class methods
	public void getUserFileName() {
		System.out.println("Enter a file name to write your words, including extension (.txt is recommended):");
		String fileName = sc.nextLine();
		setFileName(fileName);		
	}
	
	public void getWords() {
		System.out.println("Enter a word:");
		words[0] = sc.nextLine();
		System.out.println("Enter another word:");
		words[1] = sc.nextLine();
		System.out.println("Enter a third word:");
		words[2] = sc.nextLine();
	}
	
	public void writeWords() throws IOException {
		FileWriter fw = new FileWriter(new File(fileName),false);
		
		try {
			for(String word : words)
				fw.write(word + "\n");
			fw.close();
		}
		catch(IOException e) {
			System.out.println("ERROR: Unable to write to file " + fileName);
		}
	}
}
