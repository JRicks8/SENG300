/**
 * 
 */
package com.allendowney.thinkdast;

import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author downey
 * Other additions by Jared Ricks for SENG 300, Ferris State University 2023
 */
public class SelectionSort {

	/**
	 * Swaps the elements at indexes i and j.
	 */
	public static void swapElements(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * Finds the index of the lowest value
	 * between indices low and high (inclusive).
	 */
	public static int indexLowest(int[] array, int start) {
		int lowIndex = start;
		for (int i = start; i < array.length; i++) {
			if (array[i] < array[lowIndex]) {
				lowIndex = i;
			}
		}
		return lowIndex;
	}

	/**
	 * Sorts the cards (in place) using selection sort.
	 */
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int j = indexLowest(array, i);
			swapElements(array, i, j);
		}
	}
	
	/**
	 * Retrieves an array of numbers from a text file.
	 * The text must have only integers (signed or unsigned) separated by commas, with no spaces
	 * Only the first line will be used.
	 * FORMAT NUMBER STRING LIKE THIS: "1,2,3,4,5,6,7,8,9,10"
	 * I utilized this website to generate my data sets:
	 * https://numbergenerator.org/numberlistrandomizer#!numbers=5000&lines=1&range=1-1000&unique=true&order_matters=false&csv=&oddeven=&oddqty=0&sorted=false&addfilters=
	 */
	private static int[] getArrayFromTextFile() {
		int[] numberList = new int[0];
		try {
			File textFile = new File("./inputText.txt"); // INPUT TEXT FILE
			
			Scanner reader = new Scanner(textFile);
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				String[] numberStrings = data.split(",");
				numberList = new int[numberStrings.length];
				for (int i = 0; i < numberList.length; i++) {
					numberList[i] = Integer.parseInt(numberStrings[i]);
				}
			}
			reader.close();
			return numberList;
		} catch (FileNotFoundException e) {
			System.out.println("An error has occurred and the program was not able to run.");
			e.printStackTrace();
		}
		return new int[0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting.");
		System.out.println("Parsing numbers from file...");
		
		long timeStart = System.currentTimeMillis();
		int[] array = getArrayFromTextFile();
		long timeDoneReading = System.currentTimeMillis();
		
		System.out.println("Sorting numbers...");
		
		long timeStartSort = System.currentTimeMillis();
		selectionSort(array);
		long timeFinished = System.currentTimeMillis();
		
		System.out.println(
				"Finished. Read time: " + (timeDoneReading - timeStart) + 
				". Sort time: " + (timeFinished - timeStartSort) + 
				". Total time: " + (timeFinished - timeStart) + ".");
		System.out.println("Result: " + Arrays.toString(array));
	}
}