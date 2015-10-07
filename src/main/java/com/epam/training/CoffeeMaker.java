package com.epam.training;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmytro_Ulanovych on 10/7/2015.
 */
public class CoffeeMaker {
    private static final Pattern COMMAND_PATTERN = Pattern.compile("(^[THC]:[1-2]?:[0]?)|([M]:.+)");

    public void make(String command) {
        Matcher matcher = COMMAND_PATTERN.matcher(command);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Message Format Is Wrong");
        }

    }

    private boolean isDrink(String command) {
        return "THC".contains(command) && command.length() == 1;
    }

    private boolean isMessage(String command) {
        return command.equals("M");
    }
}
