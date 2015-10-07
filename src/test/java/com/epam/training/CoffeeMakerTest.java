package com.epam.training;

import org.junit.Test;

/**
 * Created by Dmytro_Ulanovych on 10/7/2015.
 */
public class CoffeeMakerTest {

    @Test(expected =  IllegalArgumentException.class)
    public void commandShouldStartsWithFirstLetterOfDrink() {
        CoffeeMaker maker = new CoffeeMaker();

        maker.make("JSSSA");
    }
}
