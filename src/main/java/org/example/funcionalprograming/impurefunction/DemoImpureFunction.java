package org.example.funcionalprograming.impurefunction;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoImpureFunction {
  static Logger log = Logger.getLogger(DemoImpureFunction.class.getName());

  public static void main(String[] args) {
    int firstResult = add(multiply(2, 3), multiply(3, 4));
    System.out.println("==>" + firstResult);

    // as you can see it replaces the values getting from multiply(2, 3), multiply(3, 4)
    // and the result is different because it does not print the log "Return the multiply result" (significant change in the program)
    // So this is no a Pure function
    int secondResult = add(6, 12);
    System.out.println("==>" + secondResult);

  }
  public static int add(int a, int b) {
    return a + b;
  }

  public static int multiply(int a, int b) {
    log.log(Level.INFO, "Return the multiply result");
    return a * b;
  }

  public static void  log(String message) {
    // This method is no too a pure function because this does not return nothing
    System.out.println(message);
  }
}
