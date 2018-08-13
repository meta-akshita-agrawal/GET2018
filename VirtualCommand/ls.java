import java.util.List;

public class ls implements Commands {

	/**
	 * Prints details of sub folders in the folder
	 * createdDate folderName
	 * @return current folder after execution
	 */
	public Folder execute(Folder currentFolder, String folderName) {
		List<Folder> children = currentFolder.getChildren();

		for (Folder child : children) {
			System.out.println(child.getCreatedDate() + " " + child.getFolderName());
		}
		return currentFolder;
	}
}