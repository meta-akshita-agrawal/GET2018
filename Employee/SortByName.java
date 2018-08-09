import java.util.Comparator;


public class SortByName implements Comparator<Employee> {//implementing comparator with Employee object

	/**
	 * Overriding comparator for name field
	 * if a is lexically greater than b then positive value is returned 
	 * else negative
	 * and if they are equal, then 0
	 */
	@Override
	public int compare(Employee a, Employee b) {
		
		return a.name.compareTo(b.name);
	}

	
}
