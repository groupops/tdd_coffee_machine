package com.epam.training;

import org.junit.Test;

/**
 * Created by Dmytro_Ulanovych on 10/7/2015.
 */
public class CoffeeMachineTest {

    @Test(expected = IllegalCoffeeMakerCommandException.class)
    public void exceptionIfDrinkSpecifiedWrong() {
        CoffeeMachine maker = new CoffeeMachine();

        maker.make("JSSSA", 0D);
    }

    @Test(expected = IllegalCoffeeMakerCommandException.class)
    public void whenAskingMoreThenTwoSugar() {
        CoffeeMachine maker = new CoffeeMachine();

        maker.make("T:3:0", 0D);
    }

    @Test(expected = IllegalCoffeeMakerCommandException.class)
    public void whenInvalidSticksCommand() {
        CoffeeMachine maker = new CoffeeMachine();

        maker.make("C:2:2", 0D);
    }

    @Test(expected = IllegalCoffeeMakerCommandException.class)
    public void stickMustBeSpecifiedWhenSugarPresent() {
        CoffeeMachine maker = new CoffeeMachine();

        maker.make("C:2:", 0D);
    }
}


