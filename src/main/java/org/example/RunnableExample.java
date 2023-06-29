package org.example;

public class RunnableExample {
  public static void main(String[] args) {
    // Prior java 8
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("Running into runnable prior java 8");
      }
    };

    new Thread(runnable).start();

    // Using Functional interfaces
    Runnable runnable1 = () -> System.out.println("Running into runnable after java 8");
    new Thread(runnable1).start();



  }
}
