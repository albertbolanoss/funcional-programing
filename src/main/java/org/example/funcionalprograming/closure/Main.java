package org.example.funcionalprograming.closure;

/*
Closures are the inline-function valued expressions
which means that they are the class functions with bounded variables.
Closures can be passed to another function as a parameter.
A closure gives us access to the outer function from an inner function
 */
public class Main {
  public static void main(String[] args) {
    int value = 111;

    ClosureExample lambda = () -> {
      System.out.println(value);
    };

    printResult(lambda);
  }

  public static void printResult(ClosureExample closureExample) {
    closureExample.doTask();
  }
}
