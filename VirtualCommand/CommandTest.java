
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CommandTest {

	@Test
	public void testForMkdir() {
		Mkdir mkdirObj = new Mkdir();

		Folder currentFolder = new Folder("Root",null);
		
		mkdirObj.execute(currentFolder, "akshita");
		
		List<Folder> children = currentFolder.getChildren();
		
		assertEquals("akshita",(children.get(0)).getFolderName());
	}
	
	@Test
	public void testForCd() {
		
		Mkdir mkdirObj = new Mkdir();
		Cd cdObj = new Cd();

		Folder currentFolder = new Folder("Root",null);
		
		mkdirObj.execute(currentFolder, "akshita");
		
		currentFolder = cdObj.execute(currentFolder, "akshita");
	
		assertEquals(currentFolder.getFolderName(),"akshita");
	}
	
	@Test
	public void testForbk() {
		
		Mkdir mkdirObj = new Mkdir();
		Cd cdObj = new Cd();
		back bkObj = new back();

		Folder currentFolder = new Folder("Root",null);
		
		mkdirObj.execute(currentFolder, "akshita");
		
		currentFolder = cdObj.execute(currentFolder, "akshita");
	
		currentFolder = bkObj.execute(currentFolder, null);
		
		assertEquals(currentFolder.getFolderName(),"Root");
	}

}
