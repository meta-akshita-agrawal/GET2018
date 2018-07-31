import java.util.List;


public class ShapeFactory {
	
	
	public static Shape createShape(ShapeType type, Point point,List<Double> parameters){
		switch(type){
		
		case SQAURE:
			double side = parameters.get(0);
			Square squareObj = new Square(side,point);
			return squareObj;
		case RECTANGLE:
			double width = parameters.get(0);
			double height = parameters.get(1);
			Rectangle recObj = new Rectangle(width,height,point);
			return recObj;
		case CIRCLE:
			double radius = parameters.get(0);
			Circle circleObj = new Circle(radius,point);
			return circleObj;
		case REGULARPOLYGON:
			double numberOfSides = parameters.get(0);
			double sideLength = parameters.get(1);
			RegularPolygon polyObj = new RegularPolygon(numberOfSides,sideLength,point);
			return polyObj;
		case TRIANGLE:
			double firstSide = parameters.get(0);
			double secondSide = parameters.get(1);
			double thirdSide = parameters.get(2);
			Triangle triangleObj = new Triangle(firstSide,secondSide,thirdSide,point);
			return triangleObj;
		default:
			return null;
			
		}
	}

}
