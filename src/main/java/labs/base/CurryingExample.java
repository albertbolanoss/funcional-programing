package labs.base;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CurryingExample {
    public static void main(String[] args) {
        // Función curried
        Function<Integer, Function<Integer, Integer>> curryAdd = x -> y -> x + y;

        // Usar la función curried
        Function<Integer, Integer> add2 = curryAdd.apply(2);
        System.out.println(add2.apply(10)); // Imprime 12
        System.out.println(add2.apply(55)); // Imprime 57
        System.out.println(add2.apply(-3)); // Imprime -1


        // or just

        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        System.out.println(add.apply(2, 10)); // Imprime 12

    }
}
