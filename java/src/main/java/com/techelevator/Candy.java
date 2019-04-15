package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item {

public Candy(String itemSlot, String itemName, double itemPrice, String itemSuper, int itemQuantity, String soundEffect) {
	this.itemName = itemName;
	this.itemPrice = itemPrice;
	this.itemSlot = itemSlot;
	this.itemQuantity = itemQuantity;	
	this.soundEffect = "Munch Munch, Yum!";
	}
}
