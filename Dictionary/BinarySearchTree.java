import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class BinarySearchTree implements Dictionary{
	
	KeyValueNode root;
	
	BinarySearchTree() throws FileNotFoundException, IOException, ParseException{
		//initialize();
		root = null;
	}
	
	
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void initialize() throws FileNotFoundException, IOException, ParseException{
		
		Object obj = new JSONParser().parse(new FileReader("C:\\Users\\User31\\Desktop\\test.json.txt"));

		JSONObject object = (JSONObject) obj;
		
		for(Object key: object.keySet()){
			KeyValueNode newNode = new KeyValueNode(key.toString(),object.get(key).toString());
			add(newNode);
			
		}
	}

	/**
	 * 
	 */
	@Override
	public void add(KeyValueNode keyValuePair) {
		
		this.root = addRecursively(this.root,keyValuePair);
		
	}
	
	/**
	 * 
	 * @param root
	 * @param keyValuePair
	 * @return
	 */
	public KeyValueNode addRecursively(KeyValueNode root,KeyValueNode keyValuePair){
	
		if(root==null){
			root = new KeyValueNode(keyValuePair.word,keyValuePair.meaning);
			return root;
		}
		
		if(keyValuePair.word.compareTo(root.word) > 0){
			root.right = addRecursively(root.right,keyValuePair);
		}
		else{
			root.left = addRecursively(root.left,keyValuePair);
		}
		
		return root;
		
	}

	/**
	 * 
	 */
	@Override
	public void delete(String key) {
		

	}
	
	KeyValueNode deleteRecursively(KeyValueNode root, String key) {
		
		/* Base Case: If the tree is empty */
        if (root == null)  return root;
 
        /* Otherwise, recur down the tree */
        if (root.word.compareTo(key) > 0)
            root.left = deleteRecursively(root.left, key);
        else if (root.word.compareTo(key) < 0)
            root.right = deleteRecursively(root.right, key);
 
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.word = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteRecursively(root.right, root.word);
        }
        
        return root;

	}
	
	String minValue(KeyValueNode root)
    {
        String minvalue = root.word;
        while (root.left != null)
        {
            minvalue = root.left.word;
            root = root.left;
        }
        return minvalue;
    }
        
        
	
	
	
	/**
	 * 
	 */
	@Override
	public String getValueByKey(String key) {
		KeyValueNode searchedNode = search(root,key);
		return searchedNode.meaning;
		
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public KeyValueNode search(KeyValueNode root,String key){
		
		if(root.word.equals(key)){
			return root;
		}
		else if(root.word.compareTo(key)>0){
			root.left = search(root.left,key);
		}
		else{
			root.right = search(root.right,key);
		}
		
		return root;
	}

	
	@Override
	public LinkedHashMap<String,String> getSortedList(KeyValueNode root, LinkedHashMap<String,String> list) {
		
		while(root!=null) {
			getSortedList(root.left,list);
			list.put(root.word, root.meaning);
			getSortedList(root.right,list);
		}
		return list;
			
	}
	

	@Override
	public LinkedHashMap<String,String> getRangedSortedList(String key1, String key2) {
		return null;
	}

	
	
	 
	
	

	
	
}
