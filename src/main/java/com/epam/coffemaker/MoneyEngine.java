package com.epam.coffemaker;

public class MoneyEngine {

    public boolean isEnough(DrinkType drinkType, float cash){
        return drinkType.getPrice() <= cash;
    }
    
    public float missing(DrinkType drinkType, float cash){
        return drinkType.getPrice() - cash;
    }
}
