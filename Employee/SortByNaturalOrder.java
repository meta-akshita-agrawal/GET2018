
import java.util.Comparator;

public class SortByNaturalOrder implements Comparator<Employee>{

	/**
	 * Overriding comparator for employee id field
	 * if a is greater than b then positive value is returned 
	 * else negative
	 * and if they are equal, then 0
	 */
	public int compare(Employee a, Employee b) {
		return a.empId - b.empId;
	}
}
