package org.example.queue.blocking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class SynchronizedListExample {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch latch = new CountDownLatch(1);


        // Añadiendo elementos desde múltiples hilos
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("Añadido: " + i);
            }

            latch.countDown();
        });

        Thread reader = new Thread(() -> {
            try {
                latch.await();
                synchronized (list) { // Necesitas sincronización manual al iterar
                    for (int item : list) {
                        System.out.println("Leído: " + item);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        writer.start();
        reader.start();
    }
}
