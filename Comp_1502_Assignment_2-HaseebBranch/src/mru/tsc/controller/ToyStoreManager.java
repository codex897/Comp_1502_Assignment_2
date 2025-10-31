package mru.tsc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.model.Toy;

public class ToyStoreManager {

	ArrayList<Toy> toyList;
	Scanner input;
	
	/**
	 * This constructor initializes..........
	 */
	public ToyStoreManager() {
		this.input = new Scanner(System.in);
	}
	
	/**
	 * This method adds a toy in the database
	 * 
	 * It first asks the user to enter a serial number
	 * that serial number is validated and matched with the matching toy type
	 * then promts the user to enter the specific toy data related to the type
	 * finally, it calls a method from the ToyStorageDB class that gives all the type information into that method that adds it to the database
	 * 
	 */
	private void addToy() { //WIP 
		
		ArrayList<Toy> sameSNList;
		String userSerialNumber; // can be changed to int later if needed
		
		String toyName;
		String toyBrand;
		double toyPrice;
		int count;
		int age;
		
		while(true) { // should add try catch
		System.out.println("enter SN: "); //temporary placeholder
		userSerialNumber = input.nextLine(); //temporary must validate SN
		
		sameSNList = compareSNToAllToys(userSerialNumber); //a list containing an item with the same serial number
		
		
			if (!sameSNList.isEmpty()) System.out.println("SN must be unique!!"); //placeholder to call menu class should throw error
			else break;
		}
		
		
		/*
		 * 
		 * will use alex's method to add
		 * 
		 */
		

		
		
	}
	
	/**
	 * this method removes a toy from the database
	 * 
	 * It first asks for a serial number then validates if that serial number matcher with any serial number in the database.
	 * The index of the matching toy with the same serial number is then located in the database and removes that object in that index
	 */
	private void removeToy() {
		int indexInDataBase ;
		String userSerialNumber; // can be changed to int later if needed
		ArrayList<Toy> sameSNList;
		
		while (true){
			System.out.println("enter SN: ");//placeholder to call menu class for display and input
			userSerialNumber = input.nextLine();
				/*
				 * 
				 * validating a valid Serial number method goes here
				 * 
				 */
			
			sameSNList = compareSNToAllToys(userSerialNumber); //a list containing an item with the same serial number // null is placeholder for userinput for SN
			if (sameSNList.isEmpty()) System.out.println("Toy not found!"); //placeholder to call menu class
			
			else break;
		}

		sameSNList.get(0).toString(); //print the description of the toy
		System.out.println("do you want to remove y/n?: "); //placeholder to call menu class
		indexInDataBase = toyList.indexOf(sameSNList.get(0)); //get the object in the sameSNList and get the index for that object within the DataBase
		toyList.remove(indexInDataBase);
		
		System.out.println("object removed!"); //placeholder to call menu class
		System.out.println("press enter to continue"); //placeholder to call menu class
	}
	
	/**
	 * validates the user input when selecting an item to purchase
	 * 
	 * The amount of items displayed is the maximum number that the user can enter
	 * and cannot enter a number that is bigger or less than the maximum number displayed
	 * 
	 * @param searchedList the list of toys that shows when searching up an item
	 * @param userSelectionInput
	 * @return the toy object that the user selected
	 */
	private Toy selectValidation (ArrayList<Toy> searchedList, int userSelectionInput) {
		int maxSearchedListSize;
		
		maxSearchedListSize = searchedList.size(); //WIP
		
		if (userSelectionInput > maxSearchedListSize || userSelectionInput <0) { //try catch error exception
			//throw new exception
		}
		else {
			
		}
		
		
		
		
	}
	
	/**
	 * This method decrements the item that the user wants to purchase if there is at least one count of that object
	 * 
	 * @param toy the toy that the user chooses to buy
	 */
	private void purchase(Toy toy) {
		if (toy.getCount() > 0) { //probably need try catch error exception
			toy.decrement(); //if theres at least one toy available and the user wants to purchase then remove one count from the DB
			System.out.println("Succesfully Purchased"); //temporary placeholder to call menu class
		}
		else System.out.println("Error: out of stock"); //temporary placeholder to call menu class
	}
	
	
	/**
	 * This method displays the list of toys that matches the users search by calling the menu class to print
	 * 
	 * @param searchedList the list containing the toys in the database as an ArrayList Class
	 */
	private void displayToyList(ArrayList<Toy> searchedList) {

		int count = 0;
		for (Toy toy : searchedList) {
			count ++;
			//There should be a menu call here that takes in count
			System.out.println(toy.toString()); // TEMPORARY PLACEHOLDER TO CALL MENU CLASS
			
		}
	}
	
	/**
	 * This method displays a single of toys that matches the users search by calling the menu class to print
	 * 
	 * @param singleToy A single toy that will be displayed as a Toy class
	 */
	private void displayToy(Toy singleToy) {
		System.out.println(singleToy.toString()); // TEMPORARY PLACEHOLDER TO CALL MENU CLASS
		
	}
	
	/**
	 * This method compares the given serial number to all serial number in the database and returns a matching serial number
	 * 
	 * @param serialNumber the serial number given by the user
	 * @return the toy object
	 */
	private ArrayList<Toy> compareSNToAllToys(String serialNumber) {
		ArrayList<Toy> toySNList = new ArrayList<Toy>();
		String currentSN;
		
		for (Toy toy : toyList) { // read each object in list, then do a getSN to get the serial number
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
	private ArrayList<Toy> compareNameToAllToys(String name) {
		ArrayList<Toy> toyNameList = new ArrayList<Toy>();
		
		String currentName;
		
		for (Toy toy : toyList) { // read each object in list, then do a getName the Name
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
	private ArrayList<Toy> compareTypeToAllToys (String type) { 
		ArrayList<Toy> toyTypeList = new ArrayList<Toy>();
		
		String currentType;
		
		for (Toy toy : toyList) { 									 		// read each object in list
			if (toy.typeOf().equals(type)) toyTypeList.add(toy); 	 // if an object is a specific type then add to a list, then return that list
		}
		
		return toyTypeList;
	}

	
	
	
	
	
	
	
}
