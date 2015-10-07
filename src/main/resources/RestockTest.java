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

public class RestockTest {

    private static final float ORANGE_JUICE_PRICE = DrinkType.ORANGE_JUICE.getPrice();

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
    public void notEnoughWater() {
        pad.makeDrink(DrinkType.ORANGE_JUICE, ORANGE_JUICE_PRICE);
        pad.makeDrink(DrinkType.ORANGE_JUICE, ORANGE_JUICE_PRICE);
        pad.makeDrink(DrinkType.ORANGE_JUICE, ORANGE_JUICE_PRICE);
        pad.makeDrink(DrinkType.ORANGE_JUICE, ORANGE_JUICE_PRICE);
        assertEquals("Not Enough Water. Sorry", screen.getMessage());
    }

    @Test
    @Ignore
    public void notEnoughWaterNotificationSent() {

        CoffeeMachine coffeeMachine = Mockito.mock(CoffeeMachine.class);
        Mockito.when(coffeeMachine.canBeServed(DrinkType.CHOCOLATE)).thenReturn(false);

        coffeeMachine.translateMessage(DrinkType.CHOCOLATE, 0, false, 0.8f);
        Mockito.verify(coffeeMachine).notifyMissingDrink("WATER IS MISSING!");
    }

    @Test
    public void notEnoughWaterWithRestock() {
        pad.makeDrink(DrinkType.ORANGE_JUICE, ORANGE_JUICE_PRICE);
        pad.makeDrink(DrinkType.ORANGE_JUICE, ORANGE_JUICE_PRICE);
        pad.makeDrink(DrinkType.ORANGE_JUICE, ORANGE_JUICE_PRICE);
        assertEquals("Not Enough Water. Sorry", screen.getMessage());
        coffeeMachine.restock(1000);
        pad.makeDrink(DrinkType.ORANGE_JUICE, ORANGE_JUICE_PRICE);
        assertEquals("O::", drinkMaker.getReceviedCommand());
    }
}
