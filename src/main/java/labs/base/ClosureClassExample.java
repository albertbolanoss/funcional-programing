package labs.base;

import java.util.function.Supplier;

public class ClosureClassExample {
    public static void main(String[] args) {
        Supplier<Integer> incrementer = increment();

        System.out.println(incrementer.get());  // Imprime 1
        System.out.println(incrementer.get());  // Imprime 2
        System.out.println(incrementer.get());  // Imprime 3
    }

    public static Supplier<Integer> increment() {
        // Usamos una clase contenedora mutable
        class Counter {
            private int count = 0;
        }

        Counter counter = new Counter();

        return () -> {
            counter.count = counter.count + 1;
            return counter.count;
        };
    }
}
