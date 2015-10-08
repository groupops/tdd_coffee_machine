package com.epam.tdd_coffee_machine;

public class Message {

  private String content;

  public Message(String content) {
    this.content = content;
  }

  public String getContent() {
    return new StringBuilder()
        .append("M")
        .append(":")
        .append(content)
        .toString();
  }

}
