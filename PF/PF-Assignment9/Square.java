import java.util.ArrayList;

//SQUARE IMPLEMENTING SHAPE
public class Square implements Shape{
	double side;
	Point point;
	
	//parameterized constructor taking arguments side and origin point
	Square(double side, Point point){
		this.side = side;
		this.point = point;
	}
	
	/**
	 * Evaluates area for square
	 * side * side
	 * @return area
	 */
	public double getArea(){
		return (this.side * this.side)%.2f;
	}
	
	/**
	 * evaluates perimeter for square
	 * 4 * side
	 * @return perimeter
	 */
	public double getPerimeter(){
		return (4 * this.side)%.2f;
	}
	
	/**
	 * @return origin point of square
	 */
	public Point getOrigin(){
		return this.point;
	}
	
	/**
	 * checks if a point is enclosed in a shape object
	 * checks if x and y lies in between line equations of sides
	 * @return true if it point is enclosed else false
	 */
	public boolean isPointEnclosed(int x,int y){
		double rangeLowerX = this.point.x;
		double rangeUpperX = rangeLowerX + this.side;
		double rangeLowerY = this.point.y;
		double rangeUpperY = rangeLowerY + this.side;
		return (x>rangeLowerX && x<rangeUpperX) && (y>rangeLowerY && y<rangeUpperY);
	}
	
	/**
	 * @return type of a shape object
	 */
	public ShapeType getType(){
		return ShapeType.SQAURE;
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
	 * for square it will add side as a parameter
	 * @return parameters, ArrayList of parameters
	 */
	public ArrayList<Double> getParameters(){
		ArrayList<Double> parameters = new ArrayList<>();
		parameters.add(this.side);
		return parameters;
	}
}
