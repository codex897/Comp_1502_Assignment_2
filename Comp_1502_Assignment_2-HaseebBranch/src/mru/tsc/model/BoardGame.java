package mru.tsc.model;

public class BoardGame extends Toy {
	private String designers;
	private int minPlayers;
	private int maxPlayers;

	// Constructor that calls the superclass constructor to initialize inherited
	// fields
	public BoardGame(String serialNum, String name, String brand, double price, int count, int age, int minPlayers,
			int maxPlayers, String designers) {
		super(name, serialNum, brand, price, count, age);
		this.designers = designers;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
	}

	public String typeOf() {
		String type = "BoardGames";
		return type;
	}

	public String getDesigners() {
		return designers;
	}

	public void setDesigners(String designers) {
		this.designers = designers;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public String stringToFormat() {
		return super.stringToFormat() + ";" + minPlayers + "-" + maxPlayers + ";" + designers;
	}
	
	@Override
	public String toString() {
	    return ", Minimum players: " + minPlayers + ", Maximum players: " + maxPlayers + "designers: ";
	}


}

