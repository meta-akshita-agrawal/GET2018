import java.util.ArrayList;

/**
 * Shape interface implementing:
 * getArea() : retrieves area for any shape object
 * getPerimeter() : retrieves perimeter for any shape object
 * getOrigin()
 */
public interface Shape {
	
	
	double getArea(); //retrieves area for any shape object
	double getPerimeter(); //retrieves perimeter for any shape object
	Point getOrigin(); //retrieves shape origin of any shape object
	boolean isPointEnclosed(int x,int y); // checks if a point is enclosed in the shape object
	ShapeType getType(); //retrieves type of a shape object such as square,rectangle,etc
	double originDistance(Point point); // evaluates distance between shape origin and screen origin i.e.(0,0) 
	ArrayList<Double> getParameters(); //retrieves parameters of a shape object 
									  // such as square only width, circle only radius,etc
}
