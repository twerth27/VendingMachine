package com.techelevator.Food;

import java.math.BigDecimal;

public class Sandwich extends Item{

    public Sandwich(String name, BigDecimal price, String category) {
        super(name, price, category);
    }

    @Override
    public void printPhrase(){

        System.out.println("Sandwich So Delicious, Yum!");
    }
}
