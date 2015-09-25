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
		for (Room r : h.getLi()) {
			if (r.getTime() != 0 && r.getBooked()) {
				int timeLeft = r.getTime() - 1;
				r.setTime(timeLeft);
			}
			if (r.getTime() == 0 && r.getBooked()) {
				this.h.endBook(r);
			}
		}
		gameRound();
	}

	public void gameRound() {
		System.out.println("---- Day n°" + nbTours + " ----"
				+ "\n\t Actual score : " + h.getScore() + "\n");
		String s = "What do you want to do ?"
				+ "\n\t 1 - Welcome the new customers"
				+ "`\n\t 2 - Check your bookings";
		System.out.println(s);
		String s1 = sc.nextLine();
		if (s1.equals("1")) {
			System.out.println("\n---- Welcome the new customers ----\n");
			Random r = new Random();
			int nbCustomers = r.nextInt(2) + 1;
			if (nbCustomers == 1) {
				System.out.println("You have 1 customer who wants a room : \n");
			} else {
				System.out.println("You have " + nbCustomers
						+ " customers who whant a room : \n");
			}
			while (nbCustomers > 0) {
				int ra = r.nextInt(2);
				if (ra == 0) {
					c = new MaleCustomer();
				} else if (ra == 1) {
					c = new FemaleCustomer();
				}
				int d = (r.nextInt(4) + 3);
				System.out.println(c.getName() + " wants a room for " + d
						+ " day(s) !\n");
				System.out.println("What do you want to do ?"
						+ "\n\t 1 - Give " + c.getName() + " a room."
						+ "\n\t 2 - Don't give " + c.getName() + " a room.");
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
									h.getLi().get(i + j).setDayBooked(nbTours);
									h.getLi().get(i + j).setInitialTime(d);
									nbCustomers--;
								} else {
									h.book(h.getLi().get(i), c, d);
									h.getLi().get(i).setDayBooked(nbTours);
									h.getLi().get(i).setInitialTime(d);
									nbCustomers--;
									break;
								}
							}
						}
					}
				} else {
					System.out.println();
					nbCustomers--;
				}
			}
			System.out.println("\nDay is over ! \n\n\n");
			nbTours++;
		} else if (s1.equals("2")) {
			System.out.println("\n---- Check your bookings ---- \n" + "\n" + h);
		} else {
			System.out.println("Please type a correct answer\n");
			gameRound();
		}
	}
}
