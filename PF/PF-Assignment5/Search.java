
package recursionAssignment;

public class Search {

	
	/**
	 * Searches an element by dividing array in equal halves recursively.
	 * @param sortedArray, an array which is sorted and need to be searched
	 * @param start, starting position where search should start
	 * @param end, ending position where search should end
	 * @param key, element which needs to be found
	 * @return key else -1 if not found
	 */
	int binarySearch(int arr[], int start, int end, int key)
	{
	   if(!arraySortedOrNot(arr,arr.length-1)){
			throw new AssertionError("Array is not sorted");
		}
		
		
		if (end >= start)
	   {
	        int mid = start + (end - start)/2;
	 
	        // If the element is present at the middle itself
	        if (arr[mid] == key)  return mid;
	 
	        // If element is smaller than mid, then it can only be present
	        // in left subarray
	        if (arr[mid] > key) return binarySearch(arr, start, mid-1, key);
	 
	        // Else the element can only be present in right subarray
	        return binarySearch(arr, mid+1, end , key);
	   }
	 
	   // We reach here when element is not present in array
	   return -1;
	}
	
	
	//Returns index with parameters array and key to be found.
	int binaryCall(int[] sortedArray,int key){
		return binarySearch(sortedArray,0,sortedArray.length-1,key);
	}
	
	
	boolean arraySortedOrNot(int arr[], int n){
	        // Array has one or no element or the
	        // rest are already checked and approved.
	        if (n == 1 || n == 0)
	            return true;
	      
	        // Unsorted pair found (Equal values allowed)
	        if (arr[n-1] < arr[n-2])
	            return false;
	      
	        // Last pair was sorted
	        // Keep on checking
	        return arraySortedOrNot(arr, n-1);
	}
	
	/**
	 * Searches an element sequentially
	 * @param arr, an array which needs to be searched.
	 * @param lower, index which is updated sequentially
	 * @param upper, last index of array
	 * @param key, elements that needs to be found.
	 * @return key else -1 if not found.
	 */
	int linearSearch(int arr[], int lower, int upper, int key)
    {
         if (upper < lower)
            return -1;
         if (arr[lower] == key)
            return lower;
         return linearSearch(arr, lower+1, upper, key);
    }
	
	
	int linearCall(int arr[], int key){
		return linearSearch(arr,0,arr.length-1,key);
	}

}
