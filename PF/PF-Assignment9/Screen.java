import java.util.ArrayList;
import java.util.List;

public class Screen {

	ArrayList<Shape> shapeList = new ArrayList<>();//shape list for storing all shape objects
	Point point; 

	/**
	 * Creates a shape using factory object
	 * @param shape type
	 * @param point, (x,y)
	 * @param parameters, list of parameters which could be different for different shape types
	 */
	public void createShape(ShapeType type, Point point, List<Double> parameters) {

		Shape obj = ShapeFactory.createShape(type, point, parameters);
		shapeList.add(obj);
	}

	/**
	 * Deletes oldest shape object of the given type
	 * @param shape type
	 */
	public void deleteShape(ShapeType type) {
		for (Shape value : shapeList) {
			if (value.getType() == type) {
				shapeList.remove(value);
			}
		}
	}

	/**
	 * Deletes all shape object of given shape type
	 * @param shape type
	 */
	public void deleteByType(ShapeType type) {
		for (int i = 0; i < this.shapeList.size(); i++) {
			if (type == this.shapeList.get(i).getType()) {
				this.shapeList.remove(i);
				i--;
			}
		}
	}

	/**
	 * Sorts a list according to different categories
	 * like area, perimeter, origin distance of a shape object
	 * @param basedOn, sorting type AREA, PERIMETER, ORIGIN DISTANCE
	 */
	public void sort(SortType basedOn) {

		switch (basedOn) {
		case AREA:
			AreaSort areaObj = new AreaSort();
			areaObj.executeSort(this.shapeList);
			break;
		case ORIGINDISTANCE:
			DistanceSort distanceObj = new DistanceSort();
			distanceObj.executeSort(this.shapeList);
			break;
		case PERIMTER:
			PerimeterSort perimObj = new PerimeterSort();
			perimObj.executeSort(this.shapeList);
			break;
		default:
			break;

		}

	}
}
