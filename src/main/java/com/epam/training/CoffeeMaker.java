package com.epam.training;

/**
 * Created by Dmytro_Ulanovych on 10/7/2015.
 */
public class CoffeeMaker {
    public void make(String command) {
        String typeOfCommand = command.substring(0, 1);
        if (!isDrink(typeOfCommand) || !isMessage(typeOfCommand)) {
            throw new IllegalArgumentException("Unknow command!");
        }
    }

    private boolean isDrink(String command) {
        return "THC".contains(command) && command.length() == 1;
    }

    private boolean isMessage(String command) {
        return command.equals("M");
    }
}
