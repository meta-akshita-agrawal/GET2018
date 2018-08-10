import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	KeyValueNode root;
	List<KeyValueNode> dictionaryList;

	/**
	 * Initializes Binary Search Tree
	 */
	BinarySearchTree() {
		root = null;
		dictionaryList = new ArrayList<KeyValueNode>();
	}

	/**
	 * Calls insertRecursively()
	 * @param word meaning pair to be added
	 */
	public void add(KeyValueNode keyValuePair) {

		this.root = addRecursively(this.root, keyValuePair);
	}

	/**
	 * Inserts item to binary search tree
	 * @param root, root of the tree
	 * @param word meaning pair to be added
	 * @return return root item
	 */
	private KeyValueNode addRecursively(KeyValueNode root, KeyValueNode keyValuePair) {

		//if root is null then add key to root
		if (root == null) {
			root = new KeyValueNode(keyValuePair.word, keyValuePair.meaning);
			return root;
		}

		 //if key is less than key of root Item then go left
		if (keyValuePair.word.compareTo(root.word) > 0) {
			root.right = addRecursively(root.right, keyValuePair);
		} 
		//else if key is more than key of root Item then go right
		else {
			root.left = addRecursively(root.left, keyValuePair);
		}

		return root;

	}

	/**
	 * Calls deleteRecursively()
	 * @param key, word to be deleted
	 */
	public void delete(String key) {

		root = deleteRecursively(root, key);

	}

	/**
     * Deletes an item from binary search tree
     * @param root, root of the tree
     * @param key, word to be deleted
     */
	private KeyValueNode deleteRecursively(KeyValueNode root, String key) {

		//Base Case: If the tree is empty
		if (root == null)
			return root;

		//Otherwise, recur down the tree
		if (root.word.compareTo(key) > 0)
			root.left = deleteRecursively(root.left, key);
		else if (root.word.compareTo(key) < 0)
			root.right = deleteRecursively(root.right, key);

		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			root.word = minValue(root.right).word;
			root.meaning = minValue(root.left).meaning;

			// Delete the inorder successor
			root.right = deleteRecursively(root.right, root.word);
		}

		return root;

	}

	/**
     * Returns key of leftmost leaf item
     * @param root root item
     */
	private KeyValueNode minValue(KeyValueNode root) {
		KeyValueNode minvalue = root;
		while (root.left != null) {
			minvalue = root;
			root = root.left;
		}
		return minvalue;
	}

	/**
	 * Calls searchRecursively()
	 * @param key, key of item that is to be searched
	 * @return meaning with corresponding key or word
	 */
	public KeyValueNode search(String key) {
		return searchRecursively(root, key);
	}

	/**
	 * Searches the item with corresponding key
	 * @param root, root of the tree
	 * @param key, key of item that is to be searched
	 * @return meaning corresponding to that key, else if no such item found then
	 *         return null
	 */
	private KeyValueNode searchRecursively(KeyValueNode root, String key) {
		// if root is null or root is	 desired item, return root
		if (root == null || root.word == key) {
			return root;
		}
		// if key is less than root's key, go left
		if (root.word.compareToIgnoreCase(key) > 0) {
			return searchRecursively(root.left, key);
		}
		// if key is greater than root's key, go right
		return searchRecursively(root.right, key);
	}

	/**
	 * Returns a list with all items arranged in inorder format
	 * @return list of items
	 */
	public List<KeyValueNode> inorder() {
		// dictionaryList.clear();
		inorderRecursively(root);
		return dictionaryList;
	}

	/**
	 * Traverses through tree inorder format
	 * @param root of the tree
	 */
	private void inorderRecursively(KeyValueNode root) {
		if (root != null) {
			inorderRecursively(root.left);
			dictionaryList.add(root);
			inorderRecursively(root.right);
		}
	}

}
