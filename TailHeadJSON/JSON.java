package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON {

	/**
	 * Reads a JSON file and invokes add method
	 * @param location
	 * @return nested list created using JSON file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public NestedList readJSON(String location) throws FileNotFoundException, IOException, ParseException {	
		
		Object obj = new JSONParser().parse(new FileReader(location)); //Parse JSON file form the specified location
		
		JSONObject object = (JSONObject) obj; //Casting Object to JSONObject
		
		NestedList nl = new List();//Creates a new nested list
		
		nl = add(object); // invokes add method

		return nl;
	}
	
	/**
	 * Adds JSON nested list in NestedList List
	 * @param object, JSONObject that needs to be added
	 * @return nested list
	 */
	private static NestedList add(JSONObject object){
		
		NestedList nl = new List();
		
		for(Object key:object.keySet()){
			
			if(object.get(key) instanceof String){//if JSONObject is an instance of string means its Value
				nl.add(new Value(Integer.parseInt((String) object.get(key))));
			}
			else{
				nl.add(add((JSONObject) object.get(key)));	//calling it recursively when a new list is found			
			}
		}
		return nl;
	}
	
	
}
