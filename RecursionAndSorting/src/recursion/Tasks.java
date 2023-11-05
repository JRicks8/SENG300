package recursion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tasks {
	public static void main(String args[]) {
//		System.out.println(implementation(0,0));
//		System.out.println(implementation(-10,0));
//		System.out.println(implementation(0,-7));
//		System.out.println(implementation(1,5));
//		System.out.println(implementation(10,5));
//		
//		System.out.println(fun1(0,0));
//		System.out.println("Stack Overflow Error");
//		//System.out.println(fun1(-10,0));
//		System.out.println(fun1(0,-7));
//		System.out.println(fun1(1,5));
//		System.out.println(fun1(10,5));
//		
//		System.out.println();
//		System.out.println("Recursive Function for finding the first lowercase char results: ");
//		System.out.println("Input: Hello!");
//		System.out.println("Output: " + findFirstLowercase(0, "Hello!"));
//		System.out.println("Input: blah");
//		System.out.println("Output: " + findFirstLowercase(0, "blah"));
//		System.out.println("Input: AHHHHHHHH");
//		System.out.println("Output: " + findFirstLowercase(0, "AHHHHHHHH"));
		
		compareSortingAlgorithms();
	}
	
	static int fun1(int x, int y) {
		if (x == 0) return y;
		else return fun1(x - 1, x + y);
	}
	
	static int implementation(int x, int y) {
		if (x < 0) {
			System.out.print("Stack Overflow Error: x is less than 0: ");
			return x;
		}
		while (true) {
			if (x == 0) return y;
			else y += x;
			x--;
		}
	}
	
	static int findFirstLowercase(int index, String string) {
		if (index >= string.length() || index < 0) {
			System.out.println("Error in execution of findFirstLowercase: Index OOB");
			return -1;
		}
		if (Character.isLowerCase(string.charAt(index))) return index;
		else return findFirstLowercase(index + 1, string);
	}
	
	static void compareSortingAlgorithms() {
		System.out.println("\nComparing Sorting Algorithms");
		int[] input = readFile();
		
		//insertionSort(input.clone());
		mergeSort(input.clone());
		//bubbleSort(input.clone());
		//selectionSort(input.clone());
		quickSort(input.clone());
		
		long start = System.currentTimeMillis();
		Arrays.sort(input.clone());
		long finish = System.currentTimeMillis();
		System.out.println("Time for Java Arrays.sort(): " + (finish - start));
		
		System.out.println("Done.");
	}
	
	// QUICK SORT
	static void quickSort(int[] arr) {
		long start = System.currentTimeMillis();
		quickSort(arr, 0, arr.length - 1);
		long finish = System.currentTimeMillis();
		System.out.println("Time for quick sort: " + (finish - start));
	}
	
	private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // INSERTION SORT
	static void insertionSort(int[] arr) {
		long start = System.currentTimeMillis();
		for (int i = 1; i < arr.length; i++) {
	        int val = arr[i];
	        int j = i - 1;

	        while (j >= 0 && arr[j] > val) {
	            arr[j + 1] = arr[j];
	            j--;
	        }

	        arr[j + 1] = val;
	    }
		
		long finish = System.currentTimeMillis();
		System.out.println("Time for insertion sort: " + (finish - start));
	}
	
	// MERGE SORT
	static void mergeSort(int[] arr) {
		long start = System.currentTimeMillis();
        if (arr == null || arr.length <= 1) {
            return;
        }

        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        
        long finish = System.currentTimeMillis();
		System.out.println("Time for merge sort: " + (finish - start));
    }
	
	static void mergeSort(int[] arr, int[] temp, int left, int right) {
		if (left < right) {
            int mid = (left + right) / 2;

            // In the spirit of recent assignments on recursion, I used some recursion myself!
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);

            // merge the halves
            for (int i = left; i <= right; i++) {
                temp[i] = arr[i];
            }

            int i = left;
            int j = mid + 1;
            int k = left;

            while (i <= mid && j <= right) {
                if (temp[i] <= temp[j]) {
                    arr[k] = temp[i];
                    i++;
                } else {
                    arr[k] = temp[j];
                    j++;
                }
                k++;
            }

            while (i <= mid) {
                arr[k] = temp[i];
                i++;
                k++;
            }
        }
	}
	
	// BUBBLE SORT
	static void bubbleSort(int[] arr) {
		long start = System.currentTimeMillis();
		int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                	// swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // if none swapped, we're done
            if (!swapped) {
                break;
            }
        }
        
        long finish = System.currentTimeMillis();
		System.out.println("Time for bubble sort: " + (finish - start));
	}
	
	// SELECTION SORT
	static void selectionSort(int[] arr) {
		long start = System.currentTimeMillis();
		int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // minimum element in unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap min with index
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        
        long finish = System.currentTimeMillis();
		System.out.println("Time for selection sort: " + (finish - start));
	}
	
	static int[] readFile() {
		try {
            String filePath = "./src/recursion/Input.txt";
            
            Scanner scanner = new Scanner(new File(filePath));

            ArrayList<Integer> integerList = new ArrayList<>();
            
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                integerList.add(number);
            }
            scanner.close();

            int[] integerArray = new int[integerList.size()];
            for (int i = 0; i < integerList.size(); i++) {
                integerArray[i] = integerList.get(i);
            }
            
            return integerArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
	
	static void printArray(int[] arr) {
		System.out.print("Output: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}