package org.example.funcionalprograming.composition;

public class Main {
  public static void main(String[] args) {
    ComposeExample<Square, Integer> func1 = square -> square.calculateArea();
    ComposeExample<Integer, Double> func2 = area -> Math.sqrt(area);

    ComposeExample<Square, Double> getSize = func2.compose(func1);
    Square square = new Square(100);
    var result = getSize.apply(square);
    System.out.println(result);
  }
}
