package com.epam.training;

import org.junit.Test;

import static com.epam.training.Drink.COFFEE;
import static com.epam.training.Drink.TEA;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

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
    public void whenGivenNotEnoughMoneyForCoffee() {
        maker.make("C:1:0", 0.3);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void whenGivenNotEnoughMoneyForChocolate() {
        maker.make("H:1:0", 0.4);
    }

    @Test
    public void shouldBeAbleToOrderOrangeJuice() {
        maker.make("O::", 1D);
    }

    @Test
    public void shouldBeAbleToOrderExtraHotDrink() {
        maker.make("Ch:1:0", 1D);
        maker.make("Hh:1:0", 1D);
        maker.make("Th:1:0", 1D);
    }

    @Test(expected = IllegalCoffeeMakerCommandException.class)
    public void whenOrderingOrangeWithSugar() {
        maker.make("O:1:)", 1D);
    }

    @Test
    public void whenOrangeJuiceAndTwoTeaOrdered() {
        makeOrangeJuice(1);
        makeTea(2);

        assertThat(maker.getEarnedMoney(), equalTo(0.6 * 3));
    }

    @Test
    public void whenMakeFiveCoffeeAndFiveOrangeJuicesThenEarnFiveEuros() {
        makeCoffees(5);
        makeOrangeJuice(5);

        assertThat(maker.getEarnedMoney(), equalTo(5D));
    }

    @Test
    public void checkDailySoldCoffeeStatistic(){
        makeCoffees(100);
        makeOrangeJuice(12);
        makeTea(123);

        assertThat(maker.getSoldDrinksCount(COFFEE), equalTo(100));
    }

    @Test
    public void checkDailySoldTeeStatistic(){
        makeCoffees(100);
        makeOrangeJuice(12);

        assertThat(maker.getSoldDrinksCount(TEA), equalTo(0));
    }









    private void makeTea(int count) {
        for (int i = 0; i < count; i++) {
            maker.make("T:1:0", 0.6);
        }
    }

    private void makeOrangeJuice(int count) {
        for (int i = 0; i < count; i++) {
            maker.make("O::", 0.6);
        }
    }

    private void makeCoffees(int count) {
        for (int i = 0; i < count; i++) {
            maker.make("C:2:0", 0.4);
        }
    }
}


