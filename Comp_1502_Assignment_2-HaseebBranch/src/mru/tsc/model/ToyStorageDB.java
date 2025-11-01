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

				if (splittedLine[0].charAt(0) == '1' || splittedLine[0].charAt(0) == '0') {
					String serialNum = splittedLine[0];
					currentToy = new Figure(serialNum, splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6].charAt(0));
					toydb.add(currentToy); // Add figure object directly

				} else if (splittedLine[0].charAt(0) == '2' || splittedLine[0].charAt(0) == '3') {
					String serialNum = splittedLine[0];
					currentToy = new Animal(serialNum, splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7].charAt(0));
					toydb.add(currentToy); // Add animal object directly

				} else if (splittedLine[0].charAt(0) == '4' || splittedLine[0].charAt(0) == '5'
						|| splittedLine[0].charAt(0) == '6') {
					String serialNum = splittedLine[0];
					currentToy = new Puzzle(serialNum, splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6].charAt(0));
					toydb.add(currentToy); // Add puzzle object directly

				} else if (splittedLine[0].charAt(0) == '7' || splittedLine[0].charAt(0) == '8'
						|| splittedLine[0].charAt(0) == '9') {
					String[] minMaxPlayers = splittedLine[6].split("-");
					String serialNum = splittedLine[0];

					currentToy = new BoardGame(serialNum, splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), Integer.parseInt(minMaxPlayers[0]),
							Integer.parseInt(minMaxPlayers[1]), splittedLine[7]);
					toydb.add(currentToy); // Add board game object directly
				}
			}
			fileReader.close(); // Close the file reader
		}
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

}

