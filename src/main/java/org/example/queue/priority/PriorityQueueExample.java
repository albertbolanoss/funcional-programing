package org.example.queue.priority;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class PriorityQueueExample {
  public static void main(String[] args) {
    // Priory Queue is no safe thread (no blocking)
    Comparator<Task> comparator = Comparator.comparingInt(Task::getPriority);
    Queue<Task> queue = new PriorityQueue<>(comparator);

    // Enqueue tasks with random priorities
    for (int i = 0; i < 5; i++) {
      String name = "Task " + (i + 1);
      int priority = ThreadLocalRandom.current().nextInt(10, 100);
      Task task = new Task(name, priority);
      queue.offer(task);
      // System.out.printf("queue.offer(%s)    -->  queue = %s%n", task, queue);
    }

    // Dequeue all elements
    while (!queue.isEmpty()) {
      // System.out.printf("queue.poll() = %s  -->  queue = %s%n", queue.poll().getName(), queue);
      Task task = queue.poll();
      System.out.printf("%s - %s (%s)\n", task.getName(), task.getPriority(), queue);
    }
  }

}
