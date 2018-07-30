import java.util.ArrayList;

public class Cage {
	int cageId;
	Type type;
	int maximumCapacityOfCage;
	int spareCapacityOfCage;

	ArrayList<Animal> animalList = new ArrayList<>();

	Cage() {
	}

	Cage(int cageId, Type type, int maximumCapacityOfCage, int spareCapacityOfCage) {
		this.cageId = cageId;
		this.type = type;
		this.maximumCapacityOfCage = maximumCapacityOfCage;
		this.spareCapacityOfCage = spareCapacityOfCage;
	}

	int getCageId() {
		return this.cageId;
	}

	Type getType() {
		return this.type;
	}

	int getSpareCap() {
		return this.spareCapacityOfCage;
	}

	void setSpareCap(int spareCapacityOfCage) {
		this.spareCapacityOfCage = spareCapacityOfCage;
	}

	//returns index for the name form animal list
	int getIndexByName(String name) {
		String nameByIndex;
		for (int i = 0; i < animalList.size(); i++) {
			nameByIndex = animalList.get(i).getName();
			type = animalList.get(i).getType();
			if (nameByIndex == name) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Adds an animal to the animal List
	 * @param animalObj
	 */
	public void addAnimal(Animal animalObj) {
		animalList.add(animalObj);
	}

	//checks duplicate name in animal list returns to zone and zone returns to zoo
	boolean isDuplicateName(String name) {
		for (int i = 0; i < animalList.size(); i++) {
			String nameInList = animalList.get(i).getName();
			if (name == nameInList) {
				return true;
			}
		}
		return false;
	}

}
