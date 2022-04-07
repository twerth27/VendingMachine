package com.techelevator;

import com.techelevator.view.Menu;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CaTEringCapstoneCLITest {



    @Test //dispense correct amount
    public void getChange_givenAmount_givesBackCorrectDenominations(){
        Menu testMenu = new Menu();
        CaTEringCapstoneCLI test = new CaTEringCapstoneCLI(testMenu) ;

        //arrange
        BigDecimal testTotal = new BigDecimal("4.65");
        String message = "Incorrect amount of change denomination returned";

        //act
        int[] changeAmounts = test.getChange(testTotal);

        //assert
        assertEquals(message, changeAmounts[0], 4);
        assertEquals(message, changeAmounts[1], 2);
        assertEquals(message, changeAmounts[2], 1);
        assertEquals(message, changeAmounts[3], 1);
    }

    @Test //dispense correct amount
    public void getChange_ifChangeis0_noChangeGiven(){
        Menu testMenu = new Menu();
        CaTEringCapstoneCLI test = new CaTEringCapstoneCLI(testMenu) ;

        //arrange
        BigDecimal testTotal = new BigDecimal("0");
        String message = "No change should be given back";

        //act
        int[] changeAmounts = test.getChange(testTotal);

        //assert
        assertEquals(message, changeAmounts[0], 0);
        assertEquals(message, changeAmounts[1], 0);
        assertEquals(message, changeAmounts[2], 0);
        assertEquals(message, changeAmounts[3], 0);
    }

//    @Test
//    public void getItemSelected_ifSelectionIsNull_doNothing(){
//        Menu testMenu = new Menu();
//        CaTEringCapstoneCLI test = new CaTEringCapstoneCLI(testMenu);
//        String selection = null;
//
//        //act
//        test.getItemSelected(selection);
//
//        //assert that the map doesn't change
//        assertNull();
//    }

}
