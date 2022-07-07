package Inventory;

public abstract class Grocery extends Product{

	public Grocery(String name, int id, double price) {
		super(name, id, price, "Grocery");
	}
}
