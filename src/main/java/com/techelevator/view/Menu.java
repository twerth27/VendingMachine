package com.techelevator.view;

import com.techelevator.Food.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {

  private Map<String, Item> mapOfCateringItems = new TreeMap<>();

    public  Map<String, Item> getMapOfCateringItems() {
        return mapOfCateringItems;
    }

    public void createCateringList() {

        String fileName = "catering.csv";
        File cateringItems = new File(fileName);

        try (Scanner fileReader = new Scanner(cateringItems)) {

            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();
                String[] columns = line.split(",");

                String location = columns[0];
                String itemName = columns[1];
                String category = columns[2];
                BigDecimal itemPrice = new BigDecimal(columns[3]);

                if (category.equals("Munchy")) {

                    Munchies munchy = new Munchies(itemName, itemPrice, category);
                    mapOfCateringItems.put(location, munchy);
                } else if (category.equals("Dessert")) {

                    Dessert dessert = new Dessert(itemName, itemPrice, category);
                    mapOfCateringItems.put(location, dessert);
                } else if (category.equals("Drink")) {

                    Drink drink = new Drink(itemName, itemPrice, category);
                    mapOfCateringItems.put(location, drink);
                } else if (category.equals("Sandwich")) {

                    Sandwich sandwich = new Sandwich(itemName, itemPrice, category);
                    mapOfCateringItems.put(location, sandwich);
                }
            }
        } catch (FileNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }
}
