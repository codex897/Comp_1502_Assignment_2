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
	
	
	
	
	
	public Figure promptAddFigure(String serialNumber) {
		System.out.print("Enter Toy Name: ");
		String name = input.nextLine().trim();
		System.out.print("Enter Toy Brand: ");
		String brand = input.nextLine().trim();
		System.out.print("Enter Toy Price: ");
		double price = input.nextDouble();

		System.out.print("Enter Available Count: ");
		int count = input.nextInt();
		System.out.print("Enter Appropriate Age: ");
		int age = input.nextInt();
		System.out.print("Enter Appropriate classification: ");
		char classification = input.next().charAt(0);

		return new Figure(serialNumber, name, brand, price, count, age, classification);
	}
	

	public Animal messageAddAnimal(String serialNumber) {
		System.out.print("Enter Toy Name: ");
		String name = input.nextLine().trim();
		System.out.print("Enter Toy Brand: ");
		String brand = input.nextLine().trim();
		System.out.print("Enter Available Count: ");
		int count = input.nextInt();
		System.out.print("Enter Toy Price: ");
		double price = input.nextDouble();
		System.out.print("Enter Appropriate Age: ");
		int age = input.nextInt();
		System.out.print("Enter Toy Name: ");
		String material = input.nextLine().trim();
		System.out.print("Enter Appropriate Size: ");
		char size = input.next().charAt(0);

		return new Animal(serialNumber, name, brand, price, count, age, material, size);
	}

	public BoardGame messageAddBoardGame(String serialNumber) {

		System.out.print("Enter Toy Name: ");
		String name = input.nextLine().trim();
		System.out.print("Enter Toy Brand: ");
		String brand = input.nextLine().trim();
		System.out.print("Enter Toy Price: ");
		double price = input.nextDouble();

		System.out.print("Enter Available Count: ");
		int count = input.nextInt();
		System.out.print("Enter Appropriate Age: ");
		int age = input.nextInt();

		System.out.println("Enter Minimum Number of Players: ");
		int minNum = input.nextInt();

		System.out.print("Enter Maximum Number of Players: ");
		int maxNum = input.nextInt();
		
		input.nextLine();

		
		System.out.print("Enter Designer Names(Use ',' to separate the names if there is more than one name):\n");
		String designerName = input.nextLine();

		return new BoardGame(serialNumber, name, brand, price, count, age, minNum, maxNum, designerName);
	}


	public Puzzle messageAddPuzzle(String serialNumber) {
		System.out.print("Enter Toy Name: ");
		String name = input.nextLine().trim();
		System.out.print("Enter Toy Brand: ");
		String brand = input.nextLine().trim();
		System.out.print("Enter Toy Price: ");
		double price = input.nextDouble();

		System.out.print("Enter Available Count: ");
		int count = input.nextInt();
		System.out.print("Enter Appropriate Age: ");
		int age = input.nextInt();
		System.out.print("Enter Appropriate Puzzle-Type: ");
		char type = input.next().charAt(0);

		return new Puzzle(serialNumber, name, brand, price, count, age, type);
	}
}
