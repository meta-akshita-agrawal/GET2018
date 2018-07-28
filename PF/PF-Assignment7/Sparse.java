
public class Sparse {

	int[][] sparseArray;
	int rowSize;
	int colSize;
	int length;

	//Constructor initializing sparse matrix
	//rowSize and colSize are size of original matrix
	Sparse(int[][] sparseArray, int rowSize, int colSize) {
		this.sparseArray = sparseArray;
		this.rowSize = rowSize;
		this.colSize = colSize;
		if(!isSorted()) {
			throw new AssertionError("Sparse matrix should be sorted");
		}
	}
	
	private boolean isSorted(){
		for(int i=0;i<sparseArray.length-1;i++) {
			if((sparseArray[i][0] > sparseArray[i+1][0]) || (sparseArray[i][0] == sparseArray[i+1][0] && sparseArray[i][1] > sparseArray[i+1][1])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Evaluates transpose of a sparse matrix which is done by
	 * changing rows to columns and vice versa
	 * @return an array, which is a transpose 
	 */
	int[][] transpose() {

		//Used COUNTING SORT 
		//Initialized count array by size of columns in original array
		//every element will be initially 0
		int[] count = new int[colSize];
		int[][] transposedArray = new int[sparseArray.length][3];
 
		//adding values by counting the frequency of each value
		//and placing the frequency in the index which is associated to that value
		// example if frequency of 2  is 1, it will be placed in count[2]
		for (int i = 0; i < sparseArray.length; i++) {
			count[sparseArray[i][1]]++;
		}

		//updating values by summing last with the current one
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i - 1] + count[i];
		}

		//placing values at right place
		for (int i = sparseArray.length - 1; i >= 0; i--) {
			int countIndex = count[sparseArray[i][1]]-- - 1;
			//adding these values to transposed array
			transposedArray[countIndex][0] = sparseArray[i][1];
			transposedArray[countIndex][1] = sparseArray[i][0];
			transposedArray[countIndex][2] = sparseArray[i][2];

		}
		return transposedArray;
	}

	/**
	 * Checks if a matrix is Symmetric matrix 
	 * If you transpose it you get the same result
	 * @return true if it is symmetric else false
	 */
	boolean symmetry() {
		int[][] transposedArray = transpose();
		for (int i = 0; i < sparseArray.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(sparseArray[i][j] == transposedArray[i][j]))
					return false;
			}
		}

		return true;
	}

	/**
	 * Adds 2 sparse matrices and produce a newly added sparse matrix
	 * @param s1, object of second matrix
	 * first array will be automatically used when invoking this method by object of first matrix
	 * @return an array, added sparse matrix
	 */
	int[][] add(Sparse s1) {

		int[][] arrayA = sparseArray;
		int[][] arrayB = s1.sparseArray;
		int[][] result = new int[arrayA.length + arrayB.length][3]; // resultant matrix can have maximum of both matrices sum
		
		int pointerA = 0;//pointer for array A
		int pointerB = 0;//pointer for array B
		int remainingPointer = 0;//This will be used for remaining elements to add in the resultant array

		for (int i = 0; i < result.length; i++) {

			int dataA0 = arrayA[pointerA][0];
			int dataA1 = arrayA[pointerA][1];
			
			int dataB0 = arrayB[pointerB][0];
			int dataB1 = arrayB[pointerB][1];

			//If we find an index same in both sparse matrix
			if (dataA0 == dataB0 && dataA1 == dataB1) {
				result[i][0] = dataA0;
				result[i][1] = dataA1;
				result[i][2] = arrayA[pointerA][2] + arrayB[pointerB][2];

				pointerA++;
				pointerB++;
			} 
			//if we find index of array A less than B
			else if ((dataA0 == dataB0 && dataA1 < dataB1) || dataA0 < dataB0) {
				result[i][0] = dataA0;
				result[i][1] = dataA1;
				result[i][2] = arrayA[pointerA][2];

				pointerA++;
			} 
			//if we find index of array B less than A
			else if ((dataA0 == dataB0 && dataA1 > dataB1) || dataA0 > dataB0) {
				result[i][0] = dataB0;
				result[i][1] = dataB1;
				result[i][2] = arrayB[pointerB][2];

				pointerB++;
			}
			
			// if a pointer traverses the whole array then loop is closed
			// and remaining pointer is initialized with next pointer 
			// by which new values needs to be added in the resultant array
			if (pointerA == arrayA.length || pointerB == arrayB.length) {
				remainingPointer = i + 1;
				break;
			}
		}

		//if remaining elements are in array A
		//Simply add them
		if (pointerA < arrayA.length) {
			for (int i = remainingPointer; i < result.length - 1 && pointerA < arrayA.length; i++) {
				result[i][0] = arrayA[pointerA][0];
				result[i][1] = arrayA[pointerA][1];
				result[i][2] = arrayA[pointerA][2];
			}
		}
		
		//if remaining elements are in arrayA
		//Simply add them
		if (pointerB < arrayB.length) {
			for (int i = remainingPointer; i < result.length - 1 && pointerB < arrayB.length; i++) {
				result[i][0] = arrayB[pointerB][0];
				result[i][1] = arrayB[pointerB][1];
				result[i][2] = arrayB[pointerB][2];
			}
		}

		//an array containing only filled values
		int[][] trimmedResult = new int[remainingPointer + 1][3];

		for (int i = 0; i < trimmedResult.length; i++) {
			for (int j = 0; j < 3; j++) {
				trimmedResult[i][j] = result[i][j];
			}
		}

		return trimmedResult;

	}

	/**
	 * Multiplies 2 sparse matrices
	 * @param s1, an object of second matrix
	 * first array will be automatically used when invoking this method by object of first matrix
	 * @return an array, of multiplied sparse matrix
	 */
	int[][] multiply(Sparse s1) {
		int[][] arrayA = sparseArray;
		int[][] arrayB = s1.sparseArray;
		
		int maxLength = colSize * s1.rowSize; //MaxLength can be product of column size of first to row size of second
		int[][] result = new int[maxLength][3];
		
		int iResult = 0;//pointer for resultant matrix

		//Checking second column of sparse matrix to first column of second matrix
		// example A: [2][3] = 3
		// B: [3][1] = 5
		// an entry will be made as [2][1] = 3*5= 15
		for (int i = 0; i < arrayA.length; i++) {
			for (int j = 0; j < arrayB.length; j++) {
				if (arrayA[i][1] == arrayB[j][0]) {
					result[iResult][0] = arrayA[i][0];
					result[iResult][1] = arrayB[j][1];
					result[iResult][2] = arrayA[i][2] * arrayB[j][2];
					iResult++;
					if (iResult == result.length) {
						break;
					}
				}
				if (iResult == result.length) {
					break;
				}
			}
		}
		
		//if duplicate indices are found in the resultant matrix their values are added
		// [2][1] = 2 and [2][1] = 16
		// 2 entries saved in 1 as [2][1] = 18
		for (int i = iResult - 2; i >= 0; i--) {
			int pointer0 = result[iResult - 1][0];
			int pointer1 = result[iResult - 1][1];
			int data = result[iResult - 1][2];

			if (pointer0 == result[i][0] && pointer1 == result[i][1]) {
				result[i][0] = pointer0;
				result[i][1] = pointer1;
				result[i][2] += data;

				iResult--;
			}
		}
		
		//storing only non-zero values
		int[][] trimmedResult = new int[iResult][3];

		for (int i = 0; i < trimmedResult.length; i++) {
			for (int j = 0; j < 3; j++) {
				trimmedResult[i][j] = result[i][j];
			}
		}

		//sorting the multiplied sparse matrix
		int[][] sortedArray = sort(trimmedResult);

		return sortedArray;

	}

	/**
	 * Sorts 2D sparse matrix using bubble sort
	 * @param unsortedArray
	 * @return sortedArray
	 */
	private int[][] sort(int[][] unsortedArray) {
		int temp = 0;
		for (int i = 0; i < unsortedArray.length; i++) {
			for (int j = 1; j < unsortedArray.length - i; j++)
				if ((unsortedArray[j - 1][0] > unsortedArray[j][0]) || (unsortedArray[j - 1][0] == unsortedArray[j][0]
						&& unsortedArray[j - 1][1] > unsortedArray[j][1])) {
					temp = unsortedArray[j - 1][0];
					unsortedArray[j - 1][0] = unsortedArray[j][0];
					unsortedArray[j][0] = temp;

					temp = unsortedArray[j - 1][1];
					unsortedArray[j - 1][1] = unsortedArray[j][1];
					unsortedArray[j][1] = temp;

					temp = unsortedArray[j - 1][2];
					unsortedArray[j - 1][2] = unsortedArray[j][2];
					unsortedArray[j][2] = temp;

				}
		}
		return unsortedArray;
	}

}
