package com.techelevator.Food;

import java.math.BigDecimal;

public abstract class Item {
    private String name;
    private String category ;
    BigDecimal price;
    private int quantity;

    public Item(String name, BigDecimal price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = 7;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString(){
        String template = "%s $%.2f %s %s";
        return String.format(template,getName(), getPrice() ,getCategory(), getQuantity());
    }

    public void dispense(){
        if (quantity > 0){
            quantity = quantity-1;
            this.printPhrase();

        }else{
            System.out.println("NO LONGER AVAILABLE");
        }

    }

    public abstract void printPhrase();
}
