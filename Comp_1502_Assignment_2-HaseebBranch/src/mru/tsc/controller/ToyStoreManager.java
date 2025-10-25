package mru.tsc.controller;

import java.util.ArrayList;

import mru.tsc.model.Toy;

public class ToyStoreManager {

	

	
	/**
	 * This method compares the given serial number to all serial number in the database and returns a matching serial number
	 * 
	 * @param serialNumber the serial number given by the user
	 * @return the toy object
	 */
	private Toy compareSNToListDb(String serialNumber) {
		String currentSN;
		
		for (Toy toy : toyList) { // read each object in list, then do a getSN to get the serial number
			currentSN = toy.getSN;
			
			if (serialNumber == currentSN) return toy;  //compare SN to database SN, if true return that toy
			
			else {
				System.out.println("toy not found"); // PlaceHOLDER!!!!
				return null; 
			}
		}
		
	}
	
	/**
	 * This method compares the a given name to all names in the database and returns a list containing that all toys with that string sequence
	 * 
	 * @param name the name given by the user
	 * @return an arraylist that contains all toys with matching string sequence that was given by the user
	 */
	private ArrayList<Toy> compareNameToListName(String name) {
		ArrayList<Toy> toyNameList = new ArrayList<Toy>();
		
		String currentName;
		
		for (Toy toy : toyList) { // read each object in list, then do a getName the Name
			currentName = toy.getName;
			
			if (name == currentName) toyNameList.add(toy);  //compare Name to database Name, if true  add to a list to return
		}
		
		return toyNameList;
	}
	
	/**
	 * This method checks if a given type is the same as an object in the database and returns a list with all toys with the same type
	 * 
	 * @param type the object type name that the user provides
	 * @return a list of toys with the same object type
	 */
	private ArrayList<Toy> compareNameToListType (String type) { 
		ArrayList<Toy> toyTypeList = new ArrayList<Toy>();
		
		String currentType;
		
		for (Toy toy : toyList) { 									 		// read each object in list
			if (toy.getTypeString().equals(type)) toyTypeList.add(toy); 	 // if an object is a specific type then add to a list, then return that list
		}
		
		return toyTypeList;
	}

	
	
	
	
	
	
	
}
