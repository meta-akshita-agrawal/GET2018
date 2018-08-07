package test;

import java.util.ArrayList;

public class List implements NestedList {

	char tail = 'T';
	char head = 'H';
	
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
	
	/**
	 * Gets tail of a nested list
	 * which is a nested list removing the head of the nested list
	 * @return tail nested list
	 */
	public NestedList getTail() {
		
		NestedList nl = new List();
		for(int i=1;i<list.size();i++) {
			nl.add(list.get(i));
		}
		return nl;
	}
	
	/**
	 * Gets head of a nested list
	 * which either can be a value or another nested list
	 * @return head nested list
	 */
	@Override
	public NestedList getHead() {
		return list.get(0);
	}
	
	/**
	 * Returns value by given string tail-head sequence
	 * @return nested list
	 */
	public NestedList getValueByPosition(String position) {
		NestedList nl = new List(this.list);
		for(int i=0;i<position.length();i++) {
			if(position.charAt(i)== tail) {
				nl = nl.getTail();
			}
			else {
				nl = nl.getHead();
			}
		}
		return nl;
	}

}
