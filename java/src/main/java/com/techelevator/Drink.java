package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item {

	public Drink(String itemSlot, String itemName, double itemPrice, String itemSuper, int itemQuantity, String soundEffect) {
		
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemSlot = itemSlot;
		this.itemQuantity = itemQuantity;
		this.soundEffect = "Glug Glug, Yum!";
	}
}
