import java.util.Scanner;

public class mainProgram {

	public static void main(String[] args) {

		Folder currentFolder = new Folder("Root", null);

		Folder root = currentFolder;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("R:");
			currentFolder.printPath(currentFolder);
			System.out.print(">");
			String command = sc.next();
			currentFolder = CommandFactory.execute(currentFolder, command, sc, root);

		} while (true);

	}
	
}
