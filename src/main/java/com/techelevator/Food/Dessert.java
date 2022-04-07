package com.techelevator.Food;

import java.math.BigDecimal;

public class Dessert extends Item{

    public Dessert(String name, BigDecimal price, String category) {
        super(name, price, category);
    }

    @Override
    public void printPhrase(){

        System.out.println("Sugar, Sugar, so Sweet!");
    }
}
