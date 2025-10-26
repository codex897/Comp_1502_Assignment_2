package mru.tsc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.model.Toy;

public class ToyStoreManager {

	ArrayList<Toy> toyList;
	Scanner input;
	private void addToy() { //WIP 
//		input = new Scanner(System.in);
		
		ArrayList<Toy> sameSNList;
		
		String toyName;
		String toyBrand;
		double toyPrice;
		int count;
		int age;
		
		
		System.out.println("enter SN: "); //temporary placeholder
		sameSNList = compareSNToAllToys(null); //a list containing an item with the same serial number
		
		if (sameSNList.isEmpty()) System.out.println("SN must be unique!!"); //placeholder to call menu class
		
		/*
		 * 
		 * will use alex's method to add
		 * 
		 */
		
		
	}
	
	
	private void removeToy() {
		int indexInDataBase ;
		ArrayList<Toy> sameSNList;
		
		while (true){
			System.out.println("enter SN: ");//placeholder to call menu class for display and input
				//validating a valid Serial number method goes here
			
			sameSNList = compareSNToAllToys(null); //a list containing an item with the same serial number
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
	 * @return the toy object that the user selected
	 */
	private Toy selectValidation (ArrayList<Toy> searchedList, String userInput) {
		int maxSearchedListSize;
		maxSearchedListSize = searchedList.size(); //WIP
		
		
		
		
	}
	
	/**
	 * This method decrements the item that the user wants to purchase if there is at least one count of that object
	 * 
	 * @param toy the toy that the user chooses to buy
	 */
	private void purchase(Toy toy) {
		if (toy.getCount() > 0) {
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
			
			if (serialNumber == currentSN) toySNList.add(toy);  //compare SN to database SN, if true  add to a list to return
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
