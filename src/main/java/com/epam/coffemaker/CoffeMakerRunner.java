package com.epam.coffemaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class CoffeMakerRunner {
    private static BufferedReader reader;

    //init
    private static Screen screen = new Screen();
    private static DrinkMaker drinkMaker = new DrinkMaker(screen);
    private static MoneyEngine moneyEngine = new MoneyEngine();
    private static ReportEngine reportEngine = new ReportEngine();
    private static Pad pad = new Pad(new CoffeeMachine(drinkMaker, moneyEngine, reportEngine, 1000));
    
    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        
        do {
            System.out.println("-------------------------------------");
            System.out.print("What do you want to drink: \n" + "[C]offee\n" + "[T]ea\n" + "c[H]ocolate" + "[O]range juince" 
                    + "[P]rint report" + "[q]uit\n" + "Please write your choice and press <Enter>: ");
            try {
                input = reader.readLine();

                if (input.toLowerCase().startsWith("c")) {
                    
                } else if (input.toLowerCase().startsWith("t")) {
                    
                } else if (input.toLowerCase().startsWith("h")) {
                    
                } else if (input.toLowerCase().startsWith("o")) {
                    
                } else if (input.toLowerCase().startsWith("p")) {
                    
                }
            } catch (IOException e) {
                throw new RuntimeException(
                        "If I cannot read from Standard Input then what is life good for :( let's die.", e);
            }
        } while (!input.toLowerCase().startsWith("q")); // quit
    }

}
