package scratch.donut;

import org.junit.jupiter.api.Test;

import io.vavr.Tuple2;
import io.vavr.collection.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DonutShopTest {
    @Test
    void testBuyDonut() {
        CreditCard creditCard = new CreditCard();
        Tuple2<Donut, Payment> purchase = DonutShop.buyDonut(creditCard);
        assertEquals(Donut.price, purchase._2.amount);
        assertEquals(creditCard, purchase._2.creditCard);
    }

    @Test
    public void testBuyDonuts() {
        CreditCard creditCard = new CreditCard();
        Tuple2<List<Donut>, Payment> purchase = DonutShop.buyDonuts(5, creditCard);
        assertEquals(Donut.price * 5, purchase._2.amount);
        assertEquals(creditCard, purchase._2.creditCard);
    }
}
