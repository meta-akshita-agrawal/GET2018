import java.util.List;


public class Tree implements Commands{
	
	int counter = 0;//counter used for every child recursion in the currentFolder
					//just used for indentation of  tree
	
	@Override
	public Folder execute(Folder currentFolder,
			String folderName) {
		Folder root = currentFolder.getRoot(currentFolder);
		executePrint(root);
		return currentFolder;
	}
	
	
	
	
	public Folder executePrint(Folder currentFolder) {
		
		
		List<Folder> children = currentFolder.getChildren();
		
		for(int i=0;children.size() != 0 &&i<children.size();i++){
			
			for(int j=0;j<counter;j++) {
				System.out.print("|          ");
			}
			
			currentFolder = children.get(i);
			
			System.out.print("|----------");
			System.out.println(currentFolder.getFolderName());
			
			counter++;
			executePrint(currentFolder);//RECURSION AS DFS
			counter--;
		}
		return currentFolder;
		
	}
					
}