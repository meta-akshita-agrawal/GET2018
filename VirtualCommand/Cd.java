
import java.util.List;


public class Cd implements Commands{

	/**
	 * Change directory to the specified directory name
	 * @param currentFolder
	 * @param folderName, Directory to move
	 * @return current folder after execution 
	 */
	@Override
	public Folder execute(Folder currentFolder,String folderName) {
		List<Folder> children = currentFolder.getChildren();
		for(Folder child: children){
			if(child.getFolderName().equals(folderName)){
				currentFolder = child;
				return currentFolder;
			}
		}
		throw new AssertionError("No such directory");//throws error if no directory is found to change
	}
	
}
