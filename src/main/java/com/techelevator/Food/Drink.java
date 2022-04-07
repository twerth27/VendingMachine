package com.techelevator.Food;

import java.math.BigDecimal;

public class Drink extends Item{

    public Drink(String name, BigDecimal price, String category) {
        super(name, price, category);
    }

    @Override
    public void printPhrase(){

        System.out.println("Drinky, Drinky, Slurp Slurp!");
    }
}
