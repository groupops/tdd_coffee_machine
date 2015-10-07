package com.epam.coffemaker;

public class Pad implements UserInterface {

    private CoffeeMachine messageTranslator;

    public Pad(CoffeeMachine messageTranslator) {
        this.messageTranslator = messageTranslator;
    }

    public void makeDrink(DrinkType drinkType, float cash) {
        messageTranslator.translateMessage(drinkType, 0, false, cash);
    }

    public void makeDrink(DrinkType drinkType, int sugar, float cash) {
        messageTranslator.translateMessage(drinkType, sugar, false, cash);
    }

    public void makeDrink(DrinkType drinkType, boolean extraHot, float cash) {
        messageTranslator.translateMessage(drinkType, 0, extraHot, cash);
    }
    
    public void makeDrink(DrinkType drinkType, int sugar, boolean extraHot, float cash) {
        messageTranslator.translateMessage(drinkType, sugar, extraHot, cash);
    }


}
