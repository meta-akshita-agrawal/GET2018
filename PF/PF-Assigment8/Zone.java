import java.util.ArrayList;

public class Zone {
	int zoneId;
	Category category;
	int maximumCapacityOfZone;
	int spareCapacityOfZone;
	boolean hasPark;
	boolean hasCanteen;

	Cage cageObj = new Cage();

	ArrayList<Cage> cageList = new ArrayList<>();

	Zone() {
	}

	Zone(int zoneId, Category category, int maximumCapacityOfZone, int spareCapacityOfZone, boolean hasPark,
			boolean hasCanteen) {
		this.zoneId = zoneId;
		this.category = category;
		this.maximumCapacityOfZone = maximumCapacityOfZone;
		this.spareCapacityOfZone = spareCapacityOfZone;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
	}

	int getZoneId() {
		return this.zoneId;
	}

	Category getCategory() {
		return this.category;
	}

	int getSpareCap() {
		return this.spareCapacityOfZone;
	}

	void setSpareCap(int spareCapacityOfZone) {
		this.spareCapacityOfZone = spareCapacityOfZone;
	}

	boolean haveSpace(int index) {
		return cageList.get(index).getSpareCap() != 0;
	}

	/**
	 * Adding Cage to the cageList
	 * Note that compatibility is already checked in the previous hierarchy
	 * @param cageObj, of Cage type
	 */
	public void addCage(Cage cageObj) {
		cageList.add(
				new Cage(cageObj.cageId, cageObj.type, cageObj.maximumCapacityOfCage, cageObj.maximumCapacityOfCage));
	}
	
	//Checks if Cage ID is already present
	boolean isDuplicateCageId(int cageId) {
		for (int i = 0; i < cageList.size(); i++) {
			int cageIdInList = cageList.get(i).getCageId();
			if (cageIdInList == cageId) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds an animal to the animalList
	 * Zone.addAnimal --> Cage.addAnimal
	 * @param animalObj, of Animal Type
	 */
	void addAnimal(Animal animalObj) {
		for (int i = 0; i < cageList.size(); i++) {
			Type cageType = cageList.get(i).getType();
			if (cageType == animalObj.type && haveSpace(i)) {//Checking compatibility
				cageObj.addAnimal(animalObj);
				int spareCap = cageList.get(i).getSpareCap();
				cageList.get(i).setSpareCap(spareCap - 1);//Setting spare capacity
				return;
			}
		}
		throw new AssertionError("No Compatible cage");//if none is found error is thrown
	}

	/**
	 * Removes an animal from the zoo
	 * Zone.removeAnimal --> Cage.removeAnimal
	 * @param name
	 */
	void removeAnimal(String name) {
		int index = cageObj.getIndexByName(name);

		cageObj.animalList.remove(index);
		int spareCap = cageList.get(index).getSpareCap();
		cageList.get(index).setSpareCap(spareCap - 1);

	}
	//Zone.isDuplicate --> Cage.isDuplicate
	boolean isDuplicateName(String name) {
		return cageObj.isDuplicateName(name);
	}

}
