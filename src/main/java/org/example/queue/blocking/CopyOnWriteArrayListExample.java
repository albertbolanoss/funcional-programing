package org.example.queue.blocking;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        // CountDownLatch con un conteo inicial de 1 (para esperar al escritor)
        CountDownLatch latch = new CountDownLatch(1);

        // Añadiendo elementos desde múltiples hilos
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("Añadido: " + i);
            }
            latch.countDown(); // Indica que el escritor ha terminado
        });

        Thread reader = new Thread(() -> {
            try {
                latch.await(); // Espera a que el escritor complete su trabajo

                for (int item : list) { // Iteración segura, incluso si otro hilo modifica la lista
                    System.out.println("Leído: " + item);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        writer.start();
        reader.start();
    }
}