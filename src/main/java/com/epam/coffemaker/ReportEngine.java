package com.epam.coffemaker;

import java.util.HashMap;

public class ReportEngine {

    private HashMap<DrinkType, Integer> data = new HashMap<DrinkType, Integer>();

    public String getReport() {
        return "C:" + data.getOrDefault(DrinkType.COFFEE, 0)
             + "\nT:" + data.getOrDefault(DrinkType.TEA, 0)
             + "\nH:" + data.getOrDefault(DrinkType.CHOCOLATE, 0)
             + "\nO:" + data.getOrDefault(DrinkType.ORANGE_JUICE, 0)
             + "\nMONEY:" + String.format("%.2f", calculateMoney());
    }

    public void addDrink(DrinkType drink) {
        int counter = data.getOrDefault(drink, 0);
        if(data.containsKey(drink))
            data.replace(drink, ++counter);
        else
            data.put(drink, ++counter);
        //data.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
    }
    
    public void clear(){
        data = new HashMap<DrinkType, Integer>();
    }
    
    private float calculateMoney(){
        float counter = 0;
        
        for (HashMap.Entry<DrinkType, Integer> entry : data.entrySet())
        {
            counter += entry.getValue() * entry.getKey().getPrice();
        }
        
        return counter;
    }
    
}
