package com.techelevator;

import java.math.BigDecimal;

public class Item {

	String itemSlot = "";
	String itemName = "";
	double itemPrice;
	String itemSuper = "";
	int itemQuantity;
	String soundEffect = "";

	public Item() {
		
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice() {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName() {
		this.itemName = itemName;
	}

	public String getItemSlot() {
		return itemSlot;
	}

	public void setItemSlot() {
		this.itemSlot = itemSlot;
	}
	public  String getSoundEffect() {
		return soundEffect;
	}

	@Override
	public String toString() {

		return itemName + "	" + itemPrice + " " + itemQuantity;
	}
}
