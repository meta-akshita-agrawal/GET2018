public class back implements Commands {

	/**
	 * Moves to the parent directory of current folder
	 * @param currentFolder
	 * @return current folder after execution
	 */
	@Override
	public Folder execute(Folder currentFolder, String folderName) {

		if (currentFolder.getParent() == null) {
			throw new AssertionError("Nothing to go back");// throws error if the current folder is root
		}

		currentFolder = currentFolder.getParent(); // change current folder to parent directory

		return currentFolder;
	}
}