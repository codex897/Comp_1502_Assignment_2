package mru.tsc.model;

import java.util.Locale.Category;

public abstract class Toy {

	private String name;
	private String serialNum;
	private String brand;
	private double price;
	private int count;
	private int ageAllowed;

	public Toy(String name, String serialNum, String brand, double price, int count, int ageAllowed) {
		this.name = name;
		this.serialNum = serialNum;
		this.brand = brand;
		this.price = price;
		this.count = count;
		this.ageAllowed = ageAllowed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAgeAllowed() {
		return ageAllowed;
	}

	public void setAgeAllowed(int ageAllowed) {
		this.ageAllowed = ageAllowed;
	}
	
	public abstract String typeOf();

	public String toString() {
		return "Category:" + this.typeOf() + ", Serial Number:" + serialNum + ", Name:"+ name +", Brand:"+ brand + ", Price:" + price
				+ ", Available Count:" + count + ", Age Apporiate:" + ageAllowed;
	}

//	public String toFileString() {
//
//		return ",";
//	}

	public String stringToFormat() {
		return serialNum + ";" + name + ";" + brand + ";" + String.format("%.2f", price)  + ";" + count + ";" + ageAllowed;
	}

	public int toyDecrement() {
		return count-=1;
		
	}
	





}
