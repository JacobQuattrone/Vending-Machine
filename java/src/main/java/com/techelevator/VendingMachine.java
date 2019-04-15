package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.view.Menu;
import com.techelevator.view.SimpleInput;

public class VendingMachine {

	private Map<String, Item> itemMap = new LinkedHashMap<String, Item>();
	private ArrayList<String> inventoryList = new ArrayList<String>();
	private int currentBalance;
	File logFile = new File("Log.txt");

	
	
	public VendingMachine() {
		
		String itemSlot = "";
		String itemName = "";
		String itemPrice = "";
		String itemSuper = "";
		String soundEffect = "";
		try {
			logFile.createNewFile();
		} catch (IOException e1) {
			System.out.println("IO Exception");
		}
		int itemQuantity = 5;
		
		File sourceFile = new File("vendingmachine.csv");
		
		
		try (Scanner itemInventory = new Scanner(sourceFile)) {
			
			while (itemInventory.hasNextLine()) {
				String line = itemInventory.nextLine();
			
				String[] parts = line.split("\\|");
				
			
				
				
				itemSlot = parts[0];
				itemName = parts[1];
				itemPrice = parts[2];
				itemSuper = parts[3];
				
				
				if (itemSuper.contentEquals("Chip")) {
					itemMap.put(parts[0], new Chip(itemSlot, itemName, Double.parseDouble(itemPrice) , itemSuper, itemQuantity, soundEffect));
					soundEffect = "Crunch Crunch, Yum!";
					String inventory = parts[0] + parts[1] + parts[2] + parts[3] + soundEffect;
					inventoryList.add(inventory);
				}
				
				if (itemSuper.contentEquals("Candy")) {
					itemMap.put(parts[0], new Candy(itemSlot, itemName, Double.parseDouble(itemPrice), itemSuper, itemQuantity, soundEffect));
					String inventory = parts[0] + parts[1] + parts[2] + parts[3];
					inventoryList.add(inventory);
				}
				
				if (itemSuper.contentEquals("Drink")) {
					itemMap.put(parts[0], new Drink(itemSlot, itemName, Double.parseDouble(itemPrice), itemSuper, itemQuantity, soundEffect));
					String inventory = parts[0] + parts[1] + parts[2] + parts[3];
					inventoryList.add(inventory);
				}
				
				if (itemSuper.contentEquals("Gum")) {
					itemMap.put(parts[0], new Gum(itemSlot, itemName, Double.parseDouble(itemPrice), itemSuper, itemQuantity, soundEffect));
					String inventory = parts[0] + parts[1] + parts[2] + parts[3];
					inventoryList.add(inventory);
				}	
			}

			//System.out.println(itemMap.entrySet());
			//System.out.println(new ArrayList<Item>(itemMap.entrySet());
			
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
	}
	
	
	
	public List<String> getPrintableItemList() {
		ArrayList<String> output = new ArrayList<String>();
		for(String slot : itemMap.keySet()) {
			output.add(slot + " " + itemMap.get(slot));
		}
		return output;
		
	}
	public int feedMoney(int moneyIn) {

			return currentBalance = currentBalance + moneyIn;	
			
	}
	public Integer getCurrentBalance() {
		return currentBalance;
	}
	
	public void setCurrentBalance(Integer currentBalance) {
		this.currentBalance = currentBalance;
	}
	public boolean isOutOfStock(String slot) {
		boolean result = false;
		Item selectedItem = itemMap.get(slot);
		if (selectedItem.getItemQuantity() == 0) {
			result = true;
		}
		return result;
	}
	
	public boolean purchase(String slot) {
		boolean result = false;
		Item selectedItem = itemMap.get(slot);
		if (currentBalance >= selectedItem.getItemPrice()) {
			currentBalance = (int) (currentBalance - (selectedItem.getItemPrice() * 100));
			selectedItem.setItemQuantity(selectedItem.getItemQuantity()- 1);
			result = true;
		}
		return result;
	}
	
	public String getSoundEffect(String slot) {
		Item selectedItem = itemMap.get(slot);
		String soundEffect = "";
		if(slot.contains("A")) {
			soundEffect = "Crunch Crunch, Yum! ";
		}
		if(slot.contains("B")) {
			soundEffect = "Munch Munch, Yum! ";
		}
		if(slot.contains("C")) {
			soundEffect = "Glug Glug, Yum! ";
		}
		if(slot.contains("D")) {
			soundEffect = "Chew Chew, Yum! ";
		}
			return soundEffect;
	}
	
	public String getItemName(String itemName) {
		Item selectedItem = itemMap.get(itemName);
		itemName = selectedItem.getItemName();
		return itemName;
		
	}
	
	public String getChange(int balance) {
		int dollars = 0;
		int quarters = 0;
		int dimes = 0;
		int nickles = 0;
		
		if(balance > 0) {
			dollars = balance / 100;
			quarters = (balance % 100) / 25;
			dimes = (balance % 25) / 10;
			nickles = (balance % 10) / 5;
			
			String change = "Change: $" + dollars + " " + quarters + " quarters " + dimes + " dimes " + nickles + " nickles ";
			currentBalance = 0;
			return change;
		}
		else {
			return "Change: 0.00";
		}
	}
	
	
	
	
	String timeStamp = new SimpleDateFormat("MM-dd-yyyy " + " " +"hh-mm-ss").format(Calendar.getInstance().getTime());
	
	
	
	public void makeLogEntry(String line) {
		
		try (PrintWriter destinationWriter = new PrintWriter(new FileWriter(logFile), true)) {	
			
			line = timeStamp;
			
			destinationWriter.println(line);
			destinationWriter.close();
		
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
	}
}