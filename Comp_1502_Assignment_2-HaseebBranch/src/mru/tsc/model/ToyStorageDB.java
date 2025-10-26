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

	public Toy findToySerialnum(String serialnum) {

		for (Toy toy : toydb) {
			if (toy.getSerialNum().equals(serialnum)) { // Assuming Toy has a getSerialNum() method
				// If a matching serial number is found, return it
				return toy;
			}
		}
		// If no matching serial number is found after searching through toydb, return
		// null
		return null;
	}

	public ArrayList<Toy> findToyName(String name) {
		ArrayList<Toy> foundToys = new ArrayList();
		for (Toy toy : toydb) {
			if (toy.getName().trim().toLowerCase().contains(name)) {
				// If a matching serial number is found, return it
				foundToys.add(toy);
			}
		}
		// If no matching serial number is found after searching through toydb, return
		// null
		if (foundToys.size() == 0) {
			return null;
		} else {
			return foundToys;
		}
	}

	public void removeData(Toy toy) throws Exception {
		toydb.remove(toy);

	}
	//this class that uses the a built in method subtracts  

	public void add(Toy toy) {

		toydb.add(toy);

	}
	//this class that uses the a built in method add 

	public ArrayList<Toy> findByType(String typeToSearchFor) {
		ArrayList<Toy> results = new ArrayList<>();
		for (Toy toy : toydb) {
			if (toy.typeOf().equals(typeToSearchFor)) {

			}

		}

		return results;
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

}

