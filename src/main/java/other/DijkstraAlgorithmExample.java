package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithmExample {
    public static void main(String[] args) {
        Node philadelphia = new Node("Philadelphia");
        Node anaheim = new Node("Anaheim");
        Node azusa = new Node("Azusa");
        Node cucamonga = new Node("Cucamonga");
        Node newYorkCity = new Node("New York City");

        philadelphia.adjacencies.add(new Edge(anaheim, 40));
        philadelphia.adjacencies.add(new Edge(azusa, 5));
        anaheim.adjacencies.add(new Edge(newYorkCity, 10));
        anaheim.adjacencies.add(new Edge(azusa, 30));
        azusa.adjacencies.add(new Edge(newYorkCity, 30));
        azusa.adjacencies.add(new Edge(cucamonga, 5));
        cucamonga.adjacencies.add(new Edge(newYorkCity, 20));

        computePaths(philadelphia);

        System.out.println("Distance to New York City: " + newYorkCity.minDistance);
        List<Node> path = getShortestPathTo(newYorkCity);
        System.out.println("Path: " + path);
    }

    public static void computePaths(Node source) {
        source.minDistance = 0.;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(source);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            for (Edge e : current.adjacencies) {
                Node target = e.target;
                double weight = e.weight;
                double distanceThroughCurrent = current.minDistance + weight;

                if (distanceThroughCurrent < target.minDistance) {
                    priorityQueue.remove(target);
                    target.minDistance = distanceThroughCurrent;
                    target.previous = current;
                    priorityQueue.add(target);
                }
            }
        }
    }

    public static List<Node> getShortestPathTo(Node target) {
        List<Node> path = new ArrayList<>();
        for (Node node = target; node != null; node = node.previous)
            path.add(node);
        Collections.reverse(path);
        return path;
    }


    static class Node implements Comparable<Node> {
        public final String name;
        public List<Edge> adjacencies = new ArrayList<>();
        public double minDistance = Double.POSITIVE_INFINITY;
        public Node previous;

        public Node(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(minDistance, other.minDistance);
        }
    }

    static class Edge {
        public final Node target;
        public final double weight;

        public Edge(Node target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }

}
