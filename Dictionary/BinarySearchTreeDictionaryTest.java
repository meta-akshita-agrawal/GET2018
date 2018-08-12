import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BinarySearchTreeDictionaryTest{
	
    BinarySearchTreeDictionary binarySearchTreeDictionary;
    
    public void newobj() throws FileNotFoundException, IOException, ParseException{
    	binarySearchTreeDictionary = new BinarySearchTreeDictionary();
    }
    
    @Before
    public void initialize() throws FileNotFoundException, IOException, ParseException
    {
    	newobj();
    }
    
    @Test
    public void testAdd()
    {
        binarySearchTreeDictionary.add(new KeyValueNode("gh","ag"));
        binarySearchTreeDictionary.add(new KeyValueNode("harsh","bkj"));
        
        String[] expectedOutput = {"akshita agrawal","gh ag", "harsh bkj", "komal khatri","old new"};
        int i = 0;
        for(KeyValueNode item: binarySearchTreeDictionary.getSortedList())
        {
            String actualOutput = item.word + " " + item.meaning;
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }
    
    @Test
    public void testDelete()
    {
        binarySearchTreeDictionary.delete("komal");
        
        String[] expectedOutput = {"akshita agrawal","old new"};
        int i = 0;
        for(KeyValueNode item: binarySearchTreeDictionary.getSortedList())
        {
            String actualOutput = item.word + " " + item.meaning;
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }

    @Test
    public void testSort()
    {        
        String[] expectedOutput = {"akshita agrawal", "komal khatri","old new"};
        int i = 0;
        for(KeyValueNode item: binarySearchTreeDictionary.getSortedList())
        {
            String actualOutput = item.word + " " + item.meaning;
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }
    
    @Test
    public void testSortBetween()
    {        
        String[] expectedOutput = {"akshita agrawal"};
        int i = 0;
        for(KeyValueNode item: binarySearchTreeDictionary.getRangedSortedList("a", "g"))
        {
            String actualOutput = item.word + " " + item.meaning;
            assertEquals(expectedOutput[i], actualOutput);
            i++;
        }
    }
    
    @Test
    public void testGet()
    {
        String expectedOutput = "agrawal";
        String actualOutput = binarySearchTreeDictionary.getValueByKey("akshita");
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = AssertionError.class)
    public void testGetWithNoSuchKey()
    {
        binarySearchTreeDictionary.getValueByKey("f");
    }
}
