package org.example;

import java.util.Optional;

public class FlatMapExample {
    public static void main(String[] args) {
        Optional<Optional<Integer>> outerOptional = Optional.of(Optional.of(10));

        Optional<Integer> result = outerOptional.flatMap(innerOptional -> innerOptional.map(value -> value * 2));

        System.out.println(result.orElse(0)); // Output: 20
    }
}
