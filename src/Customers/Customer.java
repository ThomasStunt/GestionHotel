package Customers;

import java.util.Random;

public class Customer {
	// Attributes
	private String name;
	private int age;
	private int money = 125;

	// Constructors
	public Customer() {
		this.age = new Random().nextInt(25)+20;
		generateMoney();
	}
	
	public Customer(String name) {
		this.name=name;
		this.age=20;
		generateMoney();
	}
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		generateMoney();
	}
	
	public Customer(String name, int age, int money) {
		this.name=name;
		this.age=age;
		this.money=money;
	}

	// Getters
	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public int getMoney() {
		return this.money;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// Methods
	public void generateMoney() {
		Random r = new Random();
		int m = r.nextInt(150) + 125;
		this.setMoney(m);
	}

	// toString
	public String toString() {
		return "" + this.name + " - " + this.age + " Yo - " + this.money + " €\n";
	}
}
