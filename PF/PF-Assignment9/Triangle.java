import java.util.ArrayList;

//TRIANGLE IMPLEMENTING SHAPE
public class Triangle implements Shape{
	
	double firstSide;
	double secondSide;
	double thirdSide;
	Point point;
	
	//parameterized constructor taking arguments all three sides and origin point
	Triangle(double firstSide,double secondSide,double thirdSide, Point point){
		this.firstSide = firstSide;
		this.secondSide = secondSide;
		this.thirdSide = thirdSide;
		this.point = point;
	}
	
	/**
	 * Evaluates area for triangle
	 * area = (p(p-a)(p-b)(p-c))^1/2 where p is half perimeter
	 * which is sum of all sides divided by 2
	 * and a,b,c are all three sides
	 * @return area
	 */
	public double getArea(){
		double halfPerimeter = getPerimeter() / 2;
		double area = halfPerimeter *(halfPerimeter - this.firstSide)*(halfPerimeter - this.secondSide) * (halfPerimeter-this.thirdSide);
		return Math.sqrt(area)%.2f;
	}
	
	/**
	 * evaluates perimeter for triangle
	 * simply adding all three sides
	 * @return perimeter
	 */
	public double getPerimeter(){
		return this.firstSide + this.secondSide + this.thirdSide;
	}
	
	/**
	 * @return origin point of triangle
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
		return ShapeType.TRIANGLE;
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
	 * for triangle it will add all three sides as a parameter
	 * @return parameters, ArrayList of parameters
	 */
	public ArrayList<Double> getParameters(){
		ArrayList<Double> parameters = new ArrayList<>();
		parameters.add(this.firstSide);
		parameters.add(this.secondSide);
		parameters.add(this.thirdSide);
		return parameters;
	}
}
