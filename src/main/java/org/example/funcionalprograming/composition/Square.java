package org.example.funcionalprograming.composition;

public class Square {
  private Integer side;

  public Square(Integer side) {
    this.side = side;
  }

  Integer calculateArea() {
    return side * side;
  }
}
