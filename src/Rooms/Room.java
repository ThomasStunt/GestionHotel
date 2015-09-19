package Rooms;

import java.util.Random;

import Customers.Customer;

public class Room {
	// Attributes
	private String name;
	private int price;
	private int time;
	private boolean booked;
	private Customer c;

	// Constructor
	public Room() {
	}

	public Room(String name) {
		this.name = name;
		this.price = new Random().nextInt(20) + 5;
	}

	// Getters
	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public int getTime() {
		return this.time;
	}

	public boolean getBooked() {
		return this.booked;
	}

	public Customer getCustomer() {
		return this.c;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public void setCustomer(Customer c) {
		this.c = c;
	}

	// toString
	public String toString() {
		return "- Room " + this.getName() + " - " + this.getPrice()
				+ " € / day - Time left : "+this.getTime();
	}
}
