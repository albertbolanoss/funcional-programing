package org.example;

import java.util.function.Function;

public class FunctionalExample {
  public static void main(String[] args) {
    Function<String, String> fn = (value) -> value.toUpperCase();

    System.out.println(fn.apply("Hello"));
  }
}
