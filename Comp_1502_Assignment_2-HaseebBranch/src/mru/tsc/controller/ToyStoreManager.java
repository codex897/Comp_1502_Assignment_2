package mru.tsc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.model.*;

public class ToyStoreManager {

	ArrayList<Toy> toyList;
	Scanner input;
	ToyStorageDB toyStorageDB; 
	
	final String FILE_PATH = "res/toys.txt" ;
	
	/**
	 * This constructor initializes..........
	 */
	public ToyStoreManager() {
		this.input = new Scanner(System.in);
		
		try {
			toyStorageDB =  new ToyStorageDB(FILE_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		toyList = ToyStorageDB.getToyDB;
	}
	
	/**
	 * This method promts and adds a toy in the database
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
		
		sameSNList = toyStorageDB.compareSNToAllToys(userSerialNumber); //a list containing an item with the same serial number
		
		
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
	 * this method promts and removes a toy from the database
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
			
			sameSNList = toyStorageDB.compareSNToAllToys(userSerialNumber); //a list containing an item with the same serial number // null is placeholder for userinput for SN
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
	 * This method promts the user to enter details to filter through the toy data base
	 * 
	 * It asks for age of the person recieving the gift, type of toy, and maximum and minimum price range of the toy
	 * at least one of the question must be answered for the filter to work
	 * A list of toys that was filtered is then displayed for the user to purchase
	 */
	private void giftSuggestion() { //WIPWIPWIPWIPWIP
		String ageString = null; // temporary string on these numbers ....maybe
		Integer age = null;
		String type = null;
		String minPriceString = null;
		Double minPrice = null;
		String maxPriceString = null;
		Double maxPrice = null;
		
		ArrayList<Toy> filteredList;
		
		while(true) {
			
			System.out.println("at least one field must be filled out"); //temporary
			
			System.out.println("for what age? | press [ENTER] to leave blank: ");
			ageString = input.nextLine();
			age = ageValidation(ageString);
			
			System.out.println("what type of toy? | press [ENTER] to leave blank: ");
			type = input.nextLine();
			
			while(true) { //keep runing until minprice is less than maxprice or left blank
				System.out.println("what price range? : ");
				System.out.println("minimum price range | press [ENTER] to leave blank: ");
				minPriceString = input.nextLine();
				minPrice = minPriceValidation(minPriceString);
				
				System.out.println("maximum price range | press [ENTER] to leave blank: ");
				maxPriceString = input.nextLine();
				maxPrice = maxPriceValidation(maxPriceString);
			
				if(minPrice> maxPrice) 
					System.out.println("error: minimum price cannot be more than the maximum price");
					
				else break;
			}
			
			
			if (ageString.isEmpty() && type.isEmpty() && minPriceString.isEmpty() && maxPriceString.isEmpty()) {
				System.out.println("ERROR: at least one field must be filled out");
			}
			else break;
		}


		
		filteredList = toyStorageDB.compareTypeToAllToys(type);
		filteredList = filterAge(filteredList, age); 
		filteredList = filterPrice(filteredList, minPrice, maxPrice); 
		
		displayToyList(filteredList);
	
	}
	
	//needs if list is empty then do something different
	//to add to toystoragedb maybe
	
	/**
	 * This method filters the toys by the price range that the user chooses
	 * 
	 * @param createdToyList createdToyList this is a list containing toys that have reacently been filtered, to further filter it
	 * @param minPrice the lowest price the person is willing to buy (should not be less than 0)
	 * @param maxPrice the highest price the person is willing to buy (should not be less than minPrice)
	 * @return a new list containing the filtered toys by price range
	 */
	private ArrayList<Toy> filterPrice(ArrayList<Toy> createdToyList, Double minPrice, Double maxPrice) {
		ArrayList<Toy> newToyList = new ArrayList<Toy>();

		for (Toy toy : createdToyList) {
			if(toy.getPrice()>= minPrice && toy.getPrice() <= maxPrice) newToyList.add(toy);
		}
		return newToyList;
	}
	
	//to add to toystoragedb maybe
	/**
	 * This method filters the toys by the minimum age requirement
	 * 
	 * if the age of a person given is older than the minum requirement of toys, then it will add to the newToyList
	 * If the age of a person is a max value integer, that means there is no limitation and all toys in a given list will be added to the newToyList
	 * 
	 * @param createdToyList this is a list containing toys that have reacently been filtered, to further filter it
	 * @param age the age of the person receiving the gift
	 * @return a new list containing the filtered toys that is allowed to be played by the given age of a person
	 */
	private ArrayList<Toy> filterAge(ArrayList<Toy> createdToyList, Integer age) {
		ArrayList<Toy> newToyList = new ArrayList<Toy>();
		
		
		for (Toy toy : createdToyList) {
			if(age >= toy.getAgeAllowed()) newToyList.add(toy) ; //if the age is more than the allowed age to play, add to the list
		}
		return newToyList;
	}
	
	/**
	 * This method handles the exception in case the argument given for the age of the person is an invalid Integer
	 * 
	 * if the argument given is less than or equals to 0, or it cannot be parsed, then it will return the maximum value an integer can be
	 * The max value is the default, meaning no filter will happen (no limitation).
	 * Else set the age to the argument given
	 * 
	 * @param ageString the user input for the age of the age of a person
	 * @return the argument or if invalid a max value of integer (default)
	 */
	private Integer ageValidation(String ageString){
		Integer age = Integer.MAX_VALUE;
		
		if(!ageString.equals("")) { //if its not empty then parse the to Integer, if it is empty return null
			try {
			  	age = Integer.parseInt(ageString); //return this value unless invalid return max to get all toys
			  	if (age <= 0) {
			  		System.out.println("invalid age, setting age field as default"); //empty means all there is not age limit
			  		age = Integer.MAX_VALUE;
			  	}

			} catch (Exception e) {
				// TODO: if it cant convert it set to 0
				System.out.println(e.getMessage() + " setting age field as empty"); //temporary
			
			}
		}

		return age;

	}
	
	/**
	 * This method handles the exception in case the argument given for minimum price of a toy is not a valid Double
	 * 
	 * If the argument given is a valid double that is a 0 or a positive integer, it will return that number.
	 * It will prompt a notice or an error and always returns a 0.0 in this case.
	 * 
	 * @param minPriceString the user input for the minimum price to filter. Can be left blank
	 * @return the minimum value for filtering price that the user chose or 0 if invalid input by user 
	 */
	private Double minPriceValidation(String minPriceString){
		Double minPrice = 0.0;
		
		if(!minPriceString.equals("")) { 
			try {
				minPrice = Double.parseDouble(minPriceString);
				if (minPrice < 0.0 ) {
					System.out.println("Cannot be negative number, seeting  field to default");
					minPrice = 0.0;
					//just set to zero if its a negative doesnt make a difference
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage() + " invalid minimum price, setting field as empty"); //temporary
			}
		}
		
		return minPrice;
	}
	
	/**
	 * This method handles the exception in case the argument given for a maximum price of a toy is not a valid Double
	 * 
	 * If the argument given is a valid double that is a 0 or a positive integer, it will return that number
	 * else it will prompt a notice or an error and always returns a max value (no limit).
	 * 
	 * @param maxPriceString the user input for the maximum price to filter. Can be left blank
	 * @return the maximum value a double can be if invalid or a value at or above 0 that the user chose if valid
	 */
	private Double maxPriceValidation(String maxPriceString){
		Double maxPrice = Double.MAX_VALUE;
		
		if(!maxPriceString.equals("")){
			try {
				maxPrice = Double.parseDouble(maxPriceString);
				if(maxPrice < 0.0) {
					System.out.println("maximum price range cannot be lower than 0, seting field to default");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage() + " setting field as empty"); //temporary
			
			}	
		}
		return maxPrice;
		
	}
	


	
	
	
	
}
