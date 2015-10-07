import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.coffemaker.CoffeeMachine;
import com.epam.coffemaker.DrinkMaker;
import com.epam.coffemaker.DrinkType;
import com.epam.coffemaker.MoneyEngine;
import com.epam.coffemaker.Pad;
import com.epam.coffemaker.ReportEngine;
import com.epam.coffemaker.Screen;

public class TestCoffeeMaker {

    private static final float TEA_PRICE = DrinkType.TEA.getPrice();
    private static final float COFFEE_PRICE = DrinkType.COFFEE.getPrice();
    private static final float CHOCOLATE_PRICE = DrinkType.CHOCOLATE.getPrice();
    private static final float ORANGE_JUICE_PRICE = DrinkType.ORANGE_JUICE.getPrice();
    private static final String NOT_ENOUGH_MONEY_MESSAGE = "Not Enough Money. Missing: ";

    private static Pad pad;
    private static DrinkMaker drinkMaker;
    private static Screen screen;
    private static ReportEngine reportEngine;
    private static CoffeeMachine coffeeMachine;

    @BeforeClass
    public static void preparePadAndDrinkMaker() {
        screen = new Screen();
        drinkMaker = new DrinkMaker(screen);
        MoneyEngine moneyEngine = new MoneyEngine();
        reportEngine = new ReportEngine();
        coffeeMachine = new CoffeeMachine(drinkMaker, moneyEngine, reportEngine, 1000);
        pad = new Pad(coffeeMachine);

    }

    @After
    public void clearReportData() {
        reportEngine.clear();
        coffeeMachine.restock(1000);
    }

    @Test
    public void makeCoffeeWithoutSugar() {
        pad.makeDrink(DrinkType.COFFEE, COFFEE_PRICE);
        assertEquals("C::", drinkMaker.getReceviedCommand());
    }

    @Test
    public void makeCoffeeWithOneSugar() {
        pad.makeDrink(DrinkType.COFFEE, 1, COFFEE_PRICE);
        assertEquals("C:1:0", drinkMaker.getReceviedCommand());
    }

    @Test
    public void makeCoffeeWithTwoSugar() {
        pad.makeDrink(DrinkType.COFFEE, 2, COFFEE_PRICE);
        assertEquals("C:2:0", drinkMaker.getReceviedCommand());
    }

    @Test
    public void makeTeaWithoutSugar() {
        pad.makeDrink(DrinkType.TEA, TEA_PRICE);
        assertEquals("T::", drinkMaker.getReceviedCommand());
    }

    @Test
    public void makeTeaWithOneSugar() {
        pad.makeDrink(DrinkType.TEA, 1, TEA_PRICE);
        assertEquals("T:1:0", drinkMaker.getReceviedCommand());
    }

    @Test
    public void makeTeaWithTwoSugar() {
        pad.makeDrink(DrinkType.TEA, 2, TEA_PRICE);
        assertEquals("T:2:0", drinkMaker.getReceviedCommand());
    }

    @Test
    public void makeChocolateWithoutSugar() {
        pad.makeDrink(DrinkType.CHOCOLATE, CHOCOLATE_PRICE);
        assertEquals("H::", drinkMaker.getReceviedCommand());
    }

    @Test
    public void makeChocolateWithOneSugar() {
        pad.makeDrink(DrinkType.CHOCOLATE, 1, CHOCOLATE_PRICE);
        assertEquals("H:1:0", drinkMaker.getReceviedCommand());
    }

    @Test
    public void makeChocolateWithTwoSugar() {
        pad.makeDrink(DrinkType.CHOCOLATE, 2, CHOCOLATE_PRICE);
        assertEquals("H:2:0", drinkMaker.getReceviedCommand());
    }

    @Test
    public void makeCoffeeWithTwoSugarAndNotEnoughCashTestMessage() {
        pad.makeDrink(DrinkType.COFFEE, 2, 0.2f);
        assertEquals(NOT_ENOUGH_MONEY_MESSAGE + "0,40", screen.getMessage());
    }

    @Test
    public void makeTeaWithTwoSugarAndNotEnoughCashTestMessage() {
        pad.makeDrink(DrinkType.TEA, 2, 0.3f);
        assertEquals(NOT_ENOUGH_MONEY_MESSAGE + "0,10", screen.getMessage());
    }

    @Test
    public void makeChocolateWithTwoSugarAndNotEnoughCashTestMessage() {
        pad.makeDrink(DrinkType.CHOCOLATE, 2, 0.1f);
        assertEquals(NOT_ENOUGH_MONEY_MESSAGE + "0,40", screen.getMessage());
    }

    @Test
    public void makeOrangeJuice() {
        pad.makeDrink(DrinkType.ORANGE_JUICE, ORANGE_JUICE_PRICE);
        assertEquals("O::", drinkMaker.getReceviedCommand());
    }

    @Test
    public void makeOrangeJuiceNotEnoughMoney() {
        pad.makeDrink(DrinkType.ORANGE_JUICE, 2, 0.1f);
        assertEquals(NOT_ENOUGH_MONEY_MESSAGE + "0,50", screen.getMessage());
    }

    @Test
    public void makeHotChocolate() {
        pad.makeDrink(DrinkType.CHOCOLATE, true, CHOCOLATE_PRICE);
        assertEquals("Hh::", drinkMaker.getReceviedCommand());
    }

    @Test
    public void makeHotCoffee() {
        pad.makeDrink(DrinkType.COFFEE, true, COFFEE_PRICE);
        assertEquals("Ch::", drinkMaker.getReceviedCommand());
    }

    @Test
    public void makeHotTea() {
        pad.makeDrink(DrinkType.TEA, true, TEA_PRICE);
        assertEquals("Th::", drinkMaker.getReceviedCommand());
    }

    @Test
    public void printingReportWithNoValues() {
        assertEquals("C:0\nT:0\nH:0\nO:0\nMONEY:0,00", reportEngine.getReport());
    }

    @Test
    public void printingReportWithPartData() {
        pad.makeDrink(DrinkType.TEA, TEA_PRICE);
        pad.makeDrink(DrinkType.TEA, TEA_PRICE);
        pad.makeDrink(DrinkType.CHOCOLATE, CHOCOLATE_PRICE);

        float price = 2 * TEA_PRICE + CHOCOLATE_PRICE;

        assertEquals("C:0\nT:2\nH:1\nO:0\nMONEY:" + String.format("%.2f", price), reportEngine.getReport());
    }

    @Test
    public void printingReportWithFullData() {
        pad.makeDrink(DrinkType.TEA, TEA_PRICE);
        pad.makeDrink(DrinkType.TEA, TEA_PRICE);
        pad.makeDrink(DrinkType.CHOCOLATE, CHOCOLATE_PRICE);
        pad.makeDrink(DrinkType.COFFEE, COFFEE_PRICE);
        pad.makeDrink(DrinkType.COFFEE, COFFEE_PRICE);
        pad.makeDrink(DrinkType.COFFEE, COFFEE_PRICE);
        pad.makeDrink(DrinkType.COFFEE, COFFEE_PRICE);
        pad.makeDrink(DrinkType.ORANGE_JUICE, ORANGE_JUICE_PRICE);
        pad.makeDrink(DrinkType.ORANGE_JUICE, ORANGE_JUICE_PRICE);
        pad.makeDrink(DrinkType.ORANGE_JUICE, ORANGE_JUICE_PRICE);

        float price = 2 * TEA_PRICE + CHOCOLATE_PRICE + 4 * COFFEE_PRICE + 3 * ORANGE_JUICE_PRICE;

        assertEquals("C:4\nT:2\nH:1\nO:3\nMONEY:" + String.format("%.2f", price), reportEngine.getReport());
    }
}
