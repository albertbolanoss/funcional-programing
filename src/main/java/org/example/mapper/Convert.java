package org.example.mapper;

@FunctionalInterface
public interface Convert<T, R> {
  R convert(T t);
}
