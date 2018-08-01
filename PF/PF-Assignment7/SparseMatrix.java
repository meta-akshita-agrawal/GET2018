
public class SparseMatrix {

	int[][] sparseArray;
	int rowSize;
	int colSize;
	int length;

	//Constructor initializing sparse matrix
	//rowSize and colSize are size of original matrix
	SparseMatrix(int[][] sparseArray, int rowSize, int colSize) {
		
		this.sparseArray = sparseArray;
		this.rowSize = rowSize;
		this.colSize = colSize;
		
		if(!isSorted()) {
			throw new AssertionError("Sparse matrix should be sorted");
		}
		
		if(sparseArray.length == 0) {
			throw new AssertionError("Array is empty");
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
	int[][] add(SparseMatrix s1) {

		int[][] arrayA = sparseArray;
		int[][] arrayB = s1.sparseArray;
		int[][] arraySum = new int[arrayA.length + arrayB.length][3]; // resultant matrix can have maximum of both matrices sum
		
		int pointerA = 0;//pointer for array A
		int pointerB = 0;//pointer for array B
		int remainingPointer = 0;//This will be used for remaining elements to add in the resultant array

		for (int i = 0; i < arraySum.length; i++) {

			int rowA = arrayA[pointerA][0];
			int colA = arrayA[pointerA][1];
			
			int rowB = arrayB[pointerB][0];
			int colB = arrayB[pointerB][1];

			//If we find an index same in both sparse matrix
			if (rowA == rowB && colA == colB) {
				
				int sum = arrayA[pointerA][2] + arrayB[pointerB][2];
				
				comparisonAssignment(arraySum,i,rowA,colA,sum);

				pointerA++;
				pointerB++;
			} 
			//if we find index of array A less than B
			else if ((rowA == rowB && colA < colB) || rowA < rowB) {
				
				comparisonAssignment(arraySum,i,rowA,colA,arrayA[pointerA][2]);

				pointerA++;
			} 
			//if we find index of array B less than A
			else if ((rowA == rowB && colA > colB) || rowA > rowB) {
				
				comparisonAssignment(arraySum,i,rowB,colB,arrayB[pointerB][2]);

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

		int finalPointer = remainingPointer;
		
		//if remaining elements are in array A
		//Simply add them
		if (pointerA < arrayA.length) {
			for (int i = remainingPointer; i < arraySum.length - 1 && pointerA < arrayA.length; i++) {
				comparisonAssignment(arraySum,i,arrayA[pointerA][0],arrayA[pointerA][1],arrayA[pointerA][2]);
				finalPointer = i;
			}
		}
		
		//if remaining elements are in arrayA
		//Simply add them
		if (pointerB < arrayB.length) {
			for (int i = remainingPointer; i < arraySum.length - 1 && pointerB < arrayB.length; i++) {
				comparisonAssignment(arraySum,i,arrayB[pointerB][0],arrayB[pointerB][1],arrayB[pointerB][2]);
				finalPointer = i;
			}
		}

		//an array containing only filled values
		int[][] trimmedResult = new int[finalPointer][3];

		for (int i = 0; i < trimmedResult.length; i++) {
			for (int j = 0; j < 3; j++) {
				trimmedResult[i][j] = arraySum[i][j];
			}
		}

		return trimmedResult;

	}
	
	/**
	 * This method will assign values to at index 0,1,2 in each row of a matrix
	 * @param result, array to perform operation
	 * @param i, row in which indices needs to be changed
	 * @param row
	 * @param col
	 * @param data, data at [row][col]
	 * @return result, final array
	 */
	private int[][] comparisonAssignment(int[][] result, int i, int row, int col, int data){
		result[i][0] = row;
		result[i][1] = col;
		result[i][2] = data;
		return result;
	}

	/**
	 * Multiplies 2 sparse matrices
	 * @param s1, an object of second matrix
	 * first array will be automatically used when invoking this method by object of first matrix
	 * @return an array, of multiplied sparse matrix
	 */
	int[][] multiply(SparseMatrix s1) {
		int[][] arrayA = sparseArray;
		int[][] arrayB = s1.sparseArray;
		
		int maxLength = colSize * s1.rowSize; //MaxLength can be product of column size of first to row size of second
		int[][] arrayMul = new int[maxLength][3];
		
		int iResult = 0;//pointer for resultant matrix

		//Checking second column of sparse matrix to first column of second matrix
		// example A: [2][3] = 3
		// B: [3][1] = 5
		// an entry will be made as [2][1] = 3*5= 15
		for (int i = 0; i < arrayA.length; i++) {
			for (int j = 0; j < arrayB.length; j++) {
				if (arrayA[i][1] == arrayB[j][0]) {
					
					int multiplication = arrayA[i][2] * arrayB[j][2];
					
					comparisonAssignment(arrayMul,iResult,arrayA[i][0],arrayB[j][1],multiplication);
					
					iResult++;
					if (iResult == arrayMul.length) {
						break;
					}
				}
				if (iResult == arrayMul.length) {
					break;
				}
			}
		}
		
		//if duplicate indices are found in the resultant matrix their values are added
		// [2][1] = 2 and [2][1] = 16
		// 2 entries saved in 1 as [2][1] = 18
		for (int i = iResult - 2; i >= 0; i--) {
			int pointer0 = arrayMul[iResult - 1][0];
			int pointer1 = arrayMul[iResult - 1][1];
			int data = arrayMul[iResult - 1][2];

			if (pointer0 == arrayMul[i][0] && pointer1 == arrayMul[i][1]) {
				
				arrayMul[i][0] = pointer0;
				arrayMul[i][1] = pointer1;
				arrayMul[i][2] += data;

				iResult--;
			}
		}
		
		//storing only non-zero values
		int[][] trimmedResult = new int[iResult][3];

		for (int i = 0; i < trimmedResult.length; i++) {
			for (int j = 0; j < 3; j++) {
				trimmedResult[i][j] = arrayMul[i][j];
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
		for (int i = 0; i < unsortedArray.length; i++) {
			for (int j = 1; j < unsortedArray.length - i; j++)
				if ((unsortedArray[j - 1][0] > unsortedArray[j][0]) || (unsortedArray[j - 1][0] == unsortedArray[j][0]
						&& unsortedArray[j - 1][1] > unsortedArray[j][1])) {
					
					swap(unsortedArray,j,0);
					
					swap(unsortedArray,j,1);
					
					swap(unsortedArray,j,2);

				}
		}
		return unsortedArray;
	}
	
	/**
	 * Swaps 2 elements at [i-1][j] and [i][j]
	 * @param unsortedArray, array to perform operation
	 * @param i, row index
	 * @param j, col index
	 * @return unsortedArray
	 */
	private int[][] swap(int[][] unsortedArray,int i,int j){
		int temp;
		
		temp = unsortedArray[i - 1][j];
		unsortedArray[i - 1][j] = unsortedArray[i][j];
		unsortedArray[i][j] = temp;
		
		return unsortedArray;
	}

}
