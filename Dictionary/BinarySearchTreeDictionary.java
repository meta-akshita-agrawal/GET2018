import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BinarySearchTreeDictionary implements Dictionary{
	
	private BinarySearchTree binarySearchTree;
	
	
	public BinarySearchTreeDictionary() throws FileNotFoundException, IOException, ParseException {
		binarySearchTree = new BinarySearchTree();
		initialize();
	}
	
	
	/**
	 * Reads a JSON file already having some defined word meaning pair
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void initialize() throws FileNotFoundException, IOException, ParseException{
		
		Object obj = new JSONParser().parse(new FileReader("C:\\Users\\hp\\Desktop\\dict.json.txt"));

		JSONObject object = (JSONObject) obj;
		
		for(Object key: object.keySet()){
			KeyValueNode newNode = new KeyValueNode(key.toString(),object.get(key).toString());
			binarySearchTree.add(newNode);
			
		}
	}

	/**
	 * Adds a word meaning pair in dictionary
	 * @param word meaning pair
	 */
	public void add(KeyValueNode keyValuePair) {
		binarySearchTree.add(keyValuePair);
		
	}

	/**
	 * Deletes a word from dictionary along with its meaning
	 * @param key, word to be deleted
 	 */
	public void delete(String key) {
		binarySearchTree.delete(key);
	}

	/**
	 * Gets meaning for a word
	 * @param key, word
	 */
	public String getValueByKey(String key) {
		KeyValueNode item = binarySearchTree.search(key);//first searching through the dictionary
		if(item == null) {
			throw new AssertionError("key not found");//throws error if no such word is found in the dictionary
		}
		return item.meaning;
	}

	/**
	 * @return sorted list of dictionary
	 */
	public List<KeyValueNode> getSortedList() {
		return binarySearchTree.inorder();
	}

	/**
	 * @return sorted list between key1 and key2
	 */
	public List<KeyValueNode> getRangedSortedList(String key1, String key2) {
		List<KeyValueNode> rangedSortedList = new ArrayList<KeyValueNode>();
        for(KeyValueNode item: binarySearchTree.inorder())
        {
            if((item.word.compareToIgnoreCase(key1) >= 0) && 
               (item.word.compareToIgnoreCase(key2) <= 0))
            {
                rangedSortedList.add(item);
            }
        }
        return rangedSortedList;
	}

}
