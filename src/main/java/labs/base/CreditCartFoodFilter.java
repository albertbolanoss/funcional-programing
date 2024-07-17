package labs.base;

import java.math.BigDecimal;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
Function<T, R> : Represents a function that accepts one argument and produces a result.
Predicate<T> : Represents a predicate (boolean-valued function) of one argument.
Consumer<T> : Represents an operation that accepts a single input argument and returns no result.
Supplier<T> : Represents a supplier of results.
*/

public class CreditCartFoodFilter {
    private static BiPredicate<Purchase, PurchaseCategory> filterPurchaseByCategory = (purchase, category) -> category.equals(purchase.getCategory());
    private static Consumer<Purchase> printPurchaseCategory = purchase -> System.out.println(purchase.getCategory());

    private static Function<Purchase, BigDecimal> getPurchaseAmounts = Purchase::getAmount;

    private static BinaryOperator<BigDecimal> sumBigDecimals = BigDecimal::add;


    public static void main(String[] args) {
        var purchases = Stream.of(
            new Purchase("Restaurant", PurchaseCategory.FOOD, new BigDecimal(100)),
            new Purchase("Cine", PurchaseCategory.ENTERTAINMENT, new BigDecimal(75))
        );
        var category = PurchaseCategory.FOOD;

        var foodPurchases = purchases
                .filter(purchase ->  filterPurchaseByCategory.test(purchase, category))
                .collect(Collectors.toList());
        var amounts = foodPurchases.stream().map(getPurchaseAmounts).collect(Collectors.toList());
        var total = amounts.stream().reduce(sumBigDecimals).orElse(BigDecimal.ZERO);

        System.out.println("Total " + total);

    }


    static class Purchase {
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
