package org.example;

public class MyFunctionalInterfaceExample {
  public static void main(String[] args) {
    MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Our implementation");
    myFunctionalInterface.run();

    onTheFly(() -> System.out.println("Hello"));
  }

  public static void onTheFly (MyFunctionalInterface fn) {
    fn.run();
  }
}
