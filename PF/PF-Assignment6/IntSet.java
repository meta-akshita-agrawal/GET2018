import java.util.ArrayList;
import java.util.stream.IntStream;


public final class IntSet {
	final int MAX = 1000;
	int[] setArray;
	ArrayList<Integer> setArrayList;
	
	IntSet(int[] set){
		this.setArray = set;
	}
	

	
	void initialize(int size){
		setArray = new int[size];
	}
	
	boolean isMember(int x){
		for(int s: setArray){
			if(s==x)
				return true;
		}
		return false;
	}
	
	int size(){
		return setArray.length;
	}
	
	boolean isSubSet(IntSet s){
		int counter=0;
		int flag = -1;
		int start = s.setArray[0];
		//System.out.println(start + "" + end);
		for(int i=0;i<setArray.length -1; i++){
			if(setArray[i]== start){
				flag = i;
				break;
			}
		}
		
		if(flag!=-1){
			for(int i=flag; i<setArray.length-1&&counter<s.setArray.length;i++){
				if(setArray[i]==s.setArray[counter]){
					counter++;
				}
				else
					break;
			}
		}
		if(counter==s.setArray.length)
			return true;
		
		return false;
	}
	
	
	int[] getComplement(){
		int[] universal =IntStream.rangeClosed(1, 1000).toArray();
		int size = universal.length - setArray.length;
		int[] complement = new int[size];
		int k =0;
		for(int i=0;k<complement.length && i<universal.length;i++){
			if(!isMember(universal[i])){
				complement[k++] = universal[i];
			}
			else{
				continue;
			}
		}
		
		return complement;
	}
	
	
	int[] union(IntSet s1, IntSet s2){
		ArrayList<Integer> notCommonItems = notCommonItems(s1,s2);
		int newArraySize = notCommonItems.size();
		int[] newArray = new int[newArraySize];
		for(int i = 0; i<newArraySize;i++){
			newArray[i] = notCommonItems.get(i);
		}
		sort(newArray);
		return newArray;
	}
	
	
	int[] sort(int[] sortedArray){
		int temp;
		for(int i=0;i<sortedArray.length ; i++){
			for(int j=0;j<sortedArray.length;j++){
				if(sortedArray[i] < sortedArray[j]){
					temp = sortedArray[i];
					sortedArray[i] = sortedArray[j];
					sortedArray[j] = temp;
				}
			}
		}
		return sortedArray;
	}
	
	private ArrayList<Integer> notCommonItems(IntSet s1, IntSet s2){
		ArrayList<Integer> notCommonItems = new ArrayList<>();
		for(int i=0;i<s1.setArray.length;i++){
			notCommonItems.add(s1.setArray[i]);
		}
		for(int i=0;i<s2.setArray.length;i++){
			if(s1.isMember(s2.setArray[i])){
				continue;
			}
			else{
				notCommonItems.add(s2.setArray[i]);
			}
		}
		return notCommonItems;
	}
	
	public static void main(String[] args){
		IntSet s1 = new IntSet(new int[]{1,5,6,8});
		IntSet s2 = new IntSet(new int[]{2,6,9});
		int[] arr = s1.union(s1,s2);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		System.out.println("--------------");
		int[] arr1 = s2.getComplement();
		for(int i=0; i<arr1.length;i++){
			System.out.println(arr1[i]);
		}
	}
}
