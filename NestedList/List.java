import java.util.ArrayList;

public class List implements NestedList {

	ArrayList<NestedList> list;

	//Default Constructor
	List() {
		this.list = new ArrayList<NestedList>();
	}

	//Parameterized Constructor
	List(ArrayList<NestedList> list) {
		this.list = list;
	}

	/**
	 * Adds a nested list which can of type Value or List or itself a nested list
	 */
	public void add(NestedList item) {
		this.list.add(item);
	}

	/**
	 * Evaluates sum for values in nested list\
	 * @return sum
	 */
	public int sum() {
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).sum();//invokes recursively sum() method if List object is invoking it, else Value sum() method will be invoked
		}
		return sum;
	}

	/**
	 * Evaluates largest value from the whole nested list
	 * @return largest value
	 */
	public int largestValue() {
		int largestValue = 0;
		for (int i = 0; i < list.size(); i++) {
			
			int value = list.get(i).largestValue();
			
			if (largestValue < value) {
				largestValue = value;//invokes recursively largestValue() method if List object is invoking it, else Value largestValue() method will be invoked
			}
		}
		return largestValue;
	}

	/**
	 * Finds a value from the nested list
	 * @param value to find
	 * @return path which can lead to the exact value
	 */
	public ArrayList<Integer> findValue(int value) {

		ArrayList<Integer> searchIndices = null;

		for (int i = 0; i < list.size(); i++) {
			searchIndices = list.get(i).findValue(value);
			if (searchIndices != null) {
				searchIndices.add(i);
				return searchIndices;
			}
		}
		return searchIndices;
	}

}
