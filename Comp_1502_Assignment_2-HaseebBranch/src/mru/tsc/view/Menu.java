package mru.tsc.view;

import java.util.Scanner;

import mru.tsc.model.Animal;
import mru.tsc.model.BoardGame;
import mru.tsc.model.Figure;
import mru.tsc.model.Puzzle;

public class Menu {
	static Scanner input;
	
	public Menu() {
		input = new Scanner(System.in);
	}
	
	
	
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

	public double askPriceInput() {
	    System.out.print("Enter Toy Price: ");
	    while (true) {
	        try {
	            double price = input.nextDouble();
	            input.nextLine(); // clear the left over newline
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
	        }
	        System.out.print("Enter Toy Price: ");
	    }
	}

	public int askCountInput() {
	    System.out.print("Enter Available Count: ");
	    while (true) {
	        try {
	            int count = input.nextInt();
	            input.nextLine(); // clear the left over newline
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
	            input.nextLine(); // clear the left over newline
	        }
	        System.out.print("Enter Available Count: ");
	    }
	}

	public int askAgeInput() {
	    System.out.print("Enter Appropriate Age: ");
	    while (true) {
	        try {
	            int age = input.nextInt();
	            input.nextLine(); // clear the left over newline
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

	public int askMinPlayersInput() {
	    System.out.print("Enter Minimum Number of Players: ");
	    while (true) {
	        try {
	            int minNum = input.nextInt();
	            input.nextLine(); // clear the left over newline
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

	public int askMaxPlayersInput() {
	    System.out.print("Enter Maximum Number of Players: ");
	    while (true) {
	        try {
	            int maxNum = input.nextInt();
	            input.nextLine(); // clear the left over newline
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

	public String askDesignerNamesInput() { //should validate this i think 
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

	public char askPuzzleTypeInput() {
	    System.out.print("Enter Appropriate Puzzle-Type  || type [M] for mechanical, [C] for cryptic, [L] for logic, [T] for trivia, [R] for riddle: : ");
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

	public void tryAgain() {
		System.out.println(" ==Try Again==");
	}



	public String askSerialNumber() {
		//please validate serial number and return value WIP
		System.out.println("enter SN: "); //temporary placeholder
		return input.nextLine();

	}





	public void toyAddMessage() {
		// TODO Auto-generated method stub
		
	}



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
		
		String userInput = input.nextLine();
		return userInput;
	}



	public void displaySaveExit() {
		// TODO Auto-generated method stub
		System.out.println("Savingdata");
	}



	public String displayFindToys() {
		System.out.print("choose number 1sn, 2name ,3toy type, 4"); //placeholder
		this.displayBackToMainMenu();
		return input.nextLine();
		
	}



	public void displayBackToMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("go back ");
	}



	public void InvalidOption() {
		System.out.print("this is not a valid option");
		this.tryAgain();
		
	}



	public void displaytoylist(int count, String toyList) {
		System.out.print(String.format("%-7s", " (" + count + ")"));
		
		System.out.println(toyList);
		
		
		
	}



	public void toyNotFound() {
		System.out.println("There were no toys found");
	}



	public int enterOptionNumber() { //validate this please
		// TODO Auto-generated method stub
		System.out.print("Enter option Number to purchase: ");
		while (true) {
	        try {
	            int option = input.nextInt();
	            input.nextLine(); // clear the left over newline
	            return option;

	        } catch (Exception e) {
	            System.out.print("Invalid input: Input must be a number");
	            tryAgain();
	            input.nextLine();
	           
	        }
	        System.out.print("Enter option Number to purchase: ");
	    }
	}



	public boolean askToRemove() {
		// TODO Auto-generated method stub
		System.out.println("do you want to remove y/n?: "); //placeholder to call menu class
		
	 	if(input.nextLine().equals("y")) return true;
	 	else return false;
	}
}
