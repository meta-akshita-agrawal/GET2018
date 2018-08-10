	
public class KeyValueNode {

	String word;
	String meaning;
	KeyValueNode left;
	KeyValueNode right;
	
	//KeyValueNode for word meaning pair
	public KeyValueNode(String word, String meaning) {
	
		this.word = word;
		this.meaning = meaning;
		this.left = null;
		this.right = null;
	}

}
