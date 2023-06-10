package tp3;

import tp3.graph.DirectedGraph;
import tp3.services.GraphServices;

public class Main {
    public static void main(String[] args) {
        DirectedGraph<Integer> graph = new DirectedGraph<>();

        //Creation of 12 vertices
        graph.addVertex("1", 1);
        graph.addVertex("2", 2);
        graph.addVertex("3", 3);
        graph.addVertex("4", 4);
        graph.addVertex("5", 5);
        graph.addVertex("6", 6);
        graph.addVertex("7", 7);
        graph.addVertex("8", 8);
        graph.addVertex("9", 9);
        graph.addVertex("10", 10);
        graph.addVertex("11", 11);
        graph.addVertex("12", 12);

        //Creation of 14 edges
        graph.addEdge("1", "2", 1.0, "1-2");
        graph.addEdge("1", "3", 1.0, "1-3");
        graph.addEdge("1", "4", 1.0, "1-4");
        graph.addEdge("2", "5", 1.0, "2-5");
        graph.addEdge("2", "6", 1.0, "2-6");
        graph.addEdge("3", "7", 1.0, "3-7");
        graph.addEdge("4", "9", 1.0, "4-9");
        graph.addEdge("4", "10", 1.0, "4-10");
        graph.addEdge("4", "11", 1.0, "4-11");
        graph.addEdge("6", "12", 1.0, "6-12");
        graph.addEdge("7", "12", 1.0, "7-12");
        graph.addEdge("8", "12", 1.0, "8-12");
        graph.addEdge("11", "8", 1.0, "11-8");
        graph.addEdge("10", "7", 1.0, "10-7");

        GraphServices<Integer> graphServices = new GraphServices<Integer>(graph);
        System.out.println("Graph has cycles: " + graphServices.hasCycles());
        System.out.println("Longest path from 1 to 12: " + graphServices.largestPathFromV1ToV2("1", "12"));
        System.out.println("All the vertices with a path to 7: " + graphServices.getAllStartPointsTo("7"));
    }
}
