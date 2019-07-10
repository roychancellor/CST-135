package cst135.commonbeginningofwords;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LongestCommonString {
	private String[] words = new String[3];
	private String commonBeginning = "";
	
	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}

	//Read the words from a file and put into an array
	public void readWords(String fileName) throws FileNotFoundException {
		try {
			Scanner sc = new Scanner(new File(fileName));
			//Read words until none are available
			int i = 0;
			while(sc.hasNext() && i < words.length) {
				words[i] = sc.nextLine();
				i++;
			}
			sc.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR: " + fileName + " not found.");
		}
		
	}
	
	//Returns the longest common beginning string of three words (empty string if none)
	public String longestCommon() {
		//Get the shortest word length
		int shortestWordLength = Math.min(words[0].length(), Math.min(words[1].length(), words[2].length()));
		
		//Work left to right and compare characters until a mismatch occurs, then return the longest common string
		for(int i = 0; i < shortestWordLength; i++) {
			if(words[0].toLowerCase().charAt(i) == words[1].toLowerCase().charAt(i)
				&& words[0].toLowerCase().charAt(i) == words[2].toLowerCase().charAt(i)) {
				this.commonBeginning += words[0].toLowerCase().charAt(i);
			}
			else
				break;
		}
		
		return this.commonBeginning;
	}
	
	//Writes the common string to a file
	public void writeCommonString() throws IOException {
		String fileName = "common.txt";
		FileWriter fw = new FileWriter(new File(fileName));
		
		try {
			fw.write(this.commonBeginning);
			fw.close();
		}
		catch(IOException e) {
			System.out.println("ERROR: Unable to write to " + fileName);
		}
	}
}
