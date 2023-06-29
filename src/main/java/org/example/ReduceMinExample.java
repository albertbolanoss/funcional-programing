package org.example;

import java.util.Arrays;

public class ReduceMinExample {
  public static void main(String[] args) {
    Integer max = Arrays.asList(2,3,44,5,6,9).stream().reduce(0, (a, b) -> a > b ? a : b);
    System.out.println(max);
  }
}
