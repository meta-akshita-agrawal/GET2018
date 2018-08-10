
import java.util.List;

public interface Dictionary {

	void add(KeyValueNode keyValuePair);// adds a word meaning pair in the dictionary

	void delete(String key);// deletes a word meaning pair in the dictionary

	String getValueByKey(String key);// gets meaning of a word

	List<KeyValueNode> getSortedList();// gets sorted list of dictionary

	List<KeyValueNode> getRangedSortedList(String key1, String key2);// gets dictionary between 2 strings key1 and key2
}
