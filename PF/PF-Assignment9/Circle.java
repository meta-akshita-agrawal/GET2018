
public class Circle implements Shape{

	
	double radius;
	Point point;
	final double PI = Math.PI;
	
	Circle(double radius, Point point){
		this.radius = radius;
		this.point = point;
	}
	
	public double getArea(){
		return  (PI * this.radius * this.radius)%.2f;
	}
	
	public double getPerimeter(){
		return (2 * PI * this.radius)%.2f;
	}
	
	public Point getOrigin(){
		return this.point;
	}
	
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
	
	public ShapeType getType(){
		return ShapeType.CIRCLE;
	}
	
	private Point evaluateCentre(){
		
		double originDistance = originDistance(this.point);
		double ratioConstant = 1+(this.radius/originDistance);
		double x = (this.point.x * ratioConstant)%.2f;
		double y = (this.point.y * ratioConstant)%.2f;
		return new Point(x,y);
		
	}
	
	private double originDistance(Point point){
		double distanceX = point.x * point.x;
		double distanceY = point.y * point.y;
		double distanceSum = distanceX + distanceY;
		return Math.sqrt(distanceSum);
	}
	
}
