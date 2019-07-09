
public class Animal {
	String name;
	double weight;
	int age;
	Category category;
	Type type;
	int associatedCageId;
	
	
	Cage cageObj = new Cage();

	
	Animal(String name, double weight, int age, Type type, int associatedCageId,Category category){
		this.name = name;
		this.weight = weight;
		this.age = age;
		this.type = type;
		this.associatedCageId = associatedCageId;
		this.category = category;
	}
	
	double getWeight() {
		return this.weight;
	}
	
	int getAge() {
		return this.age;
	}
	
	Type getType() {
		return this.type;
	}
	
	String getName() {
		return this.name;
	}
	
	int getAssociatedCageId() {
		return this.associatedCageId;
	}

}

abstract class Mammal extends Animal{
	
	boolean isWild;
	Category category = Category.Mammal;
	
	abstract String getSound();
	
	Mammal(String name, double weight, int age, boolean isWild, Type type, int associatedCageId, Category category){
		super(name,weight,age,type,associatedCageId,category);
		this.isWild = isWild;
	}

}

abstract class Bird extends Animal{

	int flyingHeight;
	Category category = Category.Bird;
	
	abstract String getSound();
	
	Bird(String name, double weight, int age, int flyingHeight, Type type, int associatedCageId, Category category){
		super(name,weight,age,type, associatedCageId,category);
		this.flyingHeight = flyingHeight;
	}
}

abstract class Reptile extends Animal{
	
	boolean isPoisonous;
	Category category = Category.Reptile;
	
	abstract String getSound();
	
	Reptile(String name, double weight, int age, boolean isPoisonous, Type type, int associatedCageId, Category category){
		super(name,weight,age, type, associatedCageId,category);
		this.isPoisonous = isPoisonous;
	}
}

class Lion extends Mammal{
	
	static Category category = Category.Mammal;
	Lion(String name, double weight, int age, boolean isWild, Type type, int associatedCageId){
		super(name,weight,age,isWild,type,associatedCageId,category);
	}

	String getSound() {
		return "roar";
	}
}

class Horse extends Mammal{
	
	static Category category = Category.Mammal;
	Horse(String name, double weight, int age, boolean isWild, Type type, int associatedCageId){
		super(name,weight,age,isWild,type,associatedCageId,category);
	}

	String getSound() {
		return "neigh";
	}
}

class Peacock extends Bird{
	
	static Category category = Category.Bird;
	Peacock(String name, double weight, int age, int flyingHeight, Type type, int associatedCageId){
		super(name,weight,age,flyingHeight,type, associatedCageId,category);
	}

	String getSound() {
		return "scream";
	}
}

class Pigeon extends Bird{
	
	static Category category = Category.Bird;
	Pigeon(String name, double weight, int age, int flyingHeight, Type type, int associatedCageId){
		super(name,weight,age,flyingHeight,type, associatedCageId,category);
	}
	
	String getSound() {
		return "cooo";
	}
}

class Crocodile extends Reptile{
	
	static Category category = Category.Reptile;
	Crocodile(String name, double weight, int age, boolean isPoisonous, Type type, int associatedCageId){
		super(name,weight,age, isPoisonous, type, associatedCageId,category);
	}
		
	String getSound() {
		return "growl";
	}
}

class Snake extends Reptile{
	
	static Category category = Category.Reptile;
	Snake(String name, double weight, int age, boolean isPoisonous, Type type, int associatedCageId){
		super(name,weight,age, isPoisonous, type, associatedCageId,category);
	}

	String getSound() {
		return "hiss";
	}
}