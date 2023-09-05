package org.example.funcionalprograming.curryying;

import java.util.function.Function;

/*
  Allow converting a function with two parameters
  into two functions, each with one parameter
 */
public class Main {
  public static void main(String[] args) {
    example01();
    example02();
  }

  private static void example01() {
    Function<Integer, Function<Integer, Integer>> func1 = u -> v -> u + v;
    Function<Integer, Integer> func2 = func1.apply(1);

    Integer sum = func2.apply(2);

    System.out.println(sum);
  }

  private static void example02() {
    Function<Integer, Function<Integer, Function<Integer, Integer>>> func1 = u -> v -> w -> u + v + w;
    Function<Integer, Function<Integer, Integer>> func2 = func1.apply(1);
    Function<Integer, Integer> func3 = func2.apply(2);

    Integer sum = func3.apply(3);


    System.out.println(sum);
  }
}
