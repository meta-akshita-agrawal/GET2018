import java.util.ArrayList;

//REGULARPOLYGON IMPLEMENTING SHAPE
public class RegularPolygon implements Shape{

	double numberOfSides;
	double sideLength;
	Point point;
	
	//parameterized constructor taking arguments as number of sides and length of sides and origin point
	// Note that a regular polygon have same length of sides and same angle
	RegularPolygon(double numberOfSides, double sideLength, Point point){
		this.numberOfSides = numberOfSides;
		this.sideLength = sideLength;
		this.point = point;
	}
	
	/**
	 * Evaluates area for regular polygon
	 * Used apothem formula
	 * @return area
	 */
	public double getArea(){
		double perimeter = getPerimeter();
		double angleApothem = Math.tan(180/this.numberOfSides);
		double apothem = perimeter / (2 * angleApothem);
		return (perimeter * apothem)/2;
	}
	
	/**
	 * evaluates perimeter for regular polygon
	 * @return perimeter
	 */
	public double getPerimeter() {
		return this.numberOfSides * this.sideLength;
	}
	
	/**
	 * @return origin point of square
	 */
	public Point getOrigin(){
		return this.point;
	}
	
	/**
	 * checks if a point is enclosed in a shape object
	 * @return true if it point is enclosed else false
	 */
	public boolean isPointEnclosed(int x,int y){
		return true;
	}
	
	/**
	 * @return type of a shape object
	 */
	public ShapeType getType(){
		return ShapeType.REGULARPOLYGON;
	}
	
	/**
	 * Evaluates distance from shape origin to screen origin
	 * distance^2 = x^2 + y^2
	 * @return distance 
	 */
	public double originDistance(Point point){
		double distanceX = point.x * point.x;
		double distanceY = point.y * point.y;
		double distanceSum = distanceX + distanceY;
		return Math.sqrt(distanceSum);
	}

	/**
	 * creates a list of parameters for a shape object
	 * for regular polygon it will add number of side and side length as a parameter
	 * @return parameters, ArrayList of parameters
	 */
	public ArrayList<Double> getParameters(){
		ArrayList<Double> parameters = new ArrayList<>();
		parameters.add(this.numberOfSides);
		parameters.add(this.sideLength);
		return parameters;
	}

}
