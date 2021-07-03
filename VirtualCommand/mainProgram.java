import java.util.Scanner;

public class mainProgram {

	public static void main(String[] args) {

		Commands cmdObj;
		
		Folder currentFolder = new Folder("Root", null);

		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("R:");
			currentFolder.printPath(currentFolder);
			System.out.print(">");
			String command = sc.nextLine();
			String[] splittedCommand = command.split(" ");
			cmdObj = CommandFactory.execute(splittedCommand);
			if(splittedCommand.length == 2){
				currentFolder = cmdObj.execute(currentFolder, splittedCommand[1]);
			}
			else{
				currentFolder = cmdObj.execute(currentFolder, null);
			}
			
		} while (true);

	}
	
}