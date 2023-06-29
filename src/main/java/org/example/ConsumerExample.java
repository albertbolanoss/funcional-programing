package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
  public static void main(String[] args) {
    Consumer<String> c1 = (value) -> value.substring(0, 1);
    Consumer<String> c2 = (value) -> System.out.println(value.toUpperCase());

    // c1.andThen(c2).accept("Base");


    List<String> list = Arrays.asList("Base");
    list.stream().forEach(c1.andThen(c2));
  }
}
