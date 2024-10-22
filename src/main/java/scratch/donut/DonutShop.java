package scratch.donut;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import static io.vavr.collection.List.fill;

public class DonutShop {
    public static Tuple2<Donut, Payment> buyDonut(final CreditCard cCard) {
        return Tuple.of(new Donut(), new Payment(cCard, Donut.price));
    }

    public static Tuple2<List<Donut>, Payment> buyDonuts(final int quantity,
                                                         final CreditCard cCard) {
        return Tuple.of(fill(quantity, Donut::new),
                        new Payment(cCard, Donut.price * quantity));
    }
}