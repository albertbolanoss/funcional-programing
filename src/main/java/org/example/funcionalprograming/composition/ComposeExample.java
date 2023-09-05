package org.example.funcionalprograming.composition;

public interface ComposeExample<T, R> {
  R apply(T t);

  default <V> ComposeExample<V,R> compose (ComposeExample<V,T> before) {
    return  (V v) -> apply(before.apply(v));
  }
}
