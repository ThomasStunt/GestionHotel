package Customers;

import java.util.Random;

public class FemaleCustomer extends Customer {
	// Attributes
	private int dailyBuyings;
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
	public int getDailyBuyings() {
		return this.dailyBuyings;
	}

	// Setters
	public void setDailyBuyings(int dailyBuyings) {
		this.dailyBuyings = dailyBuyings;
	}

	// Methods
	public void computeBuy() {
		Random r = new Random();
		this.dailyBuyings = r.nextInt(45);
	}
	
	public void generateName() {
		String name = names.pickName();
		this.setName(name);
	}
}
