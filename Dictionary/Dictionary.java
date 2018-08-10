import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


public interface Dictionary {

	void add(KeyValueNode keyValuePair);
	void delete(String key);
	String getValueByKey(String key);
	LinkedHashMap<String,String> getSortedList(KeyValueNode root,LinkedHashMap<String,String> list);
	LinkedHashMap<String,String> getRangedSortedList(String key1, String key2);
}
