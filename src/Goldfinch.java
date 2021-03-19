/**
 * Class that simulates a goldfinch.
 * @author Will Brown
 * @version 1.0
 * Spring 2021
 */
public class Goldfinch extends Animal implements Walkable, Flyable {

	private double wingSpan;
	
	/**
	 * Sets default values for the goldfinch.
	 */
	public Goldfinch() {
		super();
		wingSpan = 9.0;
	}
	
	/**
	 * @param simID
	 * @param l
	 * @param wingSpan
	 */
	public Goldfinch(int simID, Location l, double ws) {
		super(simID, l);
		setWingSpan(ws);
	}
	
	/**
	 * Walk 1 unit in the specified direction. (Up: 1, Down: 1, Left: -2, Right: 2)
	 */
	public void walk(int direction) {
		switch (direction) {
		case -2:
			location.setxCoord(location.getxCoord() - 1);
			break;
		case -1:
			location.setxCoord(location.getyCoord() - 1);
			break;
		case 1:
			location.setyCoord(location.getyCoord() + 1);
			break;
		case 2:
			location.setxCoord(location.getxCoord() + 1);
			break;
		default:
			throw new InvalidCoordinateException("Invalid direction");
		}
	}
	
	public void fly(Location l) {
		location = l;
	}

	/**
	 * @return the wingspan
	 */
	public double getWingSpan() {
		return wingSpan;
	}

	/**
	 * @param ws the wingspan to set (must be between 5.0 and 11.0, inclusive)
	 */
	public void setWingSpan(double ws) {
		try {
		if (ws < 5.0 || ws > 11.0) throw new InvalidWingspanException("Invalid wingspan");
		else wingSpan = ws;
		} catch (InvalidWingspanException e) {
			System.out.println(e.getMessage());
		}
	}

}
