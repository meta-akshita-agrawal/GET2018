package testingAssignment;
import java.util.*;



public class ArrOperation {

	/**
	 * Evaluates maximum size of a mirror in an array
	 * @param maxMirror, an array which needs to be evaluated
	 * @return size of a number which contains a reverse of it in th array ot itself is a mirror.
	 */
	int maximumMirror(int[] maxMirror){
		
		if(maxMirror.length == 0){
			throw new AssertionError("Array is Empty");
		}
		
		
		int maximum = 0;
		int start=0;
		int end=0;
		for(int i=0 ; i<maxMirror.length; i++){
			
			for(int j=i+1; j<maxMirror.length; j++){
				int number = 0;
				if(maxMirror[i] == maxMirror[j]){
					start = i;
					end = j;
					while((end != -1 && start != maxMirror.length) && (maxMirror[start] == maxMirror[end])){
						start = start + 1;
						end = end - 1;
						number++;
					}
				}
				if(maximum<number){
					maximum = number;
				}
			}
		}
		return maximum;
	}
	
	
	/**
	 * Calculates number of clumps in an array
	 * @param countClumps, an array
	 * @return number of clumps
	 */
	int calClumps(int[] countClumps) {
		
		if(countClumps.length == 0){
			throw new AssertionError("Array is Empty");
		}
		
		int prevElement = countClumps[0];
		int count = 0;
		int flag = 0;
		for(int i = 1; i<countClumps.length; i++) {
			if(prevElement == countClumps[i]) {
				flag = 1;
				continue;
			}
			else if(flag==1){
				count++;
				prevElement = countClumps[i];
				flag = 0;
			}
			else {
				prevElement = countClumps[i];
			}
		}
		if(countClumps[countClumps.length -1] == countClumps[countClumps.length -2])
			count = count + 1;
		return count;
	}
	
	/**
	 * It sets Y after each X without changing position of X.
	 * @param fixArray, an array needs to be changed
	 * @param X
	 * @param Y
	 * @return changed array fixing each Y after X
	 */
	int[] fixMethod(int[] fixArray, int X, int Y) {
		
		if(fixArray.length == 0){
			throw new AssertionError("Array is Empty");
		}
		if(fixArray[fixArray.length-1] == X){
			throw new AssertionError("Last element should not be X");
		}
		
		
		
		ArrayList<Integer> indexX = new ArrayList<Integer>();
		ArrayList<Integer> indexY = new ArrayList<Integer>();
		indexX = find(fixArray,indexX,X);
		indexY = find(fixArray,indexY,Y);

		if(indexX.size() != indexY.size()){
			throw new AssertionError("X and Y should be equal");
		}
		if(adjacentX(indexX)){
			throw new AssertionError("Array should not contain adjacent X");
		}
		
		
		int temp;
		
		


		for(int i=0; i<indexX.size();i++){
			
			if(fixArray[indexX.get(i) + 1] == fixArray[indexY.get(i)])
				indexY.set(i+1, indexY.get(i));
			temp = fixArray[indexX.get(i) + 1];
			fixArray[indexX.get(i) + 1] = fixArray[indexY.get(i)];
			fixArray[indexY.get(i)] = temp;
		}
		return fixArray;
	}

	
	/**
	 * Find position of every X or Y in the array
	 * @param fixArray, an array
	 * @param index, an arraylist which will store positions of X and Y
	 * @param key, X or Y
	 * @return arraylist with positions of X or Y
	 */
	ArrayList<Integer> find(int[] fixArray, ArrayList<Integer> index, int key) {
		for(int i=0; i<fixArray.length ; i++) {
			if(key == fixArray[i])
				index.add(i);
		}
		return index;
	}
	
	/**
	 * Checks whether if any X are adjacent to each other.
	 * @param arr, an array which needs to be checked
	 * @return true if they are adjacent else false
	 */
	boolean adjacentX(ArrayList<Integer> arr){
		for(int i = 0; i <= arr.size() - 2 ; i++ ){
			if(arr.get(i) + 1 == arr.get(i+1)){
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
	 * Splits an array such that sum of both splits is equal
	 * @param splitArray, an array
	 * @return index from which split should be done
	 */
	int splitSum(int[] splitArray) {
		
		if(splitArray.length == 0){
			throw new AssertionError("Array is Empty");
		}
		
		int i=0;
		int j= splitArray.length - 1;
		int leftSum = splitArray[i];
		int rightSum = splitArray[j]; 
		while(i+1<j) {
			if(rightSum<leftSum) {
				rightSum += splitArray[j-1];
				j = j-1;
			}
			else {
				leftSum += splitArray[i+1];
				i = i+1;
			}
		}
		if(rightSum == leftSum)
			return j;
		return -1;
	}
	
}	

	


