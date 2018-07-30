import java.util.ArrayList;

public class Zoo {

	Zone zoneObj = new Zone();
	ArrayList<Zone> zoneList = new ArrayList<>();

	//Checks space in zoneList
	boolean haveSpace(int index) {
		return zoneList.get(index).getSpareCap() != 0;
	}

	//Returns index by taking cage ID as parameter
	//Also checks if zone have space
	int getIndexById(int cageId) {

		for (int i = 0; i < zoneList.size(); i++) {
			int zoneId = zoneList.get(i).getZoneId();
			if (cageId / 10 == zoneId && haveSpace(i)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Add a zone to zoneList
	 * @param zoneObj, object of Zone type
	 */
	public void addZone(Zone zoneObj) {

		if (isDuplicateZoneId(zoneObj.zoneId)) {
			throw new AssertionError("same zone id exists.");//throwing error if duplicate zone id is found
		}

		zoneList.add(zoneObj);//otherwise adding
	}

	//checks if there is duplicate zone id in the zone list
	private boolean isDuplicateZoneId(int zoneId) {
		for (int i = 0; i < zoneList.size(); i++) {
			int zoneIdInList = zoneList.get(i).getZoneId();
			if (zoneId == zoneIdInList) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Add a cage to zone by calling method addCage from zone class
	 * Zoo.addCage --> Zone.addCage
	 * Decreasing Spare Capacity
	 * @param cageObj, of Cage type
	 */
	public void addCage(Cage cageObj) {

		if (isDuplicateCageId(cageObj.cageId)) {
			throw new AssertionError("entered Id already exists.");//throws error at duplicate cage ID
		}

		int indexOfZoneType = getIndexById(cageObj.cageId);//Storing compatible zone index
		if (indexOfZoneType == -1) {
			throw new AssertionError("No zone is present for the following type or no space in any zone.");//throws error when no zone is compatible for the cage
		}
		zoneObj.addCage(cageObj);//Invoking method of zone
		
		int spareCap = zoneList.get(indexOfZoneType).getSpareCap();
		zoneList.get(indexOfZoneType).setSpareCap(spareCap - 1);//Setting spare capacity to 1 less.
	}
	
	//checks if a cage with same duplicate id is present.
	private boolean isDuplicateCageId(int cageId) {
		return zoneObj.isDuplicateCageId(cageId);
	}
	
	/**
	 * Add an animal to the cage
	 * Zoo.addAnimal --> Zone.addAnimal --> Cage.addAnimal
	 * @param animalObj, of Animal Type
	 */
	void addAnimal(Animal animalObj) {
		String animalName = animalObj.name;
		if (isDuplicateName(animalName)) {
			throw new AssertionError("Name already exists");//throw error if same name animal is present.
		}

		if (animalName == "" || animalName.charAt(0) == ' ') {
			throw new AssertionError("Name cannot be blank");//throw error if a name is initiated with blank or is blank
		}

		for (int i = 0; i < zoneList.size(); i++) {
			Category zoneCategory = zoneList.get(i).getCategory();
			if (zoneCategory == animalObj.category && haveSpace(i)) {//checks category and space in the zone list
				zoneObj.addAnimal(animalObj);
				return;
			}
		}
	}
	
	/**
	 * Removes animal at its death
	 * Zoo.removeAnimal --> Zone.removeAnimal --> Cage.removeAnimal
	 * @param name, unique name of animal
	 */
	void removeAnimal(String name) {

		if (!isDuplicateName(name)) {//checking if name exists in the list, if not, then there will be nothing to remove
			throw new AssertionError("No such animal to remove");
		}
		zoneObj.removeAnimal(name);//removing animal

	}

	//serves 2 purpose
	// while adding an animal, unique name should be checked 
	// while removing an animal, presence of that animal should be checked
	//Zone.isDuplicate --> Zone.isDuplicate --> Cage.isDuplicate
	private boolean isDuplicateName(String name) {
		return zoneObj.isDuplicateName(name);
	}

	
}
