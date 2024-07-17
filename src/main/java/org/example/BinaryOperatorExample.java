package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
  static Comparator<Integer> comparator = Integer::compareTo;

  public static void main(String[] args) {
    BinaryOperator<Integer> binaryOperator = (a, b) -> a * b;
    System.out.println(binaryOperator.apply(3, 5));

    Arrays.asList(1,3).stream().reduce(binaryOperator);

    BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
    BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);

    System.out.println(maxBy.apply(5, 4));
    System.out.println(minBy.apply(5, 4));
  }
}
