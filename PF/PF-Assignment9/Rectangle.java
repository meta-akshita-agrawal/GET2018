import java.util.ArrayList;

//RECTANGLE IMPLEMENTING SHAPE
public class Rectangle implements Shape{

	double width;
	double height;
	Point point;
	
	//parameterized constructor taking arguments height, width and origin point
	Rectangle(double width,double height, Point point){
		this.width = width;
		this.height = height;
		this.point = point;
	}
	
	/**
	 * Evaluates area for rectangle
	 * width * height
	 * @return area
	 */
	public double getArea(){
		return (this.width * this.height)%.2f;
	}
	
	/**
	 * evaluates perimeter for rectangle
	 * 2 * (width + height)
	 * @return perimeter
	 */
	public double getPerimeter(){
		return 2 * (this.width + this.height)%.2f;
	}
	
	/**
	 * @return origin point of rectangle
	 */
	public Point getOrigin(){
		return this.point;
	}
	
	/**
	 * checks if a point is enclosed in a shape object
	 * checks if x and y lies in between line equations of width and height
	 * @return true if it point is enclosed else false
	 */
	public boolean isPointEnclosed(int x,int y){
		double rangeLowerX = this.point.x;
		double rangeUpperX = rangeLowerX + this.width;
		double rangeLowerY = this.point.y;
		double rangeUpperY = rangeLowerY + this.height;
		return (x>rangeLowerX && x<rangeUpperX) && (y>rangeLowerY && y<rangeUpperY);
	}
	
	/**
	 * @return type of a shape object
	 */
	public ShapeType getType(){
		return ShapeType.RECTANGLE;
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
	 * for rectangle it will add width and height as parameter
	 * @return parameters, ArrayList of parameters
	 */
	public ArrayList<Double> getParameters(){
		ArrayList<Double> parameters = new ArrayList<>();
		parameters.add(this.width);
		parameters.add(this.height);
		return parameters;
	}
}
