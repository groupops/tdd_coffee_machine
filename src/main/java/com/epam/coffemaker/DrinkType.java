package com.epam.coffemaker;

public enum DrinkType {
    COFFEE("C", 0.6f, 200), TEA("T", 0.4f, 250), CHOCOLATE("H", 0.5f, 220), ORANGE_JUICE("O", 0.6f, 400);
    
    private final String letter;
    private final float price;
    private final int waterNeeded;
    
    private DrinkType(final String letter, final float price, final int waterNeeded) {
        this.letter = letter;
        this.price = price;
        this.waterNeeded = waterNeeded;
    }
    
    @Override
    public String toString(){
        return letter;
    }

    public float getPrice() {
        return price;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }
    
}
