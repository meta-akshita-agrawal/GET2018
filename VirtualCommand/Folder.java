import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Folder {
	
	private Folder parent;//Parent Directory
	private String folderName;//Sub Folder
	private List<Folder> children = new ArrayList<>();
	private Date createdDate;
	
	//Parameterized constructor for root when there will be no parent
	Folder(String folderName){
		this.folderName = folderName;
		this.createdDate = new Date();//Assign a date whenever a new folder is created
	}
	
	//Parameterized constructor for folders
	Folder(String folderName, Folder parent) {
		this.folderName = folderName;
		this.parent = parent;
		this.createdDate = new Date();
	}

	/**
	 * @return folder name of current Folder
	 */
	public String getFolderName() {
		return folderName;
	}

	/**
	 * @return Children of a folder
	 */
	public List<Folder> getChildren() {
		return children;
	}

	/**
	 * Sets children in a parent directory if a new folder is created
	 * @param childrenName
	 */
	public void setChildren(Folder childrenName) {
		this.children.add(childrenName);
	}
	
	/**
	 * @return Created Date of a folder
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @return Parent of a folder
	 * null if there is none
	 */
	public Folder getParent() {
		return parent;
	}

	/**
	 * Prints path from child to root
	 * @param currentFolder
	 */
	public void printPath(Folder currentFolder) {
		
		ArrayList<String> path = new ArrayList<>();
		
		path.add(currentFolder.getFolderName());
		
		while(currentFolder.getParent() != null) {
			path.add(currentFolder.getParent().getFolderName());
			currentFolder = currentFolder.getParent();
		}
		
		for(int i=path.size()-2;i>=0;i--) {
			System.out.print("\\" + path.get(i));
		}
	}
	
}
