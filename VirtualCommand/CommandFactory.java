

//Factory used to create objects for different commands
public class CommandFactory {

	Commands cmdObj;
	
	/**
	 * Executes a command
	 * @param currentFolder
	 * @param command that needs to be executed
	 * @param sc, scanner to continue scanning in some commands
	 * @param root, root of the file hierarchy
	 * @return current folder after execution
	 */
	public static Commands execute(String[] command) {
		
		
		switch(command[0]){
		
		case "mkdir":
			Commands mkdirObj = new Mkdir();
			return mkdirObj;
		case "cd":
			Commands cdObj = new Cd();
			return cdObj;
		case "ls":
			Commands lsObj = new ls();
			return lsObj;
		case "bk":
			Commands bkObj = new back();
			return bkObj;
		case "find":
			Commands findObj = new Find();
			return findObj;
		case "tree":
			Commands treeObj = new Tree();
			return treeObj;
		case "exit":
			System.exit(0);
			break;
		default:
			System.out.println("no such command");
			break;
		}
		return null;
	}
	
}