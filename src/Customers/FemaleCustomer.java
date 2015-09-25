package Customers;

import java.util.Random;

public class FemaleCustomer extends Customer {
	// Attributes
	private int dailyLosts;
	private FemaleNames names = new FemaleNames();

	// Constructor
	public FemaleCustomer() {
		super();
		computeBuy();
		generateName();
	}

	public FemaleCustomer(String name) {
		super(name);
		computeBuy();
	}

	public FemaleCustomer(String name, int age) {
		super(name, age);
		computeBuy();
	}

	// Getters
	public int getDailyLosts() {
		return this.dailyLosts;
	}

	// Setters
	public void setDailyLosts(int dailyLosts) {
		this.dailyLosts = dailyLosts;
	}

	// Methods
	public void computeBuy() {
		Random r = new Random();
		this.dailyLosts = r.nextInt(45);
	}

	public void generateName() {
		String name = names.pickName();
		this.setName(name);
	}
}
