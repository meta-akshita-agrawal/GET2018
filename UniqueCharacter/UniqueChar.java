
import java.util.HashMap;
import java.util.HashSet;

public class UniqueChar {
	
	HashSet<Character> uniCharList = new HashSet<>();//character list to store every character only once
	
	HashMap<String,Integer> cache = new HashMap<>();//cache to store an input string with its result so that no need of traversing again and again
	
	/**
	 * Evaluates number of unique characters in a string
	 * @param inputString
	 * @return number of unique characters
	 */
	public int numberOfUniChar(String inputString){
		
		if(inputString.length() == 0){
			throw new AssertionError("String is empty");//throw if an empty string is entered
		}
		
		//checks if cache already contains input string
		//if yes then return its result from the cache
		if(cache.containsKey(inputString)){
			return cache.get(inputString);
		}
		
		//otherwise traversing through the string
		addString(inputString);
		
		return this.uniCharList.size();
	}
	
	/**
	 * Private method to check unique characters in a string
	 * @param inputString
	 */
	private void addString(String inputString){
		
		for(int i=0;i<inputString.length();i++){
			//if list does not contain character already, add it
			if(!this.uniCharList.contains(inputString.charAt(i))){
				this.uniCharList.add(inputString.charAt(i));
			}
			else{//else remove the duplicate character
				this.uniCharList.remove(inputString.charAt(i));
			}
	
		}
		//adding the size of the character list into cache for future use
		this.cache.put(inputString, this.uniCharList.size());
	}
	

}
