package assignment3;
import java.util.Scanner;

public class Area {
	
	/**
	 * calculates area of triangle
	 * @param width as a base of triangle
	 * @param height as height of triangle
	 * @return area of triangle which is half of the product of height and width
	 */
	double triangle (double width, double height) throws ArithmeticException{
		double area = 0.0;
		area  = 0.5 * width * height ;
		return area;
	}
	
	/**
	 * calculates area of rectangle
	 * @param width 
	 * @param height
	 * @return area of rectangle which is product of height and width
	 */
	double rectangle(double width, double height) throws ArithmeticException{
		double area = 0.0;
		area = width * height;
		return area;
	}
	
	/**
	 * calculates area of square
	 * @param width as length of side of a square
	 * @return area of square which is square of sides.
	 */
	double square(double width) throws ArithmeticException{
		double area = 0.0;
		area = width * width;
		return area;
	}
	
	/**
	 * calculates area of circle
	 * @param radius
	 * @return area of circle which is product of pie and square of sides.
	 */
	double circle(double radius) throws ArithmeticException{
		double area = 0.0;
		area = 3.14 * radius * radius;
		return area;
	}
	
	public static void main(String args[]){
		
		Area obj = new Area();
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.println("-------------------------------");
			System.out.println("1.Calculate area of Triangle");
			System.out.println("2.Calculate area of Rectangle");
			System.out.println("3.Calculate area of Square");
			System.out.println("4.Calculate area of Circle");
			System.out.println("5.Exit");
			System.out.println("-------------------------------");
			
			System.out.println("Enter your choice:");
			
			int choice = sc.nextInt();
			
			switch(choice){
			
				case 1:
					System.out.println("ENTER WIDTH AND HEIGHT");
					double triangleWidth = sc.nextDouble();
					double triangleHeight = sc.nextDouble();
					System.out.println("TRIANGLE AREA: " + obj.triangle(triangleWidth, triangleHeight));
					break;
				case 2:
					System.out.println("ENTER WIDTH AND HEIGHT");
					double rectangleWidth = sc.nextDouble();
					double rectangleHeight = sc.nextDouble();
					System.out.println("RECTANGLE AREA: " + obj.rectangle(rectangleWidth, rectangleHeight));
					break;
				case 3:
					System.out.println("ENTER SIDE");
					double side = sc.nextDouble();
					System.out.println("SQUARE AREA: " + obj.square(side));
					break;
				case 4:
					System.out.println("ENTER RADIUS");
					double radius = sc.nextDouble();
					System.out.println("CIRCLE AREA: " + obj.circle(radius));
					break;
				case 5:
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("");
					break;
			}
			
		}while(true);
	}
}
