package Customers;

import java.util.ArrayList;
import java.util.Random;

public class FemaleNames {
	// Attributes
	private ArrayList<String> names = new ArrayList<String>();

	// Constructor
	public FemaleNames() {
		names.add("Sarah Vigote");
		names.add("Jo Révoulu");
		names.add("Mary Olé");
		names.add("Louise Iaan");
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
