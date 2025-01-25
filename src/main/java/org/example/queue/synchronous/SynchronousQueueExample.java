package org.example.queue.synchronous;

import java.util.concurrent.SynchronousQueue;

/*
¿Qué es SynchronousQueue?
Es una cola de capacidad cero: no almacena elementos internamente.
Cada operación put() (productor) bloquea hasta que haya un consumidor haciendo take(), y viceversa.
Funciona como un intercambio directo (hand-off) entre hilos: el productor y el consumidor se sincronizan para entregar/recibir el objeto al mismo tiempo.
En otras palabras, cuando un hilo llama a put(x), se queda esperando hasta que otro hilo realice take(). Del mismo modo, si un consumidor llama a take(), se bloquea hasta que aparezca un hilo que llame a put().

¿Para qué se usa?
Patrón de “hand-off directo” entre productor y consumidor: si quieres que cada mensaje/proceso se gestione en el instante en que se produce (sin colas intermedias), SynchronousQueue garantiza que no habrá buffer.
Sincronizar exactamente 1 a 1: con SynchronousQueue, el productor no podrá “soltar” un ítem hasta que el consumidor se encuentre listo para recogerlo.
Implementaciones de ThreadPools: por ejemplo, newCachedThreadPool en Java usa internamente un SynchronousQueue para asignar tareas a hilos al vuelo (sin acumularlas en cola).
 */

public class SynchronousQueueExample {
    public static void main(String[] args) {
        // Crear la cola sin capacidad
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        // Hilo Productor
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    String message = "Mensaje " + i;
                    System.out.println("Productor quiere poner: " + message);
                    // Bloquea hasta que haya un consumidor haciendo take()
                    queue.put(message);
                    System.out.println("Productor entregó: " + message);
                    Thread.sleep(500); // Simula algún tiempo entre producciones
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Productor");

        // Hilo Consumidor
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Consumidor esperando para tomar...");
                    // Bloquea hasta que el productor ponga algo
                    String data = queue.take();
                    System.out.println("Consumidor recibió: " + data);
                    Thread.sleep(1000); // Simula algún tiempo de procesamiento
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumidor");

        producer.start();
        consumer.start();
    }
}
