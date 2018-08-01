import java.util.ArrayList;
import java.util.List;

public class Screen {

	ArrayList<Shape> shapeList = new ArrayList<>();

	public void createShape(ShapeType type, Point point, List<Double> parameters) {

		Shape obj = ShapeFactory.createShape(type, point, parameters);
		shapeList.add(obj);
	}

	public void deleteShape(ShapeType type) {
		for (Shape value : shapeList) {
			if (value.getType() == type) {
				shapeList.remove(value);
				return;
			}
		}
	}

	public void deleteAll() {
		shapeList.clear();
	}

	public double originDistance(Point point) {
		double distanceX = point.x * point.x;
		double distanceY = point.y * point.y;
		double distanceSum = distanceX + distanceY;
		return Math.sqrt(distanceSum);
	}

	public ArrayList<Shape> sort(SortType basedOn) {
		Shape temp;
		switch (basedOn) {
		case AREA:
			for (int i = 0; i < this.shapeList.size() - 1; i++) {
				for (int j = 0; j < this.shapeList.size() - i - 1; j++) {
					if (shapeList.get(j).getArea() > shapeList.get(j + 1).getArea()) {
						temp = shapeList.get(j);
						shapeList.set(j, shapeList.get(j + 1));
						shapeList.set(j + 1, temp);
					}
				}
			}
			return this.shapeList;
		case ORIGINDISTANCE:
			for (int i = 0; i < this.shapeList.size() - 1; i++) {
				for (int j = 0; j < this.shapeList.size() - i - 1; j++) {
					Point point1 = shapeList.get(j).getOrigin();
					Point point2 = shapeList.get(j + 1).getOrigin();
					if (originDistance(point1) > originDistance(point2)) {
						temp = shapeList.get(j);
						shapeList.set(j, shapeList.get(j + 1));
						shapeList.set(j + 1, temp);
					}
				}
			}
			return this.shapeList;
		case PERIMTEER:
			for (int i = 0; i < this.shapeList.size() - 1; i++) {
				for (int j = 0; j < this.shapeList.size() - i - 1; j++) {
					if (shapeList.get(j).getPerimeter() > shapeList.get(j + 1).getPerimeter()) {
						temp = shapeList.get(j);
						shapeList.set(j, shapeList.get(j + 1));
						shapeList.set(j + 1, temp);
					}
				}
			}
			return this.shapeList;
		default:
			return null;

		}
	}

	public ArrayList<Shape> deleteByType(ShapeType type) {
		for (int i = 0; i < this.shapeList.size(); i++) {
			if (type == this.shapeList.get(i).getType()) {
				this.shapeList.remove(i);
			}
		}
		return this.shapeList;
	}


}
