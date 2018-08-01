import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ShapeTest {

	@Test
	public void createShapeTestPositive(){
		
		Screen screenObj = new Screen();//creating object of screen 
		
		Point pointObj = new Point(2.0,2.0);//creating point
		
		ArrayList<Double> parameters = new ArrayList<>();//creating parameter list for square
		parameters.add(5.0);//adding parameter
		
		//creating shape using createShape method of screen class
		screenObj.createShape(ShapeType.SQAURE, pointObj, parameters);
		
		//adding that list to expected list
		ArrayList<Shape> expectedList = screenObj.shapeList;
		
		//creating an actual list that needs to be compared
		ArrayList<Shape> actualList = new ArrayList<>();
		actualList.add(new Square(5.0,pointObj));
		
		//comparing values of both list
		if(actualList.size() == expectedList.size()){
			for(int i=0;i<actualList.size();i++){
				assertEquals(expectedList.get(i).getType(),actualList.get(i).getType());
				assertEquals(expectedList.get(i).getOrigin(),actualList.get(i).getOrigin());
				assertEquals(expectedList.get(i).getParameters(),actualList.get(i).getParameters());
			}
		}
		else{
			throw new AssertionError("expected and actual don't have same size");//if both list size is not equal
		}
		
	}
	
	@Test
	public void createShapeNegative(){
		
		Screen screenObj = new Screen();//creating object of screen
		
		Point pointObj = new Point(2.0,2.0);//creating point
		
		ArrayList<Double> parameters = new ArrayList<>();//creating parameter list for square
		parameters.add(5.0);//adding parameter
		
		//creating shape using createShape method of screen class
		screenObj.createShape(ShapeType.SQAURE, pointObj, parameters);
		
		//adding that list to expected list
		ArrayList<Shape> expectedList = screenObj.shapeList;
		
		//creating an actual list that needs to be compared
		ArrayList<Shape> actualList = new ArrayList<>();
		actualList.add(new Triangle(4.0,2.0,5.0,pointObj));
		
		
		for(int i=0;i<actualList.size();i++){
			assertNotEquals(expectedList.get(i).getType(),actualList.get(i).getType());
			assertEquals(expectedList.get(i).getOrigin(),actualList.get(i).getOrigin());
			assertNotEquals(expectedList.get(i).getParameters(),actualList.get(i).getParameters());
		}
	}
	
	@Test
	public void deleteShapePositive(){
		
		Screen screenObj = new Screen();//creating object of screen 
		
		Point pointObj = new Point(2.0,2.0);//creating point
		
		ArrayList<Double> parameters = new ArrayList<>();//creating parameter list for square
		parameters.add(5.0);//creating parameter list for square
		
		screenObj.createShape(ShapeType.SQAURE, pointObj, parameters);//adding shape objects
		screenObj.createShape(ShapeType.SQAURE, pointObj, parameters);
		
		//adding that list to expected list
		screenObj.deleteShape(ShapeType.SQAURE);//deleting shape
		
		
		ArrayList<Shape> expectedList = screenObj.shapeList;
		
		//creating an actual list that needs to be compared
		ArrayList<Shape> actualList = new ArrayList<>();
		actualList.add(new Square(5.0,pointObj));
		
		//comparing values of both list
		if(actualList.size() == expectedList.size()){
				for(int i=0;i<actualList.size();i++){
					assertEquals(expectedList.get(i).getType(),actualList.get(i).getType());
					assertEquals(expectedList.get(i).getOrigin(),actualList.get(i).getOrigin());
					assertEquals(expectedList.get(i).getParameters(),actualList.get(i).getParameters());
				}
			}
			else{
				throw new AssertionError("expected and actual don't have same size");//if both list size is not equal				}
			}
		
	}
	
	@Test(expected = AssertionError.class)
	public void deleteShapeNegative(){
		
		Screen screenObj = new Screen();//creating object of screen 
		
		Point pointObj = new Point(2.0,2.0);//creating point
		
		ArrayList<Double> parameters = new ArrayList<>();//creating parameter list for square
		parameters.add(5.0);
		
		screenObj.createShape(ShapeType.SQAURE, pointObj, parameters);//adding shape objects
		screenObj.createShape(ShapeType.SQAURE, pointObj, parameters);
		
		//deleting first occurrence of square type
		screenObj.deleteShape(ShapeType.SQAURE);
		
		//adding that list to expected list
		ArrayList<Shape> expectedList = screenObj.shapeList;
		
		//creating an actual list that needs to be compared
		ArrayList<Shape> actualList = new ArrayList<>();
		actualList.add(new Square(5.0,pointObj));
		actualList.add(new Square(5.0,pointObj));
		
		//comparing values of both list
		if(actualList.size() == expectedList.size()){
			for(int i=0;i<actualList.size();i++){
				assertNotEquals(expectedList.get(i).getType(),actualList.get(i).getType());
				assertNotEquals(expectedList.get(i).getOrigin(),actualList.get(i).getOrigin());
				assertNotEquals(expectedList.get(i).getParameters(),actualList.get(i).getParameters());
			}
		}
		else{
			throw new AssertionError("expected and actual don't have same size");
		}		
	}
	
	@Test
	public void deleteByType(){
		
		Screen screenObj = new Screen();//creating object of screen 
		
		Point pointSquare1 = new Point(2.0,2.0);//creating point for first square object
		Point pointSquare2 = new Point(3.0,3.0);//creating point for second square object
		Point pointRectangle = new Point(2.5,2.5);//creating point for rectangle object
		
		ArrayList<Double> parametersSquare1 = new ArrayList<>();//creating parameter list
		parametersSquare1.add(3.0);
		
		ArrayList<Double> parametersSquare2 = new ArrayList<>();//creating parameter list
		parametersSquare2.add(8.0);
		
		ArrayList<Double> parametersRectangle = new ArrayList<>();//creating parameter list
		parametersRectangle.add(5.0);
		parametersRectangle.add(3.0);
		
		screenObj.createShape(ShapeType.SQAURE, pointSquare1, parametersSquare1);//creating shapes
		screenObj.createShape(ShapeType.SQAURE, pointSquare2, parametersSquare2);
		screenObj.createShape(ShapeType.RECTANGLE, pointRectangle, parametersRectangle);
		
		screenObj.deleteByType(ShapeType.SQAURE);//delete all shape type objects
		
		//adding that list to expected list
		ArrayList<Shape> expectedList = screenObj.shapeList;
		
		//creating an actual list that needs to be compared
		ArrayList<Shape> actualList = new ArrayList<>();
		actualList.add(new Rectangle(5.0,3.0,pointRectangle));
		
		if(actualList.size() == expectedList.size()){
			for(int i=0;i<actualList.size();i++){
				assertEquals(expectedList.get(i).getType(),actualList.get(i).getType());
				assertEquals(expectedList.get(i).getOrigin(),actualList.get(i).getOrigin());
				assertEquals(expectedList.get(i).getParameters(),actualList.get(i).getParameters());
			}
		}
		else{
			throw new AssertionError("expected and actual don't have same size");
		}
		
	}
	
	@Test
	public void sortTest(){
		
		Screen screenObj = new Screen();//creating object of screen 
		
		Point pointSquare1 = new Point(2.0,2.0);//creating point for first square object
		Point pointSquare2 = new Point(3.0,3.0);//creating point for second square object
		Point pointRectangle = new Point(2.5,2.5);//creating point for rectangle object
		
		ArrayList<Double> parametersSquare1 = new ArrayList<>();
		parametersSquare1.add(3.0);
		
		ArrayList<Double> parametersSquare2 = new ArrayList<>();
		parametersSquare2.add(8.0);
		
		ArrayList<Double> parametersRectangle = new ArrayList<>();
		parametersRectangle.add(5.0);
		parametersRectangle.add(3.0);
		
		screenObj.createShape(ShapeType.SQAURE, pointSquare1, parametersSquare1);
		screenObj.createShape(ShapeType.SQAURE, pointSquare2, parametersSquare2);
		screenObj.createShape(ShapeType.RECTANGLE, pointRectangle, parametersRectangle);
		
		screenObj.sort(SortType.AREA);
		
		ArrayList<Shape> expectedList = screenObj.shapeList;
		
		//creating an actual list that needs to be compared
		ArrayList<Shape> actualList = new ArrayList<>();
		actualList.add(new Square(3.0,pointSquare1));
		actualList.add(new Rectangle(5.0,3.0,pointRectangle));
		actualList.add(new Square(8.0,pointSquare2));
		
		if(actualList.size() == expectedList.size()){
			for(int i=0;i<actualList.size();i++){
				assertEquals(expectedList.get(i).getType(),actualList.get(i).getType());
				assertEquals(expectedList.get(i).getOrigin(),actualList.get(i).getOrigin());
				assertEquals(expectedList.get(i).getParameters(),actualList.get(i).getParameters());
			}
		}
		else{
			throw new AssertionError("expected and actual don't have same size");
		}
		
	}
}