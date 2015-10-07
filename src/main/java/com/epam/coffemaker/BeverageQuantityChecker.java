package com.epam.coffemaker;

public interface BeverageQuantityChecker {
    boolean canBeServed(DrinkType drink);
    void restock(int ammountOfWater);
}
