import java.util.ArrayList;

//CIRCLE IMPLEMENTING SHAPE
public class Circle implements Shape{

	
	double radius;
	Point point;
	final double PI = Math.PI;
	
	//parameterized constructor taking arguments radius and origin point
	Circle(double radius, Point point){
		this.radius = radius;
		this.point = point;
	}
	
	/**
	 * Evaluates area for circle
	 * PI * radius^2
	 * @return area
	 */
	public double getArea(){
		return  (PI * this.radius * this.radius)%.2f;
	}
	
	/**
	 * evaluates perimeter for circle
	 * 2 * PI * radius
	 * @return perimeter
	 */
	public double getPerimeter(){
		return (2 * PI * this.radius)%.2f;
	}
	
	/**
	 * @return origin point of circle
	 */
	public Point getOrigin(){
		return this.point;
	}
	
	/**
	 * checks if a point is enclosed in a shape object
	 * distaceFromCentre^2 = (xp - xc)^2 + (yp - yc)^2
	 * @return true if it point is enclosed else false
	 */
	public boolean isPointEnclosed(int x,int y){
		Point centrePoint = evaluateCentre();
		double distanceFromCentre;
		double distanceX = Math.pow(point.x - centrePoint.x, 2);
		double distanceY = Math.pow(point.y - centrePoint.y, 2);
		distanceFromCentre = Math.sqrt(distanceX + distanceY);
		if(distanceFromCentre < this.radius){
			return true;
		}
		return false;
	}
	
	/**
	 * @return type of a shape object
	 */
	public ShapeType getType(){
		return ShapeType.CIRCLE;
	}
	
	/**
	 * evaluates center of a circle 
	 * using ratio point line concept
	 * x = (mx2 + mx1)/(m+n), x is origin point x coordinate which we have 
	 * y = (my2 + my1)/(m+n), y is origin point y coordinate which we have
	 * x1,y1 is screen origin which is (0,0)
	 * n is radius
	 * m is origin distance from screen origin to shape origin 
	 * which can be retrieved from originDistance function
	 * @return
	 */
	private Point evaluateCentre(){
		
		double originDistance = originDistance(this.point);
		double ratioConstant = 1+(this.radius/originDistance);
		double x = (this.point.x * ratioConstant)%.2f;
		double y = (this.point.y * ratioConstant)%.2f;
		return new Point(x,y);
		
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
	 * for circle it will add radius as a parameter
	 * @return parameters, ArrayList of parameters
	 */
	public ArrayList<Double> getParameters(){
		ArrayList<Double> parameters = new ArrayList<>();
		parameters.add(this.radius);
		return parameters;
	}
	
}
