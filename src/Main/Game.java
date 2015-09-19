package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Customers.Customer;
import Customers.FemaleCustomer;
import Customers.MaleCustomer;
import Rooms.Hotel;
import Rooms.Room;

public class Game {
	// Attributes
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Room> g = new ArrayList<Room>();
	private Hotel h = new Hotel(g);
	private int nbTours = 1;
	private Customer c;

	// Constructor
	public Game() {
	}

	// Getters
	public int getNbTours() {
		return this.nbTours;
	}

	// Setters
	public void setNbTours(int nbTours) {
		this.nbTours = nbTours;
	}

	// Methods
	public void play() {
		System.out.println("---- Day n°" + nbTours + " ----"+"\n\t Actual score : "+h.getScore());
		String s = "\nWhat do you want to do ?"
				+ "\n\t 1 - Welcome the new customers"
				+ "`\n\t 2 - Check your bookings";
		System.out.println(s);
		String s1 = sc.nextLine();
		if (s1.equals("1")) {
			System.out.println("\n---- Welcome the new customers ----\n");
			Random r = new Random();
			int ra = r.nextInt(2);
			if (ra == 0) {
				c = new MaleCustomer();
			} else if (ra == 1) {
				c = new FemaleCustomer();
			}
			int d = (r.nextInt(4) + 1);
			System.out.println(c.getName() + " wants a room for " + d
					+ " day(s) !\n");
			System.out.println("What do you want to do ?" + "\n\t 1 - Give "
					+ c.getName() + " a room." + "\n\t 2 - Don't give "
					+ c.getName() + " a room.");
			String res = sc.nextLine();
			if (res.equals("1")) {
				System.out.println("\nWhich room do you want to give ?");
				String room = sc.nextLine();
				for (int i = 0; i < h.getLi().size(); i++) {
					if (room.equals(h.getLi().get(i).getName())) {
						for (int j = 0; j < h.getLi().size() - i; i++) {
							if (h.getLi().get(i).getBooked()) {
								System.out
										.println("The room was already booked, so we booked the next one.");
								h.book(h.getLi().get(i + j), c, d);
							} else {
								h.book(h.getLi().get(i), c, d);
								break;
							}
						}
					}
				}
			} else {
				System.out.println();
			}
			nbTours++;
		} else if (s1.equals("2")) {
			System.out.println("\n---- Check your bookings ---- \n" + "\n" + h);
		}
	}
}
