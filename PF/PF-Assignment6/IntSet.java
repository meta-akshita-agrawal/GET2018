import java.util.ArrayList;
import java.util.stream.IntStream;

public final class IntSet {

	int[] setArray;
	ArrayList<Integer> setArrayList;

	// Constructor initializing set and retaining its properties
	IntSet(int[] setArray) {
		this.setArray = setArray;

		// checks if set is sorted or not
		if (!arraySortedOrNot(this.setArray, this.setArray.length)) {
			throw new AssertionError("Set should be sorted.");
		}

		// set should not have duplicates
		if (!isDuplicate()) {
			throw new AssertionError("Set should not have duplicates");
		}

		// set should not be empty
		if (setArray.length == 0) {
			throw new AssertionError("Set should not be empty");
		}

	}

	// checks if an array is sorted
	private boolean arraySortedOrNot(int arr[], int n) {
		// if array is empty or contain only one element
		if (n == 1 || n == 0)
			return true;

		// Unsorted pair found (Equal values allowed)
		if (arr[n - 1] < arr[n - 2])
			return false;

		// Keep on checking
		return arraySortedOrNot(arr, n - 1);
	}

	// checks if an array contains duplicates
	private boolean isDuplicate() {
		for (int i = 0; i < setArray.length - 1; i++) {
			if (setArray[i] == setArray[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if an element is a member of a set.
	 * @param x, element
	 * @return true if set contains element else false
	 */
	boolean isMember(int x) {
		for (int s : setArray) {
			if (s == x)
				return true;
		}
		return false;
	}

	/**
	 * gets length of set
	 * @return length
	 */
	int size() {
		return setArray.length;
	}

	/**
	 * Checks whether a set is a subset of another set setArray
	 * @param s, object of set which needs to be checked
	 * @return true if it is, else false
	 */
	boolean isSubSet(IntSet s) {
		int counter = 0;
		int flag = -1;
		int start = s.setArray[0];
		
		//Checking if first element of s is present in setArray
		//If yes then it will store that index in flag
		for (int i = 0; i < setArray.length; i++) {
			if (setArray[i] == start) {
				flag = i;
				break;
			}
		}
		
		//if this flag is stored with some index from setArray
		// it will loop from start to length of s subset.
		// and counts simultaneously.
		if (flag != -1) {
			for (int i = flag; i < setArray.length
					&& counter < s.setArray.length; i++) {
				if (setArray[i] == s.setArray[counter]) {
					counter++;//counting
				} else
					break;
			}
		}
		//if counter is equal to length of subset 
		//that means every element of it, is present in setArray
		if (counter == s.setArray.length)
			return true;

		return false;
	}
	
	/**
	 * Gets complement from the universal set which is 1...1000
	 * @return complement array
	 */
	int[] getComplement() {
		int[] universal = IntStream.rangeClosed(1, 1000).toArray();//added values from 1-1000 to universal array
		int size = universal.length - setArray.length; //size of complement array
		int[] complement = new int[size];
		int k = 0;
		for (int i = 0; k < complement.length && i < universal.length; i++) {
			if (!isMember(universal[i])) {
				complement[k++] = universal[i];
			} else {
				continue;
			}
		}

		return complement;
	}

	/**
	 * Evaluates Union of 2 sets
	 * @param s1, object of first set
	 * @param s2, object of second set
	 * @return, a union array
	 */
	int[] union(IntSet s1, IntSet s2) {
		//If s2 is subset of s1 return s1 as it is.
		if(s1.isSubSet(s2)){
			return s1.setArray;
		}
		ArrayList<Integer> notCommonItems = notCommonItems(s1, s2);
		int newArraySize = notCommonItems.size();
		int[] newArray = new int[newArraySize];
		for (int i = 0; i < newArraySize; i++) {
			newArray[i] = notCommonItems.get(i);
		}
		sort(newArray);
		return newArray;
	}

	
	//Sorts an array
	private int[] sort(int[] sortedArray) {
		int temp;
		for (int i = 0; i < sortedArray.length; i++) {
			for (int j = 0; j < sortedArray.length; j++) {
				if (sortedArray[i] < sortedArray[j]) {
					temp = sortedArray[i];
					sortedArray[i] = sortedArray[j];
					sortedArray[j] = temp;
				}
			}
		}
		return sortedArray;
	}

	//returns an array which keeps only one element from common elements
	private ArrayList<Integer> notCommonItems(IntSet s1, IntSet s2) {
		ArrayList<Integer> notCommonItems = new ArrayList<>();
		//adds all values from set 1
		for (int i = 0; i < s1.setArray.length; i++) {
			notCommonItems.add(s1.setArray[i]);
		}
		// if any element from set2 is also present it continues otherwise add it.
		for (int i = 0; i < s2.setArray.length; i++) {
			if (s1.isMember(s2.setArray[i])) {
				continue;
			} else {
				notCommonItems.add(s2.setArray[i]);
			}
		}
		return notCommonItems;
	}

}
