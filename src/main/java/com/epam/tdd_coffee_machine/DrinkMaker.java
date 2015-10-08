package com.epam.tdd_coffee_machine;

public class DrinkMaker {

  private Screen screen;

  public DrinkMaker(Screen screen) {
    this.screen = screen;
  }

  public void forwardMessage(Message message){
    screen.setMessage(message);
  }

}
