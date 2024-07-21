package labs.base;

import io.vavr.control.Option;

public class MonadExample2 {
    // Definimos la función sqrtOption que calcula la raíz cuadrada y maneja posibles errores.
    public static Option<Double> sqrtOption(double x) {
        return x < 0 ? Option.none() : Option.of(Math.sqrt(x));
    }

    // Definimos la función minus4Option que resta 4 y maneja posibles errores.
    public static Option<Double> minus4Option(double x) {
        return x < 4 ? Option.none() : Option.of(x - 4);
    }

    // Definimos la función reciprocalOption que calcula el recíproco y maneja posibles errores.
    public static Option<Double> reciprocalOption(double x) {
        return x == 0 ? Option.none() : Option.of(1 / x);
    }

    // Definimos la función plus13Option que suma 13.
    public static Option<Double> plus13Option(double x) {
        return Option.of(x + 13);
    }

    // Función que aplica la secuencia de operaciones usando la monada Option.
    public static Option<Double> compute(double x) {
        return sqrtOption(x - 7)
                .flatMap(MonadExample2::minus4Option)
                .flatMap(MonadExample2::reciprocalOption)
                .flatMap(MonadExample2::plus13Option);
    }

    // Ejemplo de uso:
    public static void main(String[] args) {
        System.out.println(compute(20));  // Ejemplo con x = 20
        System.out.println(compute(5));   // Ejemplo con x = 5 (debería fallar en sqrtOption)
    }
}
