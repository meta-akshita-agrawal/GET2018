/**\
 * Point class for taking x y coordinates
 * which are assumed to be positive
 */
public class Point {
	
	double x;
	double y;
	
	//Parameterized constructor taking x and y as parameters
	Point(double x, double y){
		if(x<0.00 || y<0.00){
			throw new AssertionError("Screen is only limited to poisitive coordinates");//if points are entered negative 
		}
		
		this.x = x;
		this.y = y;
	}
}
