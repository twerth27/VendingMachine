package com.techelevator;

import com.techelevator.Food.Item;
import com.techelevator.Log.AuditLog;
import com.techelevator.ui.UserInput;
import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Map;

public class CaTEringCapstoneCLI {

	private Menu menu;
	private BigDecimal totalMoney = new BigDecimal("0");
	AuditLog auditLog = new AuditLog();

	public CaTEringCapstoneCLI(Menu menu) {
		this.menu = menu;
	}


	public static void main(String[] args) {
		Menu menu = new Menu();
		CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
		menu.createCateringList();
		cli.run();
	}

	public void run() {

		while (true) {

			String homePageChoice = UserInput.getHomePage();

			if(homePageChoice.equals("d")){
				printItem();
			}
			else if(homePageChoice.equals("p")){
				while(true) {
					String purchasePageChoice = UserInput.getPurchasePage(totalMoney);
					if (purchasePageChoice.equals("m")) {

						BigDecimal dollarsGiven = UserInput.addMoreMoney();
						totalMoney = totalMoney.add(dollarsGiven);
						auditLog.feedMoneyAudit(dollarsGiven,totalMoney);
					}
					else if (purchasePageChoice.equals("s")) {
						printItem();
						String selection = UserInput.selectAnItem();
						getItemSelected(selection);
					}
					else if (purchasePageChoice.equals("f")) {
						auditLog.changeAudit(totalMoney);
						int[] changeGiven = getChange(totalMoney);
						//pass array of change denom's to print method
						printChangeDenominations(changeGiven);
						totalMoney = new BigDecimal(0);
						break;
					}
				}
			}
			else {
				return;
			}
		}
	}

	private void printItem() {

		Map<String, Item> list = menu.getMapOfCateringItems();

		for (Map.Entry<String, Item> itemEntry : list.entrySet()) {

			System.out.println(itemEntry.getKey()+ " " + itemEntry.getValue().toString());
		}
	}

	public void getItemSelected(String selection){
		Map<String, Item> list = menu.getMapOfCateringItems();
		Item chosenItem = list.get(selection);

		if (chosenItem != null) {
			if (chosenItem.getPrice().doubleValue() < totalMoney.doubleValue()) {

				chosenItem.dispense();
				BigDecimal dollarsGiven = totalMoney;
				totalMoney = totalMoney.subtract(chosenItem.getPrice());
				auditLog.transactionAudit(dollarsGiven, totalMoney, chosenItem, selection);
			}
			else {

				System.out.println("Please feed me money.");
			}
		}
		else{

			System.out.println("Invalid selection. Please choose another item.");
		}
	}

	public int[] getChange(BigDecimal totalMoney) {
		int[] changeGiven = new int[4];
		int dollarCount = 0;
		int quarterCount = 0;
		int dimeCount = 0;
		int nickelCount = 0;

		while (totalMoney.doubleValue() != 0) {

			if (totalMoney.doubleValue() >= 1) {

				totalMoney = totalMoney.subtract(BigDecimal.valueOf(1));
				dollarCount += 1;
			} else if (totalMoney.doubleValue() >= .25) {

				totalMoney = totalMoney.subtract(BigDecimal.valueOf(.25));
				quarterCount += 1;
			} else if (totalMoney.doubleValue() >= .10) {

				totalMoney = totalMoney.subtract(BigDecimal.valueOf(.10));
				dimeCount += 1;
			} else if (totalMoney.doubleValue() >= .05) {

				totalMoney = totalMoney.subtract(BigDecimal.valueOf(.05));
				nickelCount += 1;
			}
		}

		changeGiven[0] = dollarCount;
		changeGiven[1] = quarterCount;
		changeGiven[2] = dimeCount;
		changeGiven[3] = nickelCount;

		return changeGiven;
	}

	public void printChangeDenominations(int[] changeGiven){
		System.out.println();
		System.out.println("Here's your change!");
		System.out.println("Dollar(s): " + changeGiven[0]);
		System.out.println("Quarter(s): " + changeGiven[1]);
		System.out.println("Dime(s): " + changeGiven[2]);
		System.out.println("Nickel(s): " + changeGiven[3]);
		System.out.println();
		System.out.println("**************************************");
		System.out.println("Thank you for being a valued customer!");
		System.out.println("**************************************");
		System.out.println();


	}
}
