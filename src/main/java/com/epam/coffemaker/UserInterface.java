package com.epam.coffemaker;

public interface UserInterface {

    public void makeDrink(DrinkType drinkType, float cash);
    public void makeDrink(DrinkType drinkType, int sugar, float cash);
    public void makeDrink(DrinkType drinkType, boolean extraHot, float cash);
    public void makeDrink(DrinkType drinkType, int sugar, boolean extraHot, float cash);
}
