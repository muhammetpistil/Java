package Repository;

import Inventory.Apple;
import Inventory.Banana;
import Inventory.Laptop;
import Inventory.Milk;
import Inventory.Phone;
import Inventory.Water;

public class InventoryRepo {
	
	//Phones
	public Phone samsung = new Phone("Samsung", 1122, 750);
	public Phone iphone = new Phone("Iphone", 1133, 1200);
	
	//Laptops
	public Laptop monster = new Laptop("Monster", 2211, 2000);
	public Laptop asus = new Laptop("Asus", 3311, 2500);
	
	//Apples
	public Apple redApple = new Apple("Red Apple", 2233, 15);
	public Apple greenApple = new Apple("Green Apple", 3322, 25);
	
	//Bananas
	public Banana localBanana = new Banana("Local Banana", 1144, 45);
	public Banana importedBanana = new Banana("Imported Banana", 4411, 65);
	
	//Waters
	public Water bottledWater = new Water("Bottled Water", 4422, 10);
	public Water glassWater = new Water("Glass Water", 2244, 5);
	
	//Milks
	public Milk boxMilk = new Milk("Box Milk", 3344, 35);
	public Milk dailyMilk = new Milk("Daily Milk", 4433, 55);

}
