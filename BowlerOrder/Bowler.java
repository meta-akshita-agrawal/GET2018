//Bowler having number of balls he can play and priority associated to him
public class Bowler {

	String name;
	int numberOfBalls;

	//Parameterized constructor
	Bowler(String name,	int numberOfBalls){
		this.name = name;
		this.numberOfBalls = numberOfBalls;
	}

	/**
	 * @return number of balls of a bowler
	 */
	public int getNumberOfBalls() {
		return this.numberOfBalls;
	}

	/**
	 * @return name of a bowler
	 */
	public String getName() {
		return name;
	}

}
