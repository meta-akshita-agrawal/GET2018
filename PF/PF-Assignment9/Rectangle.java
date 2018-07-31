
public class Rectangle implements Shape{

	double width;
	double height;
	Point point;
	
	Rectangle(double width,double height, Point point){
		this.width = width;
		this.height = height;
		this.point = point;
	}
	
	public double getArea(){
		return (this.width * this.height)%.2f;
	}
	
	public double getPerimeter(){
		return 2 * (this.width + this.height)%.2f;
	}
	
	public Point getOrigin(){
		return this.point;
	}
	
	public boolean isPointEnclosed(int x,int y){
		double rangeLowerX = this.point.x;
		double rangeUpperX = rangeLowerX + this.width;
		double rangeLowerY = this.point.y;
		double rangeUpperY = rangeLowerY + this.height;
		return (x>rangeLowerX && x<rangeUpperX) && (y>rangeLowerY && y<rangeUpperY);
	}
	public ShapeType getType(){
		return ShapeType.RECTANGLE;
	}
}
