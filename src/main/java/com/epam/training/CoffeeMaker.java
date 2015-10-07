package com.epam.training;

/**
 * Created by Dmytro_Ulanovych on 10/7/2015.
 */
public class CoffeeMaker {
    public void make(String command) {
        String typeOfCommand = command.substring(0, 1);
        if (!"THCM".contains(typeOfCommand)) {
            throw new IllegalArgumentException("Unknow command!");
        }
    }
}
