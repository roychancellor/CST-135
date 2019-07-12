package cst135.commonbeginningofwords;

import java.io.IOException;

public class Controller {

	public static void main(String[] args) throws IOException {
		
		// Adding comments
		// Adding more comments
		LongestCommonString lcs = new LongestCommonString();
		Writer wr = new Writer();
		
		//Get words from the user
		wr.getWords();
		//Get file name from the user
		wr.getUserFileName();
		//Write words to the file the user entered
		wr.writeWords();
		
		//Read words from the file
		lcs.readWords(wr.getFileName());
		
		//Print the words
		System.out.println("The words to process are:");
		for(String word : lcs.getWords())
			System.out.println("\t" + word);
		
		//Find the longest common beginning string
		System.out.println("Largest common string: " + lcs.longestCommon());
		
		//Write the common string to a file
		lcs.writeCommonString();
	}

}
