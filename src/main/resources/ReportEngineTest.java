import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.After;

import com.epam.coffemaker.DrinkType;
import com.epam.coffemaker.ReportEngine;

public class ReportEngineTest {

    private static ReportEngine reportEngine;

    @BeforeClass
    public static void createReportEngine() {
        reportEngine = new ReportEngine();
    }

    @After
    public void clearReportData() {
        reportEngine.clear();
    }

    @Test
    public void addOneTea() {
        reportEngine.addDrink(DrinkType.TEA);

        assertEquals("C:0\nT:1\nH:0\nO:0\nMONEY:" + String.format("%.2f", DrinkType.TEA.getPrice()),
                reportEngine.getReport());
    }

    @Test
    public void addManyDrinks() {
        reportEngine.addDrink(DrinkType.TEA);
        reportEngine.addDrink(DrinkType.CHOCOLATE);
        reportEngine.addDrink(DrinkType.COFFEE);
        reportEngine.addDrink(DrinkType.COFFEE);
        reportEngine.addDrink(DrinkType.TEA);

        float price = DrinkType.TEA.getPrice() * 2 + DrinkType.COFFEE.getPrice() * 2 + DrinkType.CHOCOLATE.getPrice();

        assertEquals("C:2\nT:2\nH:1\nO:0\nMONEY:" + String.format("%.2f", price), reportEngine.getReport());
    }
}
