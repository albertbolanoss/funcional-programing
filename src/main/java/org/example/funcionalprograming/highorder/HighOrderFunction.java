package org.example.funcionalprograming.highorder;

public class HighOrderFunction {
  public static void main(String[] args) {
    int product = createFactory(() -> Math.random() * 100, r -> r.intValue()).create();
    System.out.println(product);
  }

  public static <T,R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T,R> configurator) {
    return () -> {
      T product = producer.produce();
      return configurator.configure(product);
    };
  }
}
