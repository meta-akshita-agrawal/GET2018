
public interface Shape {
	
	
	double getArea();
	double getPerimeter();
	Point getOrigin();
	boolean isPointEnclosed(int x,int y);
	ShapeType getType();
}
