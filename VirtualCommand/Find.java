import java.util.List;

public class Find implements Commands {

	
	@Override
	public Folder execute(Folder currentFolder, String folderName) {
		executePrint(currentFolder,folderName);
		return currentFolder;
	}
	
	
	/**
	 * Finds a folder by its whole name or part of it
	 * It shows various folder in the current directory related to the specified folder name
	 * @param currentFolder
	 * @param folderName, a part of name or whole name 
	 * @return current folder after execution
	 */
	public Folder executePrint(Folder currentFolder, String folderName) {

		List<Folder> children = currentFolder.getChildren(); //retrieves children or sub folders of current folder

		for (int i = 0; children.size() != 0 && i < children.size(); i++) {
			
			Folder child = children.get(i);

			if (child.getFolderName().contains(folderName)) {

				System.out.print("-");
				currentFolder.printPath(child); //printing path from child to root
				System.out.println();
			}
			
			currentFolder = child; //changing currentFolder to sub folder
			execute(currentFolder, folderName);//RECURSIVE
		}

		return currentFolder;
	}
}