package com.epam.coffemaker;

public class CoffeeMachine implements EmailNotifier, BeverageQuantityChecker {

    private DrinkMaker drinkMaker;
    private MoneyEngine moneyEngine;
    private ReportEngine reportEngine;
    private int water;
    
    public CoffeeMachine(DrinkMaker drinkMaker, MoneyEngine moneyEngine, ReportEngine reportEngine, int water){
        this.drinkMaker = drinkMaker;
        this.moneyEngine = moneyEngine;
        this.reportEngine = reportEngine;
        this.water = water;
    }
    
    public void translateMessage(DrinkType drinkType, int sugar, boolean extraHot, float cash) {
        if(canBeServed(drinkType) && moneyEngine.isEnough(drinkType, cash)){
            drinkMaker.setReceviedCommand(buildCommand(drinkType, sugar, extraHot));
            water -= drinkType.getWaterNeeded();
            reportEngine.addDrink(drinkType);
        }
        else if(!canBeServed(drinkType)){
            notifyMissingDrink("WATER IS MISSING!");
            sendMessage("Not Enough Water. Sorry");
        }
        else
            sendMessage("Not Enough Money. Missing: " +  String.format("%.2f", moneyEngine.missing(drinkType, cash)) );
    }
    
    private String buildCommand(DrinkType drinkType, int sugar, boolean extraHot){
        return drinkType.toString() + (extraHot ? "h" : "") + ":" + (sugar == 0 ? "" : sugar) + ":" + (sugar > 0 ? "0" : "");
    }
    
    private void sendMessage(String message){
        drinkMaker.setReceviedCommand("M:" + message);
    }

    @Override
    public void notifyMissingDrink(String message) {
        //NOTIFY
    }

    @Override
    public boolean canBeServed(DrinkType drink) {
        return drink.getWaterNeeded() < water;
    }

    @Override
    public void restock(int ammountOfWater) {
        this.water+=ammountOfWater;
    }
}
