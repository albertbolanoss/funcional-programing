package labs.base;

import java.util.function.Supplier;

public class ClousureExample {
    public static void main(String[] args) {
        Supplier<Integer> incrementerA = createIncrementer(0);

        System.out.println(incrementerA.get());  // Imprime 1
        System.out.println(incrementerA.get());  // Imprime 2
        System.out.println(incrementerA.get());  // Imprime 3

        Supplier<Integer> incrementerB = createIncrementer(0);
        System.out.println(incrementerB.get());  // Imprime 1
        System.out.println(incrementerB.get());  // Imprime 2
        System.out.println(incrementerB.get());  // Imprime 3
    }

    public static Supplier<Integer> createIncrementer(int initialCount) {
        int[] count = { initialCount };

        return () -> {
            count[0] = count[0] + 1;
            return count[0];
        };
    }
}
