/**
 * Class that simulates a Brown Bear.
 * @author Will Brown
 * @version 1.0
 * Spring 2021
 */
public class BrownBear extends Animal implements Walkable, Swimmable {

	private String subSpecies;
	
	/**
	 * Sets default values for the Brown Bear.
	 */
	public BrownBear() {
		super();
		subSpecies = "Alaskan";
	}
	
	/**
	 * @param simID
	 * @param l
	 * @param subSpecies
	 */
	public BrownBear(int simID, Location l, String subSpecies) {
		super(simID, l);
		setSubSpecies(subSpecies);
	}
	
	public void walk(int direction) {
		// TODO Auto-generated method stub
		
	}

	public void swim(int direction) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the sub-species
	 */
	public String getSubSpecies() {
		return subSpecies;
	}

	/**
	 * @param subSpecies the sub-species to set
	 */
	public void setSubSpecies(String subSpecies) {
		try {
			switch (subSpecies) {
			case "Alaskan":
				this.subSpecies = "Alaskan";
				break;
			case "Asiatic":
				this.subSpecies = "Asiatic";
				break;
			case "European":
				this.subSpecies = "European";
				break;
			case "Grizzly":
				this.subSpecies = "Grizzly";
				break;
			case "Kodiak":
				this.subSpecies = "Kodiak";
				break;
			case "Siberian":
				this.subSpecies = "Siberian";
				break;
			default:
				throw new InvalidSubspeciesException("Invalid subspecies");
			}
		} catch (InvalidSubspeciesException e) {
			System.out.println(e.getMessage());
		}
	}

}
