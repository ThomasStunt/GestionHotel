package Customers;

import java.util.ArrayList;
import java.util.Random;

public class MaleNames {
	//Attributes
	private ArrayList<String> names = new ArrayList<String>();
	
	//Constructor
	public MaleNames() {
		names.add("Jean Bon");
		names.add("Jack Ady");
		names.add("Est-Ce Thomas");
		names.add("Fil Traere");
	}
	
	// Getters
	public ArrayList<String> getNames() {
		return this.names;
	}

	// Methods
	public String pickName() {
		Random r = new Random();
		int s = r.nextInt(this.getNames().size());
		return names.get(s);
	}
}
