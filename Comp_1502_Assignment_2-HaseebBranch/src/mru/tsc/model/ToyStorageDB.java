package mru.tsc.model;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ToyStorageDB {

	ArrayList<Toy> toydb;
	private String FILE_PATH;

	public ToyStorageDB(String FILE_PATH) throws Exception {

		toydb = new ArrayList<>(); // Ensure toydb is initialized
		this.FILE_PATH = FILE_PATH;

	}
	/*
	 * Your project must have the following features and specifications: Your
	 * program should read all the toys into a **single** ArrayList on startup, and
	 * save the (potentially modified) list of toys back to the file on exit.
	 */

	public void addData() throws Exception {
		File toyfile = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;

		if (toyfile.exists()) { // Checking if the file exists
			Scanner fileReader = new Scanner(toyfile); // Create scanner for the file

			while (fileReader.hasNextLine()) { // Loop through the file lines
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";"); // Split the line at semi-colons

				Toy currentToy; // Change type to Toy
				String toyType = getToyType(splittedLine[0]);
				
				if(toyType.equals("Figure")) { //takes in the serial number and checks for specific type of toy
					createFigure(splittedLine);
				}
				
				else if(toyType.equals("Animal") ){ //takes in the serial number and checks for specific type
					createAnimal(splittedLine);
				}
				
				else if(toyType.equals("Puzzle") ){ //takes in the serial number and checks for specific type
					createPuzzle(splittedLine);
				}
				
				else if(toyType.equals("BoardGame") ){ //takes in the serial number and checks for specific type
					createBoardGame(splittedLine);
				}
				
			}
			
			fileReader.close(); // Close the file reader
		}
	}
	
	/*
	 * create[Toy_TYPE] can be used for the file and user input
	 */
	public void createFigure(String[] data) {
	    String serialNum = data[0];
	    String name = data[1];
	    String brand = data[2];
	    double price = Double.parseDouble(data[3]);
	    int count = Integer.parseInt(data[4]);
	    int age = Integer.parseInt(data[5]);
	    char classification = data[6].charAt(0);

	    toydb.add(new Figure(serialNum, name, brand, price, count, age, classification));
	}
	public void createAnimal(String[] data) {
	    String serialNum = data[0];
	    String name = data[1];
	    String brand = data[2];
	    double price = Double.parseDouble(data[3]);
	    int count = Integer.parseInt(data[4]);
	    int age = Integer.parseInt(data[5]);
	    String material = data[6];
	    char size = data[7].charAt(0);

	    toydb.add(new Animal(serialNum, name, brand, price, count, age, material, size));
	}
	
	public void createPuzzle(String[] data) {
	    String serialNum = data[0];
	    String name = data[1];
	    String brand = data[2];
	    double price = Double.parseDouble(data[3]);
	    int count = Integer.parseInt(data[4]);
	    int age = Integer.parseInt(data[5]);
	    char puzzleType = data[6].charAt(0);

	    toydb.add( new Puzzle(serialNum, name, brand, price, count, age, puzzleType));
	}
	
	public void createBoardGame(String[] data) {
	    String serialNum = data[0];
	    String name = data[1];
	    String brand = data[2];
	    double price = Double.parseDouble(data[3]);
	    int count = Integer.parseInt(data[4]);
	    int age = Integer.parseInt(data[5]);
	    String[] minMaxPlayers = data[6].split("-");
	    int minPlayers = Integer.parseInt(minMaxPlayers[0]);
	    int maxPlayers = Integer.parseInt(minMaxPlayers[1]);
	    String designers = data[7];

	    toydb.add( new BoardGame(serialNum, name, brand, price, count, age, minPlayers, maxPlayers, designers));
	}



	/**
	 * This method returns the arralyList containing all the data from the file
	 * 
	 * @return the arraylist containing the toy data from the file
	 */
	public ArrayList<Toy> getToyDB() {
		
		return toydb;
	}

	/**
	 * This method compares the given serial number to all serial number in the database and returns a matching serial number
	 * 
	 * @param serialNumber the serial number given by the user
	 * @return the toy object
	 */
	public ArrayList<Toy> compareSNToAllToys(String serialNumber) {
		ArrayList<Toy> toySNList = new ArrayList<Toy>();
		String currentSN;
		
		for (Toy toy : toydb) { // read each object in list, then do a getSN to get the serial number
			currentSN = toy.getSerialNum();
			
			if (serialNumber.equals(currentSN)) toySNList.add(toy);  //compare SN to database SN, if true  add to a list to return
		}
		
		return toySNList;
		
	}

	/**
	 * This method compares the a given name to all names in the database and returns a list containing that all toys with that string sequence
	 * 
	 * @param name the name given by the user
	 * @return an arraylist that contains all toys with matching string sequence that was given by the user
	 */
	public ArrayList<Toy> compareNameToAllToys(String name) {
		ArrayList<Toy> toyNameList = new ArrayList<Toy>();
		
		String currentName;
		
		for (Toy toy : toydb) { // read each object in list, then do a getName the Name
			currentName = toy.getName();
			
			if (currentName.contains(name)) toyNameList.add(toy);  //compare Name to database Name, if true  add to a list to return
		}
		
		return toyNameList;
	}

	
	/**
	 * This method checks if a given type is the same as an object in the database and returns a list with all toys with the same type
	 * 
	 * @param type the object type name that the user provides
	 * @return a list of toys with the same object type
	 */
	public ArrayList<Toy> compareTypeToAllToys (String type) { 
		ArrayList<Toy> toyTypeList = new ArrayList<Toy>();
		
		String currentType;
		
		for (Toy toy : toydb) { 									 		// read each object in list
			if (toy.typeOf().equals(type)) toyTypeList.add(toy); 	 // if an object is a specific type then add to a list, then return that list
		}
		
		return toyTypeList;
	}

	public void removeData(Toy toy) throws Exception {
		toydb.remove(toy);

	}
	//this class that uses the a built in method subtracts  

	public void add(Toy toy) {

		toydb.add(toy);

	}
	
	public String toString() {
		StringBuilder formattedData = new StringBuilder();

		// Iterate through each toy and add its formatted string representation to
		// StringBuilder
		for (Toy toy : toydb) {

			formattedData.append(toy.stringToFormat()).append("\n");
		}

		return formattedData.toString();
	}

	public Object findToySerialnum(String serialNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getToyType(String serialNum) {
	    if (serialNum == null || serialNum.isEmpty()) {
	        return "error";
	    }

	    char firstChar = serialNum.charAt(0);

	    if (firstChar == '0' || firstChar == '1')
	        return "Figure";
	    else if (firstChar == '2' || firstChar == '3')
	        return "Animal";
	    else if (firstChar == '4' || firstChar == '5' || firstChar == '6')
	        return "Puzzle";
	    else if (firstChar == '7' || firstChar == '8' || firstChar == '9')
	        return "BoardGame";
	    else
	        return "error";
	}


	
	
	
	
	

}

