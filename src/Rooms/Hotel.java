package Rooms;

import java.util.ArrayList;

import Customers.Customer;

public class Hotel {
	// Attributes
	private ArrayList<Room> li = new ArrayList<Room>();
	private int score;

	// Constructors
	public Hotel(ArrayList<Room> li) {
		this.li = li;
		initHotel();
	}

	// Getters
	public ArrayList<Room> getLi() {
		return this.li;
	}
	
	public int getScore() {
		return this.score;
	}

	// Setters
	public void setLi(ArrayList<Room> li) {
		this.li = li;
	}
	
	public void setScore(int score) {
		this.score = score;
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
			int time = r.getTime();
			int totalPrice = time * r.getPrice();
			System.out.println("Thank you ! You must pay " + totalPrice
					+ " € !");
			int moneyLeft = r.getCustomer().getMoney() - totalPrice;
			this.setScore(this.getScore()+totalPrice);
			r.getCustomer().setMoney(moneyLeft);
			r.setCustomer(null);
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
