package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NullPointExceptionTreadExample {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    String value = null;
    Callable<String> callable = () -> value.toUpperCase();

    ExecutorService executorService = Executors.newFixedThreadPool(1);
    var actual = executorService.submit(callable).get();
    System.out.println(actual);

    // do not intentionally shut down executor
    // don't cancel the execution of main thread (this failed in the thread)
  }
}
