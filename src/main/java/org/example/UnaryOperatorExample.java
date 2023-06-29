package org.example;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
  public static void main(String[] args) {
    // For operation that return the same type of the parameter
    UnaryOperator<String> unaryOperator = (text) -> text.concat("Default");

    System.out.println(unaryOperator.apply("Hi"));

  }
}
