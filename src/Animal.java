/**
 * Generic animal class.
 * @author Will Brown
 * @version 1.0
 * Spring 2021
 */
public abstract class Animal {

	protected int simID;
	protected Location location;
	protected boolean full;
	protected boolean rested;
	
	/**
	 * Sets everything to default values.
	 */
	public Animal() {
		simID = 0;
		location = new Location(0,0);
		full = false;
		rested = true;
	}
	
	/**
	 * Sets the Sim ID and location of the animal based on the parameters passed.
	 * @param simID
	 * @param location
	 */
	public Animal(int simID, Location l) {
		setSimID(simID);
		location = l;
		full = false;
		rested = true;
	}
	
	/**
	 * Have the animal eat. Whether the animal is full is determined randomly.
	 * @return whether the animal is full
	 */
	public boolean eat() {
		full = Math.random() > 0.5;
		return full;
	}
	
	/**
	 * Have the animal sleep. Whether the animal is well rested is determined randomly.
	 * @return whether the animal is well rested
	 */
	public boolean sleep() {
		rested = Math.random() > 0.5;
		return rested;
	}

	/**
	 * @return the simID
	 */
	public int getSimID() {
		return simID;
	}
	
	/**
	 * @param simID the simID to set
	 */
	public void setSimID(int simID) {
		try {
			if (simID < 1) throw new InvalidSimIDException("Invalid Sim ID");
			else this.simID = simID;
		} catch (InvalidSimIDException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * @param location the location to set
	 */
	public void setLocation(Location l) {
		location = l;
	}
	
	/**
	 * @return whether the animal is full
	 */
	public boolean isFull() {
		return full;
	}
	
	/**
	 * @param full set whether the animal is full
	 */
	public void setFull(boolean full) {
		this.full = full;
	}
	
	/**
	 * @return whether the animal is well rested
	 */
	public boolean isRested() {
		return rested;
	}
	
	/**
	 * @param rested set whether the animal is well rested
	 */
	public void setRested(boolean rested) {
		this.rested = rested;
	}
	
	
}
