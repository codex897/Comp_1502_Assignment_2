package mru.tsc.view;

import java.util.Scanner;

import mru.tsc.model.Animal;
import mru.tsc.model.BoardGame;
import mru.tsc.model.Figure;
import mru.tsc.model.Puzzle;


public class Menu {

	static Scanner input;

	/**
	 * Constructs a new {@code Menu} object and initializes the Scanner.
	 */
	public Menu() {
		input = new Scanner(System.in);
	}

	/**
	 * Prompts the user to enter a toy name and validates that the input is not empty.
	 * 
	 * @return the validated toy name entered by the user
	 */
	public String askNameInput() {
	    System.out.print("Enter Toy Name: ");
	    String name = input.nextLine().trim();
	    while (name.isEmpty()) {
	        System.out.print("Invalid input: empty field");
	        tryAgain();
	        System.out.print("Enter Toy Name: ");
	        name = input.nextLine().trim();
	    }
	    return name;
	}

	/**
	 * Prompts the user to select a toy type and validates input.
	 * Accepts 'F' for figures, 'A' for animals, 'P' for puzzles, and 'B' for board games.
	 * 
	 * @return a string representing the toy type
	 */
	public String askTypeInput() {
	    System.out.print("Enter Toy Type || type [F] for figures, [A] for animal, [P] for puzzles, [B] for board-games: ");
	    while(true) {
	    	char type = input.nextLine().toLowerCase().charAt(0);
	    	if (type == 'f' || type == 'a' || type == 'p' || type == 'b') {
	    		return Character.toString(type);
	    	}
	    	else {
	    		System.out.print ("Invalid input: enter either [F], [A], [P], [B]");
	    		tryAgain();
	    	}
	    }
	}

	/**
	 * Prompts the user for a toy brand and ensures the input is not empty.
	 * 
	 * @return the validated toy brand name
	 */
	public String askBrandInput() {
	    System.out.print("Enter Toy Brand: ");
	    String brand = input.nextLine().trim();
	    while (brand.isEmpty()) {
	        System.out.print("Invalid input: empty field");
	        tryAgain();
	        System.out.print("Enter Toy Brand: ");
	        brand = input.nextLine().trim();
	    }
	    return brand;
	}

	/**
	 * Prompts the user to enter a toy price and ensures it is a valid non-negative number.
	 * 
	 * @return the validated toy price
	 */
	public double askPriceInput() {
	    System.out.print("Enter Toy Price: ");
	    while (true) {
	        try {
	            double price = input.nextDouble();
	            input.nextLine(); 
	            if (price >= 0) {
	                return price;
	            } 
	            else {
	                System.out.print("Invalid input: negative number");
	                tryAgain();
	            }
	        } catch (Exception e) {
	            System.out.print("Invalid input: Input must be a number");
	            tryAgain();
	            input.nextLine();
	        }
	        System.out.print("Enter Toy Price: ");
	    }
	}

	/**
	 * Prompts the user to enter the available count and validates it as a non-negative integer.
	 * 
	 * @return the validated available count
	 */
	public int askCountInput() {
	    System.out.print("Enter Available Count: ");
	    while (true) {
	        try {
	            int count = input.nextInt();
	            input.nextLine();
	            if (count >= 0) {
	                return count;
	            } 
	            else {
	                System.out.print("Invalid input: Count cannot be negative number");
	                tryAgain();
	            }
	        } catch (Exception e) {
	            System.out.print("Invalid input: Input must be a number");
	            tryAgain();
	            input.nextLine();
	        }
	        System.out.print("Enter Available Count: ");
	    }
	}

	/**
	 * Prompts the user to enter an appropriate age and validates it as non-negative.
	 * 
	 * @return the validated appropriate age
	 */
	public int askAgeInput() {
	    System.out.print("Enter Appropriate Age: ");
	    while (true) {
	        try {
	            int age = input.nextInt();
	            input.nextLine();
	            if (age >= 0) {
	                return age;
	            } 
	            else {
	                System.out.print("Invalid input: Age cannot be a negative number");
	                tryAgain();
	            }
	        } catch (Exception e) {
	            System.out.print("Invalid input: Input must be a number");
	            tryAgain();
	        }
	        System.out.print("Enter Appropriate Age: "); 
	    }
	}

	/**
	 * Prompts the user for a classification input specific to figures.
	 * Accepts 'A' for Action, 'D' for Doll, and 'H' for Historic.
	 * 
	 * @return the validated classification character
	 */
	public char askClassificationInput() {
	    System.out.print("Enter Appropriate classification || type [A] for action, [D] for Doll, [H] for historic: ");
	    while (true) {
	    	 char classification = input.nextLine().toLowerCase().charAt(0);
		    	if(classification == 'a' || classification == 'd' || classification == 'h' ) {
		    		return classification;
		    	}
		    	else {
		    		System.out.print("Invalid input: enter either [A], [D], [H]");
		    		tryAgain();
		    	}
	    }
	}

	/**
	 * Prompts the user for a toy material and ensures the field is not empty.
	 * 
	 * @return the validated material input
	 */
	public String askMaterialInput() {
	    System.out.print("Enter Toy Material: ");
	    String material = input.nextLine().trim();
	    while (material.isEmpty()) {
	        System.out.print("Invalid input: This field is empty");
	        tryAgain();
	        System.out.print("Enter Toy Material: ");
	        material = input.nextLine().trim();
	    }
	    return material;
	}

	/**
	 * Prompts the user to select a toy size: 'S' for Small, 'M' for Medium, 'L' for Large.
	 * 
	 * @return the validated size character
	 */
	public char askSizeInput() {
	    System.out.print("Enter Appropriate Size || type [S] for small, [M] for medium, [L] for large: ");
	    while(true) {
	    	char size = input.nextLine().toLowerCase().charAt(0);
	    	if (size == 's' || size == 'm' || size == 'l') {
	    		return size;
	    	}
	    	else {
	    		System.out.print ("Invalid input: enter either [S], [M], [L]");
	    		tryAgain();
	    	}
	    }
	}

	/**
	 * Prompts the user to enter the minimum number of players for a board game.
	 * 
	 * @return the validated minimum number of players
	 */
	public int askMinPlayersInput() {
	    System.out.print("Enter Minimum Number of Players: ");
	    while (true) {
	        try {
	            int minNum = input.nextInt();
	            input.nextLine();
	            if (minNum >= 1) {
	                return minNum;
	            } else {
	                System.out.print("Invalid input: Must have at least 1 player");
	                tryAgain();
	            }
	        } catch (Exception e) {
	            System.out.print("Invalid input: Input must be a number");
	            tryAgain();
	        }
	        System.out.print("Enter Minimum Number of Players: ");
	    }
	}

	/**
	 * Prompts the user to enter the maximum number of players for a board game.
	 * 
	 * @return the validated maximum number of players
	 */
	public int askMaxPlayersInput() {
	    System.out.print("Enter Maximum Number of Players: ");
	    while (true) {
	        try {
	            int maxNum = input.nextInt();
	            input.nextLine();
	            if (maxNum >= 1) {
	                return maxNum;
	            } else {
	                System.out.print("Invalid input: Must have at least 1 player!");
	                tryAgain();
	            }
	        } catch (Exception e) {
	            System.out.print("Invalid input: Input must be a number");
	            tryAgain();
	        }
	        System.out.print("Enter Maximum Number of Players: ");
	    }
	}

	/**
	 * Prompts the user to enter the designer names for a board game.
	 * Multiple names can be separated by commas.
	 * 
	 * @return the validated designer names
	 */
	public String askDesignerNamesInput() {
	    System.out.print("Enter Designer Names (Use ',' to separate names): ");
	    String designers = input.nextLine().trim();
	    while (designers.isEmpty()) {
	        System.out.print("Invalid Input: This field is empty");
	        tryAgain();
	        System.out.print("Enter Designer Names: ");
	        designers = input.nextLine().trim();
	    }
	    return designers;
	}

	/**
	 * Prompts the user to enter a puzzle type: 
	 * 'M' for Mechanical, 'C' for Cryptic, 'L' for Logic, 'T' for Trivia, or 'R' for Riddle.
	 * 
	 * @return the validated puzzle type character
	 */
	public char askPuzzleTypeInput() {
	    System.out.print("Enter Appropriate Puzzle-Type  || type [M] for mechanical, [C] for cryptic, [L] for logic, [T] for trivia, [R] for riddle: ");
	    while (true) {
	    	 char type = input.nextLine().toLowerCase().charAt(0);
	    	 if(type == 'm' || type == 'c' || type == 'l' || type == 't' || type == 'r' ) {
	    		 return type;
	    	 }
	    	 else {
	    		 System.out.print("Invalid input: enter either [M], [C], [L], [T], [R]");
	    		 tryAgain();
	    	 }
	    }
	}

	/**
	 * Prints a "Try Again" message to prompt the user for another input attempt.
	 */
	public void tryAgain() {
		System.out.println(" Try Again");
	}

	/**
	 * Prompts the user to enter a serial number or press ENTER to go back.
	 * 
	 * @return the serial number entered by the user
	 */
	public String askSerialNumber() {
		System.out.println("enter SN or [ENTER] to go back: ");
		return input.nextLine();
	}

	/**
	 * Displays a placeholder message when a toy is added.
	 */
	public void toyAddMessage() {
		// TODO Auto-generated method stub
	}

	/**
	 * Displays the main menu and prompts the user for an option.
	 * 
	 * @return the user's menu selection
	 */
	public String displayMainMenu() {
		System.out.println("How May We Help You?");
		System.out.println();
		System.out.println("(1) Search Inventory and Purchase Toy");
		System.out.println("(2) Add New Toy");
		System.out.println("(3) Remove Toy");
		System.out.println("(4) Gift Suggestion");
		System.out.println("(5) Save & Exit");
		System.out.println();
		System.out.print("Enter Option:");
		return input.nextLine();
	}

	/**
	 * Displays the save and exit message.
	 */
	public void displaySaveExit() {
		System.out.println("Saving data");
	}

	/**
	 * Displays the toy search options and prompts the user for a search type.
	 * 
	 * @return the user's selection for toy search criteria
	 */
	public String displayFindToys() {
		System.out.print("choose number 1sn, 2name ,3toy type, 4");
		this.displayBackToMainMenu();
		return input.nextLine();
	}

	/**
	 * Displays a "Back to main menu" message.
	 */
	public void displayBackToMainMenu() {
		System.out.println("go back ");
	}

	/**
	 * Displays an invalid option message and prompts the user to try again.
	 */
	public void InvalidOption() {
		System.out.print("this is not a valid option");
		this.tryAgain();
	}

	/**
	 * Displays a formatted list of toys.
	 * 
	 * @param count   the index or count of the toy in the list
	 * @param toyList the string representation of the toy
	 */
	public void displaytoylist(int count, String toyList) {
		System.out.print(String.format("%-7s", " (" + count + ")"));
		System.out.println(toyList);
	}

	/**
	 * Displays a message indicating that no toys were found.
	 */
	public void toyNotFound() {
		System.out.print("There were no toys found");
		this.tryAgain();
	}

	/**
	 * Prompts the user to enter an option number for purchasing a toy.
	 * 
	 * @return the validated option number
	 */
	public int enterOptionNumber() {
		System.out.print("Enter option Number to purchase: ");
		while (true) {
	        try {
	            int option = input.nextInt();
	            input.nextLine();
	            return option;
	        } catch (Exception e) {
	            System.out.print("Invalid input: Input must be a number");
	            tryAgain();
	            input.nextLine();
	        }
	        System.out.print("Enter option Number to purchase: ");
	    }
	}

	/**
	 * Prompts the user to confirm if they want to remove a toy.
	 * 
	 * @return {@code true} if the user types 'y', otherwise {@code false}
	 */
	public boolean askToRemove() {
		System.out.println("do you want to remove y/n?: ");
	 	if(input.nextLine().equals("y")) return true;
	 	else return false;
	}
}
