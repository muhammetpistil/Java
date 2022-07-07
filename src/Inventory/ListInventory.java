package Inventory;

import java.util.ArrayList;
import java.util.List;

import Repository.InventoryRepo;

public class ListInventory {
	
	public InventoryRepo inventoryRepo = new InventoryRepo();
	private List<Phone>    phoneList 	= new ArrayList<>();
	private List<Laptop>   laptopList   = new ArrayList<>();
	private List<Apple>    appleList    = new ArrayList<>();
	private List<Banana>   bananaList   = new ArrayList<>();
	private List<Water>    waterList    = new ArrayList<>();
	private List<Milk>     milkList     = new ArrayList<>();
	private List<Product>  proList      = new ArrayList<>();
	
	public List<Product> getProList() {
		return proList;
	}

	public void setProList(List<Product> proList) {
		this.proList = proList;
	}

	public List<Phone> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}
	
	public List<Laptop> getLaptopList() {
		return laptopList;
	}

	public void setLaptopList(List<Laptop> laptopList) {
		this.laptopList = laptopList;
	}

	public List<Apple> getAppleList() {
		return appleList;
	}

	public void setAppleList(List<Apple> appleList) {
		this.appleList = appleList;
	}

	public List<Banana> getBananaList() {
		return bananaList;
	}

	public void setBananaList(List<Banana> bananaList) {
		this.bananaList = bananaList;
	}

	public List<Water> getWaterList() {
		return waterList;
	}

	public void setWaterList(List<Water> waterList) {
		this.waterList = waterList;
	}

	public List<Milk> getMilkList() {
		return milkList;
	}

	public void setMilkList(List<Milk> milkList) {
		this.milkList = milkList;
	}

	public void create() {
		
		getPhoneList().add(inventoryRepo.iphone);
		getPhoneList().add(inventoryRepo.samsung);
		getLaptopList().add(inventoryRepo.monster);
		getLaptopList().add(inventoryRepo.asus);
		getAppleList().add(inventoryRepo.greenApple);
		getAppleList().add(inventoryRepo.redApple);
		getBananaList().add(inventoryRepo.importedBanana);
		getBananaList().add(inventoryRepo.localBanana);
		getMilkList().add(inventoryRepo.boxMilk);
		getMilkList().add(inventoryRepo.dailyMilk);
		getWaterList().add(inventoryRepo.bottledWater);
		getWaterList().add(inventoryRepo.glassWater);
		
		getProList().addAll(getAppleList());getProList().addAll(getBananaList());
		getProList().addAll(getPhoneList());getProList().addAll(getLaptopList());
		getProList().addAll(getWaterList());getProList().addAll(getMilkList());
		
	}

}
