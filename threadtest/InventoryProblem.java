package com.threadtest;

import java.util.ArrayList;
import java.util.List;

class Inventory
{
	Inventory()
	{}
	public Inventory(String inventoryName, int quantityOrdered) {
		super();
		this.inventoryName = inventoryName;
		this.quantityOrdered = quantityOrdered;
	}
	private String inventoryName;
	private int quantityOrdered;
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
}


public class InventoryProblem {
	
	public void getNoofTime(List<Inventory> invList,String inventoryName)
	{
		long countoforder=invList.stream().map(x->x.getInventoryName()).filter(x->x.equals(inventoryName)).count();
		System.out.println("InventoryName "+ inventoryName+ " has been ordered "+ countoforder + " Times");
	}
	
	public void getthequantity(List<Inventory> invList,String inventoryName)
	{
		long CountoQuantity=invList.stream().filter(x->x.getInventoryName().equals(inventoryName)).mapToInt(l->l.getQuantityOrdered()).sum();
		System.out.println("InventoryName "+ inventoryName+ " has been ordered "+ CountoQuantity + " quantity");
	}
	
	public static void main(String[] args) {
		
		List<Inventory> invList =new ArrayList<Inventory>();
		invList.add(new Inventory("x",10));
		invList.add(new Inventory("y",5));
		invList.add(new Inventory("z",6));
		invList.add(new Inventory("x",7));
		invList.add(new Inventory("y",9));
		invList.add(new Inventory("z",15));
		//invList=[{"inventoryName":"X","quantityOrdered":6}];
		//System.out.println(invList.toArray());
		InventoryProblem Inobj= new InventoryProblem();
		Inobj.getNoofTime(invList,"z");
		Inobj.getthequantity(invList,"z");
		
		
	}

}
