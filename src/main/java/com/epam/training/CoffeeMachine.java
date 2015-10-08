package com.epam.training;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.training.Drink.*;

/**
 * Created by Dmytro_Ulanovych on 10/7/2015.
 */
public class CoffeeMachine {
    private static final Pattern COMMAND_PATTERN = Pattern.compile("(^[THC][h]?:[1-2]?:[0]?)|([M]:.+)|(O::)");
    private static final Pattern DRINK_PATTERN = Pattern.compile("(^[THC][h]?:[1-2]?:[0]?)|(O::)");
    private double earnedMoney;
    private final Map<Drink, Integer> soldDrinks = new HashMap<>();


    public void make(String command, Double money) {
        checkIfCommandValid(command);

        if (isDrink(command)) {
            checkSugarAndStickRelation(command);
            Drink drink = getDrinkFromCommand(command);
            if (drink.getPrice() > money) {
                throw new NotEnoughMoneyException(String.format("Provided need to provide %f to make selected drink.", drink.getPrice() - money));
            }
            sellDrink(drink);
        }
    }

    private boolean isDrink(String command) {
        return DRINK_PATTERN.matcher(command).matches();
    }

    private void checkIfCommandValid(String command) {
        Matcher matcher = COMMAND_PATTERN.matcher(command);
        if (!matcher.matches()) {
            throw new IllegalCoffeeMakerCommandException("Message Format Is Wrong");
        }
    }

    private void checkSugarAndStickRelation(String command) {
        String[] orderElements = command.split(":");
        Integer sugarCount = orderElements.length > 1 ? Integer.parseInt(orderElements[1]) : 0;
        if (sugarCount > 0 && orderElements.length < 3) {
            throw new IllegalCoffeeMakerCommandException("You must specify stick when order sugar!");
        }
    }

    private Drink getDrinkFromCommand(String command) {
        String drinkName = command.substring(0, 1);
        return drinkName.equals("C") ? COFFEE : (drinkName.equals("H") ? CHOCOLATE : (drinkName.equals("O") ? ORANGE_JUICE : TEA));
    }

    private void sellDrink(Drink drink) {
        int alreadySold = 0;
        if (soldDrinks.containsKey(drink)) {
            alreadySold = soldDrinks.get(drink);
        }
        alreadySold++;
        soldDrinks.put(drink, alreadySold);
        earnedMoney += drink.getPrice();
    }


    public double getEarnedMoney() {
        return earnedMoney;
    }

    public int getSoldDrinksCount(Drink drink) {
        return soldDrinks.containsKey(drink) ? soldDrinks.get(drink) : 0;
    }
}
