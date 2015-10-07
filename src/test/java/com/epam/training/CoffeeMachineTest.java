package com.epam.training;

import org.junit.Test;

/**
 * Created by Dmytro_Ulanovych on 10/7/2015.
 */
public class CoffeeMachineTest {
    private final CoffeeMachine maker = new CoffeeMachine();


    @Test(expected = IllegalCoffeeMakerCommandException.class)
    public void exceptionIfDrinkSpecifiedWrong() {
        maker.make("JSSSA", 0D);
    }

    @Test(expected = IllegalCoffeeMakerCommandException.class)
    public void whenAskingMoreThenTwoSugar() {
        maker.make("T:3:0", 0D);
    }

    @Test(expected = IllegalCoffeeMakerCommandException.class)
    public void whenInvalidSticksCommand() {
        maker.make("C:2:2", 0D);
    }

    @Test(expected = IllegalCoffeeMakerCommandException.class)
    public void stickMustBeSpecifiedWhenSugarPresent() {
        maker.make("C:2:", 0D);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void whenGivenNotEnoughMoneyForCoffee(){
        maker.make("C:1:0", 0.3);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void whenGivenNotEnoughMoneyForChocolate(){
        maker.make("H:1:0", 0.4);
    }
}


