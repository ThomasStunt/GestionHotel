package Customers;

import java.util.Random;

public class MaleCustomer extends Customer {
	// Attributes
	private int incomingEntries;
	private MaleNames names = new MaleNames();

	// Constructor	
	public MaleCustomer() {
		super();
		computeInc();
		generateName();
	}
	
	public MaleCustomer(String name) {
		super(name);
		computeInc();
	}
	
	public MaleCustomer(String name, int age) {
		super(name, age);
		computeInc();
	}

	// Getters
	public int getIncomingEntries() {
		return this.incomingEntries;
	}

	// Setters
	public void setIncomingEntries(int incomingEntries) {
		this.incomingEntries = incomingEntries;
	}

	// Methods
	public void computeInc() {
		Random r = new Random();
		this.incomingEntries = r.nextInt(100) + 75;
	}
	
	public void generateName() {
		String name = names.pickName();
		this.setName(name);
	}
}
