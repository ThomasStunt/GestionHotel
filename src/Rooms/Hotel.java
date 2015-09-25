package Rooms;

import java.util.ArrayList;

import Customers.Customer;

public class Hotel {
	// Attributes
	private ArrayList<Room> li = new ArrayList<Room>();
	private int money = 1500;

	// Constructors
	public Hotel(ArrayList<Room> li) {
		this.li = li;
		initHotel();
	}

	// Getters
	public ArrayList<Room> getLi() {
		return this.li;
	}

	public int getMoney() {
		return this.money;
	}

	// Setters
	public void setLi(ArrayList<Room> li) {
		this.li = li;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// Methods
	public void book(Room r, Customer c, int time) {
		if (!r.getBooked()) {
			r.setTime(time);
			r.setBooked(true);
			r.setCustomer(c);
			System.out.println("\n" + c.getName() + " just booked room "
					+ r.getName() + " for " + time + " days !\n");
		}
	}

	public void endBook(Room r) {
		if (r.getBooked()) {
			int time = r.getInitialTime();
			int totalPrice = time * r.getPrice();
			System.out.println("The customer " + r.getC().getName()
					+ " left the hotel. You earned " + totalPrice + " € !\n");
			int moneyLeft = r.getCustomer().getMoney() - totalPrice;
			this.setMoney(this.getMoney() + totalPrice);
			r.getCustomer().setMoney(moneyLeft);
			r.setCustomer(null);
			r.setBooked(false);
			r.setInitialTime(0);
		}
	}

	public void initHotel() {
		for (int i = 1; i <= 12; i++) {
			li.add(new Room("" + i));
		}
	}

	// toString
	public String toString() {
		String res = "";
		for (int i = 0; i < li.size(); i++) {
			if (li.get(i).getCustomer() == null) {
				res += "" + li.get(i) + " - Not booked\n";
			} else {
				res += "" + li.get(i) + " - " + li.get(i).getCustomer();
			}
		}
		return res;
	}
}
