package com.techelevator.ui;

import com.techelevator.CaTEringCapstoneCLI;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInput
{
    private static Scanner input = new Scanner(System.in);

    public static String getHomePage() {
        System.out.println();
        System.out.println("************************************");
        System.out.println("Welcome to Taste Elevator CaTEring!");
        System.out.println("************************************");
        System.out.println();
        System.out.println("D) Display caTEring Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");
        System.out.println();
        System.out.print("Please enter choice: ");
        String choice = input.nextLine().trim().toLowerCase().substring(0, 1);
        return choice;

    }

    public static String getPurchasePage(BigDecimal money) {
        System.out.println();
        System.out.println("$$$$$$$$$$$$$$$$");
        System.out.println("Purchase Screen");
        System.out.println("$$$$$$$$$$$$$$$$");
        System.out.println();
        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");
        System.out.println();
        System.out.println("Current money provided: $" + money);
        System.out.println();
        System.out.print("Please enter choice: ");
        String choice = input.nextLine().trim().toLowerCase().substring(0, 1);
        return choice;

    }

    public static BigDecimal addMoreMoney(){
        System.out.println();
        System.out.println("Amounts to add");
        System.out.println("$1");
        System.out.println("$2");
        System.out.println("$5");
        System.out.println("$10");
        System.out.println("$20");
        System.out.println();
        System.out.print("Please enter dollar amount choice: ");
        String choice = input.nextLine();

        return new BigDecimal(choice);
    }

    public static String selectAnItem(){
        System.out.println();
        System.out.print("Please chose an item by slot location: ");
        System.out.println();
        String itemChosen = input.nextLine().trim().toUpperCase().substring(0,2);

        return itemChosen;
    }

}
