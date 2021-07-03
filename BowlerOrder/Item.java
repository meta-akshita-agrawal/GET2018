
public class Item {

	String name;//name of an item
	int priority;//priority associated to it

	//Parameterized Constructor
	Item(String name,int priority){
		this.name = name;
		this.priority = priority;
	}

	/**
	 * @return priority of an item
	 */
	public int getPriority() {
		return priority;
	}

}
