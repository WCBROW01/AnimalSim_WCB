/**
 * Encapsulates a point on a simulated map.
 * @author Will Brown
 * @version 1.0
 * Spring 2021
 */
public class Location {

	private int xCoord;
	private int yCoord;

	/**
	 * Sets x and y coordinate values to 0.
	 */
	public Location() {
		xCoord = 0;
		yCoord = 0;
	}
	
	/**
	 * Sets x and y coordinates based on the parameters passed
	 * @param x the x coordinate to set
	 * @param y the y coordinate to set
	 */
	public Location(int x, int y) {
		setxCoord(x);
		setyCoord(y);
	}
	
	/**
	 * Updates the x and y coordinates.
	 * @param x the x coordinate to set
	 * @param y the y coordinate to set
	 */
	public void update(int x, int y) {
		setxCoord(x);
		setyCoord(y);
	}
	
	/**
	 * Gets the x and y coordinates and returns them in an array,
	 * with the x-coordinate being first and y coordinate being second.
	 * @return an array containing the x and y coordinates
	 */
	public int[] getCoordinates() {
		int[] coordArray = { xCoord, yCoord };
		return coordArray;
	}

	/**
	 * @return the x coordinate
	 */
	public int getxCoord() {
		return xCoord;
	}

	/**
	 * @param x the x coordinate to set (must be positive)
	 */
	public void setxCoord(int x) {
		try {
			if (x < 0) throw new InvalidCoordinateException("Invalid x coordinate");
			else xCoord = x;
		} catch (InvalidCoordinateException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @return the y coordinate
	 */
	public int getyCoord() {
		return yCoord;
	}

	/**
	 * @param y the y coordinate to set (must be positive)
	 */
	public void setyCoord(int y) {
		try {
			if (y < 0) throw new InvalidCoordinateException("Invalid y coordinate");
			else yCoord = y;
		} catch (InvalidCoordinateException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
