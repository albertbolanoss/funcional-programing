package org.example.queue.delay;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {
    // Clase que representa una tarea con cierto retraso
    static class DelayedTask implements Delayed {
        private final long startTime; // Momento en que la tarea estará lista
        private final String message;

        public DelayedTask(String message, long delayMillis) {
            this.message = message;
            // guardamos el tiempo futuro en el que la tarea estará disponible
            this.startTime = System.currentTimeMillis() + delayMillis;
        }

        // Indica cuánto tiempo falta para que caduque el delay (y la tarea pueda obtenerse)
        @Override
        public long getDelay(TimeUnit unit) {
            long diff = startTime - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        // Permite ordenar las tareas en la cola según su tiempo restante
        @Override
        public int compareTo(Delayed other) {
            long diff = this.getDelay(TimeUnit.MILLISECONDS) - other.getDelay(TimeUnit.MILLISECONDS);
            return (diff == 0) ? 0 : ((diff < 0) ? -1 : 1);
        }

        public String getMessage() {
            return message;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Creamos la cola
        BlockingQueue<DelayedTask> delayQueue = new DelayQueue<>();

        // Insertamos algunas tareas con diferentes retrasos
        delayQueue.put(new DelayedTask("Tarea 1 (1s de retraso)", 1000));
        delayQueue.put(new DelayedTask("Tarea 2 (3s de retraso)", 3000));
        delayQueue.put(new DelayedTask("Tarea 3 (5s de retraso)", 5000));

        System.out.println("Iniciando la obtención de tareas de la DelayQueue...");

        // Consumimos las tareas. Cada take() se desbloqueará sólo cuando la tarea haya "vencido" su delay
        for (int i = 0; i < 3; i++) {
            DelayedTask task = delayQueue.take();
            System.out.println("Se obtuvo: " + task.getMessage()
                    + " en t = " + System.currentTimeMillis());
        }

        System.out.println("Fin del ejemplo DelayQueue.");
    }
}
