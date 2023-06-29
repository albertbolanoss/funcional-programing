package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
  public static void main(String[] args) {
    Predicate<Integer> p = (value) -> value % 2 == 0;
    Predicate<Integer> p1 = (value) -> value > 5;

    System.out.println(p.and(p1).test(10));

    List<Integer> list = Arrays.asList(1,2,3);
    list.stream().filter(p.and(p1));

    System.out.println("Javatpoint" + 10 + 20);}
}
