package com.epam.tdd_coffee_machine;

public class Screen {

  private Message message;

  public String getMessage() {
    return message.getContent();
  }

  public void setMessage(Message message) {
    this.message = message;
  }
}
