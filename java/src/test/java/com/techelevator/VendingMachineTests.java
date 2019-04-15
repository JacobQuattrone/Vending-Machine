package com.techelevator;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;

public class VendingMachineTests extends VendingMachine{
	/*@Test
	public void testGetItemName() {					**Can't Call itemMap**
		VendingMachine thisVendingMachine = new VendingMachine();
		ArrayList<String> output = new ArrayList<String>();
		output = thisVendingMachine.getPrintableItemList();
		Assert.assertEquals(, itemName);
	}*/
	
	@Test
	public void getCurrentBalanceTest() {
		VendingMachine thisVendingMachine = new VendingMachine();
		int currentBalance = thisVendingMachine.getCurrentBalance();
		Assert.assertEquals(0, currentBalance);
	}

	/*@Test
	public void setCurrentBalanceTest() {
		VendingMachine thisVendingMachine = new VendingMachine();
		Integer currentBalance = thisVendingMachine.setCurrentBalance(5);
		Assert.assertEquals(5, currentBalance);
	}*/
	
	@Test
	public void testIsOutOfStockFalse() {
		VendingMachine thisVendingMachine = new VendingMachine();
		boolean outOfStock = thisVendingMachine.isOutOfStock("A1");
		Assert.assertEquals(false, outOfStock);
	}

	/*@Test
	public void testIsOutOfStockTrue() {
		VendingMachine thisVendingMachine = new VendingMachine();
		Chip selectedItem = new Chip("A1", "chips", 3.05, "Chip", 0, "Crunch Crunch Yum!");
		selectedItem.setItemQuantity(0);
		boolean outOfStock = thisVendingMachine.isOutOfStock("A1");
		Assert.assertEquals(true, outOfStock);
	}*/
	
	/*@Test
	public void testPurchaseMethod() {				**Can't Call itemMap**
		VendingMachine thisVendingMachine = new VendingMachine();
		Item selectedItem = itemMap.get(slot);
		if (currentBalance >= selectedItem.getItemPrice()) {
			currentBalance = (int) (currentBalance - (selectedItem.getItemPrice() * 100));
	}*/

}
