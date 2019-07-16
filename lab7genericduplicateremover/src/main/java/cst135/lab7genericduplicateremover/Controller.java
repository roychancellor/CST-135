package cst135.lab7genericduplicateremover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.reflect.Field;

public class Controller {
	//Declare three lists of different types which will be populated, sorted, and printed
	private static List<Integer> intList = new ArrayList<Integer>();
	private static List<String> wordList = new ArrayList<String>();
	private static List<Character> charList = new ArrayList<Character>();
	
	//Make a GenericSort object to call methods in the GenericSort class
	private static GenericSort gs = new GenericSort();
	
	//Get the declared fields in the Controller class (i.e. intList, wordList, etc)
	//and stored them in an array of Field objects
	//fields[0] will have the name of the first declared field of the class, etc.
	private static Field[] fields = Controller.class.getDeclaredFields();

	/**
	 * main method of the Controller class
	 * @param args
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static void main(String[] args) {
		//Read in a list of Integers, print, sort, print, remove duplicates, and print
		//fields[0].getName() returns the full name of the first declared field,
		//in this case intList which is the string "java.util.List<java.lang.Integer>"
		System.out.println("Original Integers:");
		readList("numbers.txt", fields[0].getName(), intList);
		gs.printList(intList);
		gs.sort(intList);
		System.out.println("\nSorted Integers:");
		gs.printList(intList);
		System.out.println("\nDuplicate Integers removed:");
		gs.removeDuplicates(intList);
		gs.printList(intList);

		//Read in a list of Strings, print, sort, print, remove duplicates, and print
		//fields[1].getName() returns the full name of the second declared field,
		//in this case wordList which is the string "java.util.List<java.lang.String>"
		System.out.println("\n\nOriginal Strings:");
		readList("words.txt", fields[1].getName(), wordList);
		gs.printList(wordList);
		gs.sort(wordList);
		System.out.println("\nSorted Strings:");
		gs.printList(wordList);
		System.out.println("\nDuplicate Strings removed:");
		gs.removeDuplicates(wordList);
		gs.printList(wordList);

		//Read in a list of Characters, print, sort, print, remove duplicates, and print
		//fields[2].getName() returns the full name of the third declared field,
		//in this case charList which is the string "java.util.List<java.lang.Character>"
		System.out.println("\n\nOriginal Characters:");
		readList("chars.txt", fields[2].getName(), charList);
		gs.printList(charList);
		gs.sort(charList);
		System.out.println("\nSorted Characters:");
		gs.printList(charList);
		System.out.println("\nDuplicate Characters removed:");
		gs.removeDuplicates(charList);
		gs.printList(charList);
}
	
	/**
	 * Reads a list of Integers, Strings, or Characters from a file
	 * Determines what method to parse each line of text based on the
	 * generic type of the list name passed in
	 * @param fileName
	 * @param listName
	 */
	public static <E> void readList(String fileName, String listName, List<? extends Object> list) {
		//Read into List by type of list
		try {
			//Get the full name of the field having the name of the argument listName
			Field field = Controller.class.getDeclaredField(listName);
			
			//Open a Scanner to read from fileName
			Scanner sc = new Scanner(new File(fileName));
			
			//While there are lines to read, check the type of the field and read/parse accordingly
			while(sc.hasNext()) {
				//field.getGenericType().toString() returns the String representation of the
				//full field name. Comparing to a pre-determined string enables type-specific
				//parsing of the lines read from the file
				if(field.getGenericType().toString().equals("java.util.List<java.lang.Integer>")) {
					intList.add(Integer.parseInt(sc.nextLine()));
					//list.add(Integer.parseInt(sc.nextLine()));
				}
				else if(field.getGenericType().toString().equals("java.util.List<java.lang.String>")) {
					wordList.add(sc.nextLine());
				}
				else if(field.getGenericType().toString().equals("java.util.List<java.lang.Character>")) {
					charList.add(sc.nextLine().charAt(0));
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR: File " + fileName + " not found.");
		}
		catch(NumberFormatException e) {
			System.out.println("ERROR: Unable to convert.");
		}
		catch (NoSuchFieldException e) {
			System.out.println("No such field " + listName);
		}
		catch (SecurityException e) {
			System.out.println("Ya done messed up a-a-ron!");
		}

	}
}
