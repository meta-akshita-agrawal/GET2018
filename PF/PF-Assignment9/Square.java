
public class Square implements Shape{
	double side;
	Point point;
	
	Square(double side, Point point){
		this.side = side;
		this.point = point;
	}
	
	public double getArea(){
		return (this.side * this.side)%.2f;
	}
	
	public double getPerimeter(){
		return (4 * this.side)%.2f;
	}
	
	public Point getOrigin(){
		return this.point;
	}
	
	public boolean isPointEnclosed(int x,int y){
		double rangeLowerX = this.point.x;
		double rangeUpperX = rangeLowerX + this.side;
		double rangeLowerY = this.point.y;
		double rangeUpperY = rangeLowerY + this.side;
		return (x>rangeLowerX && x<rangeUpperX) && (y>rangeLowerY && y<rangeUpperY);
	}
	
	public ShapeType getType(){
		return ShapeType.SQAURE;
	}
}
