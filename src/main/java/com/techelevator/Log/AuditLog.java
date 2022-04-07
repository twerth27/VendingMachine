package com.techelevator.Log;

import com.techelevator.Food.Item;
import com.techelevator.ui.UserInput;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLog {

    public void feedMoneyAudit(BigDecimal dollarsGiven,BigDecimal totalMoney){
        String path = "Audit.txt";
        File file = new File(path);

        try(FileWriter fileWriter = new FileWriter(file,true);

            PrintWriter writer = new PrintWriter(fileWriter)){
            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss a");
            String formatDateTime = now.format(formatter);
            String moneyFeed = "Money Feed: ";

            String template = "%s %s $%.2f $%.2f";
            String message= String.format(template, formatDateTime, moneyFeed, dollarsGiven, totalMoney);

            writer.println(message);
        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }
    }

    public void transactionAudit(BigDecimal dollarsGiven, BigDecimal totalMoney, Item itemSelected, String selection){
        String path = "Audit.txt";
        File file = new File(path);

        try(FileWriter fileWriter = new FileWriter(file,true);

            PrintWriter writer = new PrintWriter(fileWriter)){
            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss a");
            String formatDateTime = now.format(formatter);
            String itemName = itemSelected.getName();

            String template = "%s %s %s $%.2f $%.2f";
            String message= String.format(template, formatDateTime, itemName, selection, dollarsGiven, totalMoney);

            writer.println(message);

        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }
    }

    public void changeAudit(BigDecimal totalMoney)
    {
        String path = "Audit.txt";
        File file = new File(path);

        try (FileWriter fileWriter = new FileWriter(file, true);
             PrintWriter writer = new PrintWriter(fileWriter)) {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss a");
            String formatDateTime = now.format(formatter);
            String changeGiven = "Change Given: ";

            String template = "%s %s $%.2f $%.2f";
            String message = String.format(template, formatDateTime, changeGiven, totalMoney, 0.00);

            writer.println(message);
        }
        catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }
}
