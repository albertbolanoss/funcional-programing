package org.example;

import org.example.mapper.Convert;
import org.example.mapper.Mapper;
import org.example.mapper.Person;
import org.example.mapper.PersonDTO;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample {
  public static void main(String[] args) {
    // Object::instance method
    // Consumer<Integer> print = (text) -> System.out.println(text);
    Consumer<Integer> print = System.out :: println;

    // Class::static method class
    // Supplier<Double> randomNumber = () -> Math.random();
    Supplier<Double> randomNumber = Math :: random;

    // Class :: instance method
    // Function<String, Integer> length = (text) -> text.length;
    Function<String, Integer> length = String :: length;

    // Object::instance method
    // Function<Person, PersonDTO> convert = (person) -> new Mapper().convert(person);
    Function<Person, PersonDTO> convert = new Mapper() :: convert;

    new String();
    // Class :: new
    // Function<Runnable, Thread> threadGenerator = (runnable) -> new Thread(runnable);
    Function<Runnable, Thread> threadGenerator = Thread :: new;

  }
}
