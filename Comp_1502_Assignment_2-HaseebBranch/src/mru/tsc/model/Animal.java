package mru.tsc.model;

public class Animal extends Toy {

	private char size;
	private String material;

	/*
	 * these are constructors for all the required fields that are requested in the
	 * assignment.
	 */

	// Constructor that calls the superclass constructor to initialize inherited
	// fields

	public Animal(String serialNum, String name, String brand, double price, int count, int age, String material,
			char size) {
		super(name, serialNum, brand, price, count, age);
		this.size = size;
		this.material = material;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public String typeOf() {
		String type = "Animal";
		return type;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String stringToFormat() {
		return super.stringToFormat() + ";" + material + ";" + size;
	}
//	@Override
//	public String toString() {
//	    return "Type: " + type ;
//	}
}

	


