package com.epam.training;

/**
 * Created by Dmytro_Ulanovych on 10/7/2015.
 */
public enum Drink {
    COFFEE(0.4),
    CHOCOLATE(0.5),
    TEA(0.6);

    private double price;

    Drink(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
