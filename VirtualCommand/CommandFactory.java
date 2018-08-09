import java.util.Scanner;

//Factory used to create objects for different commands
public class CommandFactory {

	/**
	 * Executes a command
	 * @param currentFolder
	 * @param command that needs to be executed
	 * @param sc, scanner to continue scanning in some commands
	 * @param root, root of the file hierarchy
	 * @return current folder after execution
	 */
	public static Folder execute(Folder currentFolder,String command, Scanner sc, Folder root) {
		
		
		switch(command){
		
		case "mkdir":
			Commands mkdirObj = new Mkdir();
			String folderName = sc.next();
			mkdirObj.execute(currentFolder,folderName);
			break;
		case "cd":
			Commands cdObj = new Cd();
			String changedDirName = sc.next();
			currentFolder = cdObj.execute(currentFolder,changedDirName);
			break;
		case "ls":
			Commands lsObj = new ls();
			lsObj.execute(currentFolder,null);
			break;
		case "bk":
			Commands bkObj = new back();
			currentFolder = bkObj.execute(currentFolder,null);
			break;
		case "find":
			Commands findObj = new Find();
			String findDirName = sc.next(); 
			findObj.execute(currentFolder,findDirName);
			break;
		case "tree":
			Commands treeObj = new Tree();
			treeObj.execute(root, null);
			break;
		case "exit":
			sc.close();
			System.exit(0);
			break;
		default:
			System.out.println("no such command");
			break;
		}
		return currentFolder;
	}
	
}
