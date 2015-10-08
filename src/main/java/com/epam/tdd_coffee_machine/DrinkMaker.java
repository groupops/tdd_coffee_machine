package com.epam.tdd_coffee_machine;

import java.math.BigDecimal;

public class DrinkMaker {

  private Screen screen;

  public DrinkMaker(Screen screen) {
    this.screen = screen;
  }

  public void sendMessage(Message message){
    screen.setMessage(message);
  }

  public boolean isEnoughMoneyFor(Beverage beverage, BigDecimal clientMoney) {
    boolean isEnoughMoney;
    BigDecimal priceOfBeverage = beverage.getPrice();
    int comparison = clientMoney.compareTo(priceOfBeverage);

    if (comparison >= 0) {
      isEnoughMoney = true;
    } else {
      isEnoughMoney = false;
      notifyAboutNotEnoughMoney(clientMoney, priceOfBeverage);
    }
    return isEnoughMoney;
  }

  private void notifyAboutNotEnoughMoney(BigDecimal clientMoney,
                                         BigDecimal priceOfBeverage) {
    BigDecimal missingValue = priceOfBeverage.subtract(clientMoney);
    BigDecimal missingValueFormatted =
        missingValue.setScale(2, BigDecimal.ROUND_HALF_UP);
    Message message =
        new Message(
            "You have given not enough money for this drink. " +
                missingValueFormatted + " euro is missing.");
    sendMessage(message);
  }

}
