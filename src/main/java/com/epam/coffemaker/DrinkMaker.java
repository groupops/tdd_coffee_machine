package com.epam.coffemaker;

public class DrinkMaker {

    private String receviedCommand;
    private Screen screen;

    public DrinkMaker(Screen screen){
        this.screen = screen;
    }
    
    public String getReceviedCommand() {
        return receviedCommand;
    }

    public void setReceviedCommand(String receviedCommand) {
        this.receviedCommand = receviedCommand;
        if(receviedCommand.startsWith("M"))
            forwardMessage(receviedCommand);
        
    }
    
    private void forwardMessage(String message){
        screen.setMessage(message.substring(2));
    }

}
