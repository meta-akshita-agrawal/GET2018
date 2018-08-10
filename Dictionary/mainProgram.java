import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.json.simple.parser.ParseException;

public class mainProgram {

	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		BinarySearchTree obj = new BinarySearchTree();
		
		obj.add(new KeyValueNode("vk","ag"));
		obj.add(new KeyValueNode("ak","ag"));
		obj.add(new KeyValueNode("gh","ag"));
		obj.add(new KeyValueNode("iim","ag"));
		
		LinkedHashMap<String,String> list = new LinkedHashMap<>();
		list = obj.getSortedList(obj.root, list);
		
		for(String key:list.keySet()) {
			System.out.println(key + list.get(key));
		}
	}
}
