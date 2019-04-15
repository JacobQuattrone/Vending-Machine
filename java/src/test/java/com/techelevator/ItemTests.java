package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ItemTests {
	

	
	@Test
	public void testGetItemName() {
		Chip theItem = new Chip("A1", "chips", 3.05, "Chip", 5, "Crunch Crunch Yum!");
		String itemName = theItem.getItemName();
		Assert.assertEquals("chips", itemName);
	}
	@Test
	public void testGetItemSlot() {
		Chip theItem = new Chip("A1", "chips", 3.05, "Chip", 5, "Crunch Crunch Yum!");
		String itemSlot = theItem.getItemSlot();
		Assert.assertEquals("A1", itemSlot);
	}
	@Test
	public void testGetItemPrice() {
		Chip theItem = new Chip("A1", "chips", 3.05, "Chip", 5, "Crunch Crunch Yum!");
		double itemPrice = theItem.getItemPrice();
		Assert.assertEquals(3.05, itemPrice);
	}
	@Test
	public void testGetItemQuantity() {
		Chip theItem = new Chip("A1", "chips", 3.05, "Chip", 5, "Crunch Crunch Yum!");
		int itemQuantity = theItem.getItemQuantity();
		Assert.assertEquals(5, itemQuantity);
	}
	@Test
	public void testGetItemSoundEffect() {
		Chip theItem = new Chip("A1", "chips", 3.05, "Chip", 5, "Crunch Crunch Yum!");
		String itemSound = theItem.getSoundEffect();
		Assert.assertEquals("Crunch Crunch Yum!", itemSound);
	}

	@Test
	public void testSetItemName() {
		Chip theItem = new Chip("A1", "chips", 3.05, "Chip", 5, "Crunch Crunch Yum!");
		 theItem.setItemName();
		Assert.assertEquals("chips", theItem.getItemName());
	}
	@Test
	public void testSetItemSlot() {
		Chip theItem = new Chip("A1", "chips", 3.05, "Chip", 5, "Crunch Crunch Yum!");
		 theItem.setItemSlot();
		Assert.assertEquals("A1", theItem.getItemSlot());
	}
	@Test
	public void testSetItemPrice() {
		Chip theItem = new Chip("A1", "chips", 3.05, "Chip", 5, "Crunch Crunch Yum!");
		 theItem.setItemPrice();
		Assert.assertEquals(3.05, theItem.getItemPrice());
	}
	@Test
	public void testSetItemQuantity() {
		Chip theItem = new Chip("A1", "chips", 3.05, "Chip", 5, "Crunch Crunch Yum!");
		 theItem.setItemQuantity(5);
		Assert.assertEquals(5, theItem.getItemQuantity());
	}
	@Test
	public void testItemToString() {
		Chip theItem = new Chip("A1", "chips", 3.05, "Chip", 5, "Crunch Crunch Yum!");
		 theItem.toString();
		Assert.assertEquals("chips" + "	" + 3.05 + " " + 5, theItem.toString());
	}
}
