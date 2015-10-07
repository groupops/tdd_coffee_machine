package com.epam.training;

import org.junit.Test;

/**
 * Created by Dmytro_Ulanovych on 10/7/2015.
 */
public class CoffeeMakerTest {

    @Test(expected = IllegalArgumentException.class)
    public void exceptionIfDrinkSpecifiedWrong() {
        CoffeeMaker maker = new CoffeeMaker();

        maker.make("JSSSA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionWhenSugarIsMoreThen2() {
        CoffeeMaker maker = new CoffeeMaker();

        maker.make("T:3:0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionWhenStickIfMoreThen1(){
        CoffeeMaker maker = new CoffeeMaker();

        maker.make("C:2:2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void stickMustBeSpecifiedWhenSugarPresent(){
        CoffeeMaker maker = new CoffeeMaker();

        maker.make("C:2:");
    }
}


