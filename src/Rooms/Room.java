package Rooms;

import java.util.Random;

import Customers.Customer;

public class Room {
	// Attributes
	private String name;
	private int price;
	private int initialTime;
	private int time;
	private boolean booked;
	private Customer c;
	private int dayBooked;

	// Constructor
	public Room() {
	}

	public Room(String name) {
		this.name = name;
		this.price = new Random().nextInt(20) + 17;
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

	public int getDayBooked() {
		return this.dayBooked;
	}

	public Customer getC() {
		return this.c;
	}

	public int getInitialTime() {
		return this.initialTime;
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

	public void setDayBooked(int dayBooked) {
		this.dayBooked = dayBooked;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	public void setInitialTime(int initialTime) {
		this.initialTime = initialTime;
	}

	// toString
	public String toString() {
		return "- Room " + this.getName() + " - " + this.getPrice()
				+ " € / day - Initial time : " + this.getInitialTime()
				+ " - Time left : " + this.getTime();
	}
}
