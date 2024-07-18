package labs.base;

import java.math.BigDecimal;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;


/*
Function<T, R> : Represents a function that accepts one argument and produces a result.
Predicate<T> : Represents a predicate (boolean-valued function) of one argument.
Consumer<T> : Represents an operation that accepts a single input argument and returns no result.
Supplier<T> : Represents a supplier of results.
*/

/**
 * Clase inmutable Purchase: La clase Purchase ya es inmutable, ya que sus campos son finales y no tienen métodos para cambiarlos.
 * Métodos estáticos y funciones puras: Las funciones se mantienen puras y los métodos auxiliares se han movido a métodos estáticos de la clase
 * para facilitar la lectura y mantener la transparencia referencial.
 * Uso de la composición de funciones: Se mejora la composición de funciones para hacer el flujo de datos más claro y conciso.
 * Eliminación de la clase Consumer: La clase Consumer printPurchaseCategory no se utiliza en el flujo y se ha eliminado.
 */

public class PurchaseStreamExample {
    private static Consumer<Purchase> printPurchaseCategory = purchase -> System.out.println(purchase.getCategory());

    private static final BiPredicate<Purchase, PurchaseCategory> filterPurchaseByCategory =
            (purchase, category) -> category.equals(purchase.getCategory());

    private static final Function<Purchase, BigDecimal> getPurchaseAmounts = Purchase::getAmount;

    private static final BinaryOperator<BigDecimal> sumBigDecimals = BigDecimal::add;

    public static void main(String[] args) {
        var purchases = Stream.of(
            new Purchase("Restaurant", PurchaseCategory.FOOD, new BigDecimal(100)),
            new Purchase("Cine", PurchaseCategory.ENTERTAINMENT, new BigDecimal(75))
        );

        var category = PurchaseCategory.FOOD;

        BigDecimal total = calculateTotalForCategory(purchases, category);

        System.out.println("Total " + total);

    }

    private static BigDecimal calculateTotalForCategory(final Stream<Purchase> purchases, final PurchaseCategory category) {
        return purchases
                .filter(purchase -> filterPurchaseByCategory.test(purchase, category))
                .map(getPurchaseAmounts)
                .reduce(sumBigDecimals)
                .orElse(BigDecimal.ZERO);
    }

    static final class Purchase {
        private final String item;
        private final PurchaseCategory category;
        private final BigDecimal amount;

        public Purchase(String item, PurchaseCategory category, BigDecimal amount) {
            this.item = item;
            this.category = category;
            this.amount = amount;
        }

        public String getItem() {
            return item;
        }

        public PurchaseCategory getCategory() {
            return category;
        }

        public BigDecimal getAmount() {
            return amount;
        }
    }

    enum PurchaseCategory {
        FOOD("food"),
        ENTERTAINMENT("entertainment");

        private final String code;

        PurchaseCategory(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
