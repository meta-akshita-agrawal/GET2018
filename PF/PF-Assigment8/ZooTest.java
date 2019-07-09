import org.junit.Test;

public class ZooTest {

	Zoo zooObj = new Zoo();

	@Test
	public void addZonePositive() {

		Zone zoneObj1 = new Zone(1, Category.Mammal, 2, 2, true, true);
		zooObj.addZone(zoneObj1);
	}

	@Test(expected = AssertionError.class)
	public void addZoneDuplicateZoneIdError() {
		Zone zoneObj1 = new Zone(1, Category.Mammal, 2, 2, true, true);
		Zone zoneObj2 = new Zone(1, Category.Mammal, 2, 2, true, true);

		zooObj.addZone(zoneObj1);
		zooObj.addZone(zoneObj2);
	}

	@Test
	public void addCagePositive() {
		Zone zoneObj1 = new Zone(1, Category.Mammal, 2, 2, true, true);
		zooObj.addZone(zoneObj1);

		Cage cageObj1 = new Cage(11, Type.Lion, 2, 2);
		zooObj.addCage(cageObj1);
	}

	@Test(expected = AssertionError.class)
	public void addCageDuplicateCageId() {
		Zone zoneObj1 = new Zone(1, Category.Mammal, 2, 2, true, true);
		zooObj.addZone(zoneObj1);
		Cage cageObj1 = new Cage(11, Type.Lion, 2, 2);
		zooObj.addCage(cageObj1);

		Cage cageObj2 = new Cage(11, Type.Lion, 2, 2);
		zooObj.addCage(cageObj2);
	}

	@Test(expected = AssertionError.class)
	public void addCageErrorZoneAbsent() {
		Cage cageObj1 = new Cage(11, Type.Lion, 2, 2);
		zooObj.addCage(cageObj1);
	}

	@Test(expected = AssertionError.class)
	public void addCageErrorInsufficientSpace() {

		Zone zoneObj1 = new Zone(1, Category.Mammal, 2, 2, true, true);
		zooObj.addZone(zoneObj1);
		Cage cageObj1 = new Cage(11, Type.Lion, 2, 2);
		zooObj.addCage(cageObj1);
		Cage cageObj2 = new Cage(12, Type.Horse, 2, 2);
		zooObj.addCage(cageObj2);

		Cage cageObj3 = new Cage(13, Type.Lion, 2, 2);
		zooObj.addCage(cageObj3);
	}

	@Test
	public void addAnimalPositive() {

		Zone zoneObj1 = new Zone(1, Category.Mammal, 2, 2, true, true);
		zooObj.addZone(zoneObj1);
		Cage cageObj1 = new Cage(11, Type.Lion, 2, 2);
		zooObj.addCage(cageObj1);

		Lion lionObj = new Lion("blackLion", 150.00, 89, true, Type.Lion, 11);
		zooObj.addAnimal(lionObj);
	}

	@Test(expected = AssertionError.class)
	public void addAnimalDuplicateName() {

		Zone zoneObj1 = new Zone(1, Category.Mammal, 2, 2, true, true);
		zooObj.addZone(zoneObj1);
		Cage cageObj1 = new Cage(11, Type.Lion, 2, 2);
		zooObj.addCage(cageObj1);

		Lion lionObj1 = new Lion("blackLion", 150.00, 89, true, Type.Lion, 11);
		zooObj.addAnimal(lionObj1);

		Lion lionObj2 = new Lion("blackLion", 150.00, 89, true, Type.Lion, 11);
		zooObj.addAnimal(lionObj2);
	}

	@Test(expected = AssertionError.class)
	public void addAnimalNoSpaceFound() {

		Zone zoneObj1 = new Zone(1, Category.Mammal, 2, 2, true, true);
		zooObj.addZone(zoneObj1);
		Cage cageObj1 = new Cage(11, Type.Lion, 2, 2);
		zooObj.addCage(cageObj1);

		Lion lionObj1 = new Lion("blackLion", 150.00, 89, true, Type.Lion, 11);
		zooObj.addAnimal(lionObj1);

		Lion lionObj2 = new Lion("whiteLion", 150.00, 89, true, Type.Lion, 11);
		zooObj.addAnimal(lionObj2);

		Lion lionObj3 = new Lion("whiteLion", 150.00, 89, true, Type.Lion, 11);
		zooObj.addAnimal(lionObj3);
	}

	@Test(expected = AssertionError.class)
	public void addAnimalDifferntType() {

		Zone zoneObj1 = new Zone(1, Category.Mammal, 2, 2, true, true);
		zooObj.addZone(zoneObj1);
		Cage cageObj1 = new Cage(11, Type.Lion, 2, 2);
		zooObj.addCage(cageObj1);

		Lion lionObj1 = new Lion("blackLion", 150.00, 89, true, Type.Lion, 11);
		zooObj.addAnimal(lionObj1);

		Lion lionObj2 = new Lion("greenpeacock", 150.00, 89, true, Type.Peacock, 11);
		zooObj.addAnimal(lionObj2);
	}
	
	@Test(expected = AssertionError.class)
	public void addAnimalWithBlankName() {
		Zone zoneObj1 = new Zone(1, Category.Mammal, 2, 2, true, true);
		zooObj.addZone(zoneObj1);
		Cage cageObj1 = new Cage(11, Type.Lion, 2, 2);
		zooObj.addCage(cageObj1);

		Lion lionObj = new Lion(" ", 150.00, 89, true, Type.Lion, 11);
		zooObj.addAnimal(lionObj);
	}


	@Test
	public void removeAnimalPositive() {
		Zone zoneObj1 = new Zone(1, Category.Mammal, 2, 2, true, true);
		zooObj.addZone(zoneObj1);
		Cage cageObj1 = new Cage(11, Type.Lion, 2, 2);
		zooObj.addCage(cageObj1);

		Lion lionObj = new Lion("blackLion", 150.00, 89, true, Type.Lion, 11);
		zooObj.addAnimal(lionObj);

		zooObj.removeAnimal("blackLion");
	}

	@Test(expected = AssertionError.class)
	public void removeAnimalNoAnimalToRemove() {
		Zone zoneObj1 = new Zone(1, Category.Mammal, 2, 2, true, true);
		zooObj.addZone(zoneObj1);
		Cage cageObj1 = new Cage(11, Type.Lion, 2, 2);
		zooObj.addCage(cageObj1);

		Lion lionObj = new Lion("blackLion", 150.00, 89, true, Type.Lion, 11);
		zooObj.addAnimal(lionObj);

		zooObj.removeAnimal("blah");
	}	

}
