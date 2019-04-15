package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

public class VendingMachineCLI extends VendingMachine{

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_QUIT = "Quit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
			MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_QUIT };
	private static final String FEED_MONEY = "Feed Money";
	private static final String SELECT_PRODUCT = "Select Product";
	private static final String FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] PURCHASE_MENU_OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION };

	private Menu menu; 

	String timeStamp = new SimpleDateFormat("MM-dd-yyyy" + " " + "hh:mm:ss" + " ").format(Calendar.getInstance().getTime());
	String line = timeStamp;
	File logFile = new File("Log.txt");
	String priorBalance = "";

	private VendingMachine vendingMachine = new VendingMachine();
	private FileWriter logWriter;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		try {
			logFile.delete();
		logWriter = new FileWriter(logFile, true); 
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception");
		}
		catch (IOException e1) {
			System.out.println("IO Exception");
		}
	}

	public void run() {


		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			while(choice != MAIN_MENU_OPTION_QUIT) {

				if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
					for(String line : vendingMachine.getPrintableItemList()) {
						System.out.println(line);
					}
				} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {			
					String choice1 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					while(choice1 != FINISH_TRANSACTION) {
						
						if(choice1.equals(FEED_MONEY)) {
							SimpleInput input = new SimpleInput();
							String yOrN = "n";

							while (yOrN.equalsIgnoreCase("N")) {
								String moneyIn = input.promptUserForString("How much money (in whole dollars) would you like to feed in? ");

								
									vendingMachine.feedMoney(Integer.parseInt(moneyIn)* 100);
									String logString = BigDecimal.valueOf((vendingMachine.getCurrentBalance())).movePointLeft(2).toString();
									try {
										logWriter.write(timeStamp + " " + "FEED MONEY " +  " $" + moneyIn + ".00" + " " + "$" + logString +"\n");
										logWriter.flush();
									} catch (IOException e) {
										System.out.println("IO Exception");
									}
									priorBalance = BigDecimal.valueOf((vendingMachine.getCurrentBalance())).movePointLeft(2).toString();
									yOrN = input.promptUserForString("Are you done adding money? (Y/N)");
									//vendingMachine.setCurrentBalance(getCurrentBalance() + Double.parseDouble(moneyIn));
									System.out.println("Current Money Provided: $" + BigDecimal.valueOf((vendingMachine.getCurrentBalance())).movePointLeft(2));
									System.out.println(moneyIn);	

							}
							if (yOrN.equalsIgnoreCase("Y")) {
								choice1 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

							}
						}	
						else if (choice1.equals(SELECT_PRODUCT)) {
							for(String line : vendingMachine.getPrintableItemList()) {
								System.out.println(line);
							}
							SimpleInput input = new SimpleInput();
							String selection = input.promptUserForString("Please make your selection");
							if(vendingMachine.isOutOfStock(selection) == true) {
								System.out.println("ITEM OUT OF STOCK" + "\\n");

							}	
							else {
								if (vendingMachine.purchase(selection) == false) {
									System.out.println("Insufficient funds.");
									choice1 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
								}
								else {
										
									String logString = BigDecimal.valueOf((vendingMachine.getCurrentBalance())).movePointLeft(2).toString();
									try {
										logWriter.write(timeStamp + " " + selection + " " + vendingMachine.getItemName(selection)+ " $" + priorBalance +" $" + logString + "\n");
										logWriter.flush();
									} catch (IOException e) {
										System.out.println("IO Exception");
									}

									System.out.println(vendingMachine.getSoundEffect(selection));
									System.out.println("Current Money Provided: $" + BigDecimal.valueOf((vendingMachine.getCurrentBalance())).movePointLeft(2));
									priorBalance = BigDecimal.valueOf((vendingMachine.getCurrentBalance())).movePointLeft(2).toString();
									choice1 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);	
								}
							}
						}
						if(choice1.equals(FINISH_TRANSACTION)) {
							System.out.println(vendingMachine.getChange(vendingMachine.getCurrentBalance()));
							System.out.println("Current Money Provided: $" + BigDecimal.valueOf((vendingMachine.getCurrentBalance())).movePointLeft(2));
							String logString = BigDecimal.valueOf((vendingMachine.getCurrentBalance())).movePointLeft(2).toString();
							try {
								logWriter.write(timeStamp + " " + "GIVE CHANGE " + "$ " + priorBalance + " $" + logString + "\n");
								logWriter.flush();
							} catch (IOException e) {
								System.out.println("IO Exception");
							}
							System.exit(0);
						}
					} 
				}
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
		VendingMachine vendingMachine = new VendingMachine();
	}


}
