package mru.tsc.model;


public class Puzzle extends Toy {

	
	private char type;

	
	public Puzzle(String serialNum, String name, String brand, double price, int count, int age, char type) {
		super(name, serialNum, brand, price, count, age);
		this.type = type;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String typeOf() {
		String type = "Puzzle";
		return type;
	}

	public String stringToFormat() {
		return super.stringToFormat() + ";" + type;
	}
	 
}

