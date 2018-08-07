import java.util.ArrayList;

public class Value implements NestedList {

	int value;

	//Parameterized Constructor
	Value(int value) {
		this.value = value;
	}

	/**
	 * @returns value 
	 */
	public int sum() {
		return this.value;
	}

	/**
	 * @return value
	 */
	public int largestValue() {
		return this.value;
	}

	/**
	 * @return path by which a value can be searched
	 */
	public ArrayList<Integer> findValue(int value) {

		ArrayList<Integer> searchIndices = null;
		if (value == this.value) {
			searchIndices = new ArrayList<>();
		}
		return searchIndices;
	}

	/**
	 */
	public void add(NestedList item) {
		// TODO Auto-generated method stub

	}

}
