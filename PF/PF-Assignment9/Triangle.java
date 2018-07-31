
public class Triangle implements Shape{
	
	double firstSide;
	double secondSide;
	double thirdSide;
	Point point;
	
	Triangle(double firstSide,double secondSide,double thirdSide, Point point){
		this.firstSide = firstSide;
		this.secondSide = secondSide;
		this.thirdSide = thirdSide;
		this.point = point;
	}
	
	public double getArea(){
		double halfPerimeter = getPerimeter() / 2;
		double area = halfPerimeter *(halfPerimeter - this.firstSide)*(halfPerimeter - this.secondSide) * (halfPerimeter-this.thirdSide);
		return Math.sqrt(area)%.2f;
	}
	
	public double getPerimeter(){
		return this.firstSide + this.secondSide + this.thirdSide;
	}
	
	public Point getOrigin(){
		return this.point;
	}
	
	public boolean isPointEnclosed(int x,int y){
		return true;
	}
	
	public ShapeType getType(){
		return ShapeType.TRIANGLE;
	}
}

