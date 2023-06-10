package tp3.graph;
import tp1.simple.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;

public class DirectedGraph<T> {
    protected HashMap<String, Vertex<T>> vertices;

    public DirectedGraph(){
        vertices = new HashMap<>();
    }

    public void addVertex(String name, T value){
        if(!vertices.containsKey(name)){
            Vertex<T> vertex = new Vertex<T>(name, value);
            vertices.put(name, vertex);
        }
    }

    public void addEdge(String k1, String k2, Double weight, String label){
        Vertex<T> v1 = vertices.get(k1);
        Vertex<T> v2 = vertices.get(k2);
        Edge<T> edge = new Edge<>(v1, v2, weight, label);
        v1.addEdge(edge);
    }

    public ArrayList<Vertex<T>> getVertices(){
        return new ArrayList<>(vertices.values());
    }

    public ArrayList<Edge<T>> getEdges(){
        ArrayList<Edge<T>> edges = new ArrayList<>();
        for(Vertex<T> v : vertices.values()){
            edges.addAll(v.getAdjacency());
        }
        return edges;
    }

    public Vertex<T> getVertex(String key){
        return vertices.get(key);
    }

    //PRINTING METHODS
    public void printByDepthFirstSearch(){
        for(Vertex<T> v : vertices.values()){
            v.setColour('w');
        }

        for(Vertex<T> v : vertices.values()){
            if(v.getColour() == 'w'){
                v.setColour('y');
                printByDepthFirstSearch(v);
            }
        }
    }

    protected void printByDepthFirstSearch(Vertex<T> v){
        v.setColour('y');
        for(Edge<T> e : v.getAdjacency()){
            Vertex<T> endVertex = e.getDestination();
             if(endVertex.getColour() == 'w') {
                 System.out.println(endVertex);
                 endVertex.setColour('y');
                 printByDepthFirstSearch(endVertex);
             }
        }
        v.setColour('b');
    }

    public void printByBreadthFirstSearch(){
        LinkedList<Vertex<T>> queue = new LinkedList<>();
        for(Vertex<T> v : vertices.values()){
            v.setColour('w');
        }

        for(Vertex<T> v : vertices.values()){
            if(v.getColour() == 'w') {
                printByBreadthFirstSearch(v, queue);
            }
        }
    }

    protected void printByBreadthFirstSearch(Vertex<T> v, LinkedList<Vertex<T>> queue){
        v.setColour('b');
        queue.add(v);

        while(!queue.isEmpty()){
            Vertex<T> vertex = queue.extractFront();
            for(Edge<T> e : vertex.getAdjacency()){
                Vertex<T> adjacent = e.getDestination();
                if(adjacent.getColour() == 'w'){
                    adjacent.setColour('b');
                    System.out.println(adjacent);
                    queue.add(adjacent);
                }
            }
        }
    }
}
