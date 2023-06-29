package org.example;

import java.util.function.BiConsumer;

public class BiConsumerExample {
  public static void main(String[] args) {
    BiConsumer<Integer, Integer> biConsumer = (a, b) ->
      System.out.println( a * b);

    biConsumer.accept(3, 8);
  }
}
