package mru.tsc.model;

public class Figure extends Toy {

	private char classification;

	// Constructor that calls the superclass constructor to initialize inherited
	// fields

	public Figure(String serialNum, String name, String brand, double price, int count, int age, char classification) {
		super(name, serialNum, brand, price, count, age);
		this.classification = classification;
	}

	// Getter and setter for classification
	public char getClassification() {
		return classification;
	}

	public void setClassification(char classification) {
		this.classification = classification;

	}

	public String typeOf() {
		String type = "Figure";
		return type;
	}

	public String stringToFormat() {
		return super.stringToFormat() + ";" + classification;
	}
@Override
	public String toString() {
	    return "Classifcation " + classification;
	}
}
