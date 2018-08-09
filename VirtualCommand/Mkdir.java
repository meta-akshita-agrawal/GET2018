import java.util.List;

public class Mkdir implements Commands {

	/**
	 * Creates a directory in the current folder
	 * @return current folder after execution
	 */
	public Folder execute(Folder currentFolder, String folderName) {

		List<Folder> children = currentFolder.getChildren();

		for (Folder child : children) {
			if (child.getFolderName().equals(folderName)) {
				throw new AssertionError("Folder already exist in the current Folder");//throw error if same name exists in the current folder
			}
		}

		Folder child = new Folder(folderName, currentFolder);

		currentFolder.setChildren(child);//adding newly created folder in the current folder

		return currentFolder;
	}

}
