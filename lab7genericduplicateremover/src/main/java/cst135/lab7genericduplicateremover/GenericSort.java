package cst135.lab7genericduplicateremover;

import java.util.List;

public class GenericSort {
	public <E extends Comparable<E>> void sort(List<E> list) {
		E currentMin;
		int currentMinIndex;
		
		for(int i = 0; i < list.size() - 1; i++) {
			//Find the minimum in the list [i+1..list.size() - 2]
			currentMin = list.get(i);
			currentMinIndex = i;
			
			for(int j = i + 1; j < list.size(); j++) {
				if(currentMin.compareTo(list.get(j)) > 0) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}
			
			//Swap list.get(i) with list[currentMinIndex] if necessary
			if(currentMinIndex != i) {
				list.set(currentMinIndex,list.get(i));
				list.set(i, currentMin);
			}
		}
	}
	
	//Print an array of objects
	public <E> void printList(List<E> list) {
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
	}
	
	//Remove duplicates from a list
	public <E> void removeDuplicates(List<E> dupList) {
		int i = 1;
		while(i < dupList.size()) {
			if(dupList.get(i).equals(dupList.get(i - 1))) {
				dupList.remove(i);
			}
			else {
				i++;
			}
		}
	}

}
