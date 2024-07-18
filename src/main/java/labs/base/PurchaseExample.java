package labs.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PurchaseExample {

    public static void main(String[] args) {
        List<Purchase> purchases = List.of(
                new Purchase("Restaurant", PurchaseCategory.FOOD.getCode(), new BigDecimal(100)),
                new Purchase("Cine", PurchaseCategory.ENTERTAINMENT.getCode(), new BigDecimal(75)));

        var total = sumBigDecimal(getPurchasePrices(filterByCategory(purchases, PurchaseCategory.FOOD)));

        System.out.println("The total: " + total);
    }

    public static <T> Stream<T> getSafeStream(List<T> list) {
        return list != null ? list.stream() : Stream.empty();
    }

    public static List<Purchase> filterByCategory(final List<Purchase> purchases, final PurchaseCategory purchaseCategory) {
        return getSafeStream(purchases)
            .filter(purchase -> purchaseCategory.getCode().equals(purchase.getCategory()))
            .collect(Collectors.toList());

    }

    public static List<BigDecimal> getPurchasePrices(final List<Purchase> purchases) {
        return getSafeStream(purchases)
                .map(Purchase::getAmount)
                .collect(Collectors.toList());
    }

    public static BigDecimal sumBigDecimal(final List<BigDecimal> prices) {
        return getSafeStream(prices)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    static final class Purchase {
        private final String item;
        private final String category;
        private final BigDecimal amount;

        public Purchase(final String item, final String category, final BigDecimal amount) {
            this.item = item;
            this.category = category;
            this.amount = amount;
        }

        public String getItem() {
            return item;
        }

        public String getCategory() {
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
