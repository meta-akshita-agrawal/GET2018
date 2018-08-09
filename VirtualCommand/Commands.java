
public interface Commands{

	//executes a command on current folder
	Folder execute(Folder currentFolder,String folderName);//definition varies according to various command implementations
}