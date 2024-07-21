package labs.base;

import io.vavr.control.Try;

public class MonadExample {
    public static void main(String[] args) {
        // Definir una operación que puede lanzar una excepción
        Try<Integer> result = Try.of(() -> divide(10, 0))
                .map(x -> x * 2) // Esta operación se salta si ocurre una excepción antes
                .map(x -> x + 1);

        // Manejar el resultado
        result.onSuccess(value -> System.out.println("Resultado: " + value))
                .onFailure(ex -> System.out.println("Error: " + ex.getMessage()));
    }

    public static int divide(int a, int b) {
        return a / b; // Puede lanzar ArithmeticException si b es 0
    }
}