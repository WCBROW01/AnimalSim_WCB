/**
 * Test application for the animal simulator.
 * @author Will Brown
 * @version 1.0
 * Spring 2021
 */
public class Application {

	/**
	 * Execute all the tests and print a new line once each one is finished
	 * @param args
	 */
	public static void main(String[] args) {
		locationTests();
		System.out.println();
		animalTests();
		System.out.println();
		goldfinchTests();
		System.out.println();
		brownBearTests();
	}
	
	/**
	 * Tests for Location class
	 */
	private static void locationTests() {
		System.out.println("*********************************************\n"
				+ "\t\tLocation Tests\n"
				+ "*********************************************");
		
		// Test empty-argument constructor
		Location location = new Location();
		if (location.getxCoord() == 0 && location.getyCoord() == 0) {
			System.out.println("Empty-argument constructor test passed");
		} else {
			System.out.println("Empty-argument constructor test failed");
		}

		// Test preferred constructor
		try {
			location = new Location(1, 3);
			System.out.println("Preferred constructor test passed");
		} catch (InvalidCoordinateException e) {
			System.out.println("Preferred constructor test failed");
		}
		
		// Test getters/setters
		location.setxCoord(5);
		try {
			if (location.getxCoord() == 5) {
				System.out.println("X coordinate getter/setter test passed");
			} else {
				System.out.println("X coordinate getter/setter test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("X coordinate getter/setter test failed");
		}
		
		try {
			location.setyCoord(5);
			if (location.getyCoord() == 5) {
				System.out.println("Y coordinate getter/setter test passed");
			} else {
				System.out.println("Y coordinate getter/setter test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Y coordinate getter/setter test failed");
		}
		
		// Test update method
		try {
			location.update(2, 4);
			if (location.getxCoord() == 2 && location.getyCoord() == 4) {
				System.out.println("update test passed");
			} else {
				System.out.println("update test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("update test failed");
		}
	
		// Test getCoordinates method
		int[] locationCoordinates = location.getCoordinates();
		if (locationCoordinates[0] == location.getxCoord() && locationCoordinates[1] == location.getyCoord()) {
			System.out.println("getCoordinates test passed");
		} else {
			System.out.println("getCoordinates test failed");
		}
		
		// Test InvalidCoordinateException for x coordinate
		try {
			location.setxCoord(-1); // Intentionally set bad value
			System.out.println("InvalidCoordinateException test failed for x coordinate");
		} catch (InvalidCoordinateException e) {
			if (e.getMessage().equals("Invalid x coordinate")) { // Check whether the exception was thrown for the correct reason
				System.out.println("InvalidCoordinateException test passed for x coordinate");
			} else {
				System.out.println("InvalidCoordinateException test failed for x coordinate");
			}
		}
		
		// Test InvalidCoordinateException for y coordinate
		try {
			location.setyCoord(-1);
			System.out.println("InvalidCoordinateException test failed for y coordinate");
		} catch (InvalidCoordinateException e) {
			if (e.getMessage().equals("Invalid y coordinate")) {
				System.out.println("InvalidCoordinateException test passed for y coordinate");
			} else {
				System.out.println("InvalidCoordinateException test failed for y coordinate");
			}
		}
	}
	
	/**
	 * Tests for Animal class
	 */
	private static void animalTests() {
		System.out.println("*********************************************\n"
				+ "\t\tAnimal Tests\n"
				+ "*********************************************");
		
		// Uncomment the line below to see the program crash from instantiating Animal
		//Animal animal = new Animal();
		
		/*
		 * The Animal tests will be run from Goldfinch since it inherits Animal.
		 * Behavior should be identical if substituted with BrownBear.
		 */
		Animal animal = new Goldfinch();
		
		// Test getters/setters
		try {
			animal.setSimID(1);
			if (animal.getSimID() == 1) {
				System.out.println("simID getter/setter test passed.");
			} else {
				System.out.println("simID getter/setter test failed");
			}
		} catch (InvalidSimIDException e) {
			System.out.println("simID getter/setter test failed");
		}

		Location animalLocation = new Location(1, 6);
		animal.setLocation(animalLocation);
		if (animal.getLocation() == animalLocation) {
			System.out.println("location getter/setter test passed");
		} else {
			System.out.println("location getter/setter test failed");
		}
		
		animal.setFull(true);
		if (animal.isFull()) {
			System.out.println("full getter/setter test passed");
		} else {
			System.out.println("full getter/setter test failed");
		}
		
		animal.setRested(false);
		if (!animal.isRested()) {
			System.out.println("rested getter/setter test passed");
		} else {
			System.out.println("rested getter/setter test failed");
		}
		
		// Test eat. I'm running it a few times looking for a false result because it seems to be biased towards true.
		int i; // iterator
		boolean full = true;
		for (i = 0; i < 10; i++) {
			animal.eat();
			if (!animal.isFull()) {
				full = false;
			}
		}
		
		if (!full) {
			System.out.println("eat test passed");
		} else {
			System.out.println("eat test failed");
		}
		
		// Test sleep
		boolean rested = true;
		for (i = 0; i < 10; i++) {
			animal.sleep();
			if (!animal.isRested()) {
				rested = false;
			}
		}
		
		if (!rested) {
			System.out.println("sleep test passed");
		} else {
			System.out.println("sleep test failed");
		}
		
		// Test InvalidSimIDExcepton
		try {
			animal.setSimID(-1);
			System.out.println("InvalidSimIDException test failed");
		} catch (InvalidSimIDException e) {
			if (e.getMessage().equals("Invalid Sim ID")) {
				System.out.println("InvalidSimIDException test passed");
			} else {
				System.out.println("InvalidSimIDException test failed");
			}
		}
	}
	
	/**
	 * Tests for Goldfinch class
	 */
	private static void goldfinchTests() {
		System.out.println("*********************************************\n"
				+ "\t\tGoldfinch Tests\n"
				+ "*********************************************");
		
		// Test empty-argument constructor
		Goldfinch goldfinch = new Goldfinch();
		if (goldfinch.getSimID() == 0 && goldfinch.getLocation().getxCoord() == 0 && goldfinch.getLocation().getyCoord() == 0 && goldfinch.getWingSpan() == 9.0) {
			System.out.println("Empty-argument constructor test passed");
		} else {
			System.out.println("Empty-argument constructor test failed");
		}
		
		// Test preferred constructor
		try {
			Location goldfinchLocation = new Location(3, 7);
			goldfinch = new Goldfinch(1, goldfinchLocation, 10.0);
			if (goldfinch.getSimID() == 1 && goldfinch.getLocation() == goldfinchLocation && goldfinch.getWingSpan() == 10.0) {
				System.out.println("Preferred constructor test passed");
			} else {
				System.out.println("Preferred constructor test failed");
			}
		} catch (InvalidCoordinateException | InvalidWingspanException e) {
			System.out.println("Preferred constructor test failed");
		}
		
		// Test getters/setters
		try {
			goldfinch.setWingSpan(7.6);
			if (goldfinch.getWingSpan() == 7.6) {
				System.out.println("wingSpan getter/setter test passed");
			} else {
				System.out.println("wingSpan getter/setter test failed");
			}
		} catch (InvalidWingspanException e) {
			System.out.println("wingSpan getter/setter test failed");
		}
		
		// Test walk left
		try {
			goldfinch.walk(-2);
			if (goldfinch.getLocation().getxCoord() == 2) {
				System.out.println("Walk left test passed");
			} else {
				System.out.println("Walk left test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Walk left test failed");
		}
		
		// Test walk right
		try {
			goldfinch.walk(2);
			if (goldfinch.getLocation().getxCoord() == 3) {
				System.out.println("Walk right test passed");
			} else {
				System.out.println("Walk right test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Walk right test failed");
		}
		
		// Test walk down
		try {
			goldfinch.walk(-1);
			if (goldfinch.getLocation().getyCoord() == 6) {
				System.out.println("Walk down test passed");
			} else {
				System.out.println("Walk down test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Walk down test failed");
		}
		
		// Test walk up
		try {
			goldfinch.walk(1);
			if (goldfinch.getLocation().getyCoord() == 7) {
				System.out.println("Walk up test passed");
			} else {
				System.out.println("Walk up test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Walk up test failed");
		}
		
		// Test fly
		try {
			Location goldfinchLocation = new Location(5, 19);
			goldfinch.fly(goldfinchLocation);
			if (goldfinch.getLocation() == goldfinchLocation) {
				System.out.println("fly test passed");
			} else {
				System.out.println("fly test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("fly test failed");
		}
		
		// Test InvalidWingspanException for low value
		try {
			goldfinch.setWingSpan(4.7);
			System.out.println("InvalidWingspanException test failed for low value");
		} catch (InvalidWingspanException e) {
			if (e.getMessage().equals("Invalid wingspan")) {
				System.out.println("InvalidWingspanException test passed for low value");
			} else {
				System.out.println("InvalidWingspanException test failed for low value");
			}
		}
		
		// Test InvalidWingspanException for high value
		try {
			goldfinch.setWingSpan(12.0);
			System.out.println("InvalidWingspanException test failed for high value");
		} catch (InvalidWingspanException e) {
			if (e.getMessage().equals("Invalid wingspan")) {
				System.out.println("InvalidWingspanException test passed for high value");
			} else {
				System.out.println("InvalidWingspanException test failed for high value");
			}
		}
	}
	
	/**
	 * Tests for BrownBear class
	 */
	private static void brownBearTests() {
		System.out.println("*********************************************\n"
				+ "\t\tBrownBear Tests\n"
				+ "*********************************************");
		
		// Test empty-argument constructor
		BrownBear brownBear = new BrownBear();
		if (brownBear.getSimID() == 0 && brownBear.getLocation().getxCoord() == 0 && brownBear.getLocation().getyCoord() == 0 && brownBear.getSubSpecies().equals("Alaskan")) {
			System.out.println("Empty-argument constructor test passed");
		} else {
			System.out.println("Empty-argument constructor test failed");
		}
		
		// Test preferred constructor
		try {
			Location brownBearLocation = new Location(4, 9);
			brownBear = new BrownBear(2, brownBearLocation, "Grizzly");
			if (brownBear.getSimID() == 2 && brownBear.getLocation() == brownBearLocation && brownBear.getSubSpecies().equals("Grizzly")) {
				System.out.println("Preferred constructor test passed");
			} else {
				System.out.println("Preferred constructor test failed");
			}
		} catch (InvalidSubspeciesException e) {
			System.out.println("Preferred constructor test failed");
		}
		
		// Test getters/setters
		try {
			String[] subSpeciesTypes = { "Alaskan", "Asiatic", "European", "Grizzly", "Kodiak", "Siberian" }; // Valid subSpecies values
			boolean subSpeciesTestPassed = true; // This will be false if any value fails
			
			for (String subSpecies : subSpeciesTypes) {
				brownBear.setSubSpecies(subSpecies);
				if (!brownBear.getSubSpecies().equals(subSpecies)) {
					subSpeciesTestPassed = false;
				}
			}
			
			if (subSpeciesTestPassed) {
				System.out.println("subSpecies getter/setter test passed");
			} else {
				System.out.println("subSpecies getter/setter test failed");
			}
		} catch (InvalidSubspeciesException e) {
			System.out.println("subSpecies getter/setter test failed");
		}
		
		// Test walk left
		try {
			brownBear.walk(-2);
			if (brownBear.getLocation().getxCoord() == 1) {
				System.out.println("Walk left test passed");
			} else {
				System.out.println("Walk left test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Walk left test failed");
		}
		
		// Test walk right
		try {
			brownBear.walk(2);
			if (brownBear.getLocation().getxCoord() == 4) {
				System.out.println("Walk right test passed");
			} else {
				System.out.println("Walk right test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Walk right test failed");
		}
		
		// Test walk down
		try {
			brownBear.walk(-1);
			if (brownBear.getLocation().getyCoord() == 6) {
				System.out.println("Walk down test passed");
			} else {
				System.out.println("Walk down test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Walk down test failed");
		}
		
		// Test walk up
		try {
			brownBear.walk(1);
			if (brownBear.getLocation().getyCoord() == 9) {
				System.out.println("Walk up test passed");
			} else {
				System.out.println("Walk up test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Walk up test failed");
		}
		
		// Test swim left
		try {
			brownBear.swim(-2);
			if (brownBear.getLocation().getxCoord() == 2) {
				System.out.println("Swim left test passed");
			} else {
				System.out.println("Swim left test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Swim left test failed");
		}
		
		// Test swim right
		try {
			brownBear.swim(2);
			if (brownBear.getLocation().getxCoord() == 4) {
				System.out.println("Swim right test passed");
			} else {
				System.out.println("Swim right test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Swim right test failed");
		}
		
		// Test swim down
		try {
			brownBear.swim(-1);
			if (brownBear.getLocation().getyCoord() == 7) {
				System.out.println("Swim down test passed");
			} else {
				System.out.println("Swim down test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Swim down test failed");
		}
		
		// Test swim up
		try {
			brownBear.swim(1);
			if (brownBear.getLocation().getyCoord() == 9) {
				System.out.println("Swim up test passed");
			} else {
				System.out.println("Swim up test failed");
			}
		} catch (InvalidCoordinateException e) {
			System.out.println("Swim up test failed");
		}
		
		// Test InvalidSubspeciesException
		try {
			brownBear.setSubSpecies("Fake");
			System.out.println("InvalidSubspeciesException test failed");
		} catch (InvalidSubspeciesException e) {
			if (e.getMessage().equals("Invalid subspecies")) {
				System.out.println("InvalidSubspeciesException test passed");
			} else {
				System.out.println("InvalidSubspeciesException test failed");
			}
		}
	}
}
