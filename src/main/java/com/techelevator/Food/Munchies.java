package com.techelevator.Food;

import java.math.BigDecimal;

public class Munchies extends Item{

    public Munchies(String name, BigDecimal price, String category)
    {
        super(name, price, category);
    }

    @Override
    public void printPhrase(){

        System.out.println("Munchy, Munchy, so Good!");
    }
}
