import java.util.ArrayList;

import org.junit.Test;

public class ShapeTest {

	@Test
	public void createShapePositive() {
		Screen screenObj = new Screen();
		Point point = new Point(2,2);
		ArrayList<Double> parameters = new ArrayList<>();
		parameters.add(5.00);
		screenObj.createShape(ShapeType.SQAURE, point, parameters);
	}
}
