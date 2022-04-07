package com.techelevator.Food;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ItemTest {
    BigDecimal testPrice = new BigDecimal("5.50");
    Item item;

    @Before
    public void setup(){
        item = new Munchies("TestName", testPrice, "Munchy");
    }


    @Test
    public void dispense_whenQuantityIsGreaterThan0_decreaseQuantityBy1() {
        int actualQuantity = item.getQuantity();
        int expectedQuantity = 6;
        String message = "Quantity did not decrease by 1";

        //act
        item.dispense();
        actualQuantity = item.getQuantity();

        //assert
        assertEquals(message, actualQuantity, expectedQuantity);
    }

    @Test
    public void dispense_whenQuantityIs0_printNotAvailable() {
        int actualQuantity = item.getQuantity();
        int expectedQuantity = 0;
        String expectedOutput = "NO LONGER AVAILABLE";
        String message = "Quantity should not change when the item is out of stock";

        //act
        while (actualQuantity > 0){
            item.dispense();
            actualQuantity = item.getQuantity();
        }

        item.dispense();
        actualQuantity = item.getQuantity();

        //assert
        assertEquals(message, actualQuantity, expectedQuantity);
    }
}
