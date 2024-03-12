package org.example.funcionalprograming.referencetransparency;

public class ReferentialTransparency {
  public static void main(String[] args) {
    // x = 7 + (8), x = 7 + (2*2*2)
    int result1 = add(7, multiply(2, 4));
    System.out.println(result1);

    int result2 = add(7, multiply(2, multiply(2, 2)));
    System.out.println(result2);

    // The result for both is exactly the same, don't vary anything
  }

  public static int add(int a, int b) {
    return a + b;
  }

  public static int multiply(int a, int b) {
    return a * b;
  }
}
