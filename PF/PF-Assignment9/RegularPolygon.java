
public class RegularPolygon implements Shape{

	double numberOfSides;
	double sideLength;
	Point point;
	
	RegularPolygon(double numberOfSides, double sideLength, Point point){
		this.numberOfSides = numberOfSides;
		this.sideLength = sideLength;
		this.point = point;
	}
	
	public double getArea(){
		double perimeter = getPerimeter();
		double angleApothem = Math.tan(180/this.numberOfSides);
		double apothem = perimeter / (2 * angleApothem);
		return (perimeter * apothem)/2;
	}
	

	public double getPerimeter() {
		return this.numberOfSides * this.sideLength;
	}
	 
	public Point getOrigin(){
		return this.point;
	}
	
	public boolean isPointEnclosed(int x,int y){
		return true;
	}
	
	public ShapeType getType(){
		return ShapeType.REGULARPOLYGON;
	}


}
