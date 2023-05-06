package tp3.graph;
import tp1.simple.LinkedList;

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

    public boolean hasCycles(){
        for(Vertex<T> v : vertices.values()){
            v.setColour('w');
        }

        for(Vertex<T> v : vertices.values()){
            boolean found = false;
            if(v.getColour() == 'w'){
                v.setColour('y');
                found = hasCycles(v);
            }
            if(found){
                return true;
            }
        }
        return false;
    }

    protected boolean hasCycles(Vertex<T> v){
        v.setColour('y');
        for(Edge<T> e : v.getAdjacency()){
            Vertex<T> endVertex = e.getV2();
            if(endVertex.getColour() == 'w') {
                endVertex.setColour('y');
                return hasCycles(endVertex);
            }
            else if(endVertex.getColour() == 'y'){
                return true;
            }
        }
        v.setColour('b');
        return false;
    }

    public void depthFirstSearch(){
        for(Vertex<T> v : vertices.values()){
            v.setColour('w');
        }

        for(Vertex<T> v : vertices.values()){
            if(v.getColour() == 'w'){
                v.setColour('y');
                depthFirstSearch(v);
            }
        }
    }

    protected void depthFirstSearch(Vertex<T> v){
        v.setColour('y');
        for(Edge<T> e : v.getAdjacency()){
            Vertex<T> endVertex = e.getV2();
             if(endVertex.getColour() == 'w') {
                 System.out.println(endVertex);
                 endVertex.setColour('y');
                 depthFirstSearch(endVertex);
             }
        }
        v.setColour('b');
    }

    public void breadthFirstSearch(){
        LinkedList<Vertex<T>> queue = new LinkedList<>();
        for(Vertex<T> v : vertices.values()){
            v.setColour('w');
        }

        for(Vertex<T> v : vertices.values()){
            if(v.getColour() == 'w') {
                breadthFirstSearch(v, queue);
            }
        }
    }

    protected void breadthFirstSearch(Vertex<T> v, LinkedList<Vertex<T>> queue){
        v.setColour('b');
        queue.add(v);

        while(!queue.isEmpty()){
            Vertex<T> vertex = queue.extractFront();
            for(Edge<T> e : vertex.getAdjacency()){
                Vertex<T> adjacent = e.getV2();
                if(adjacent.getColour() == 'w'){
                    adjacent.setColour('b');
                    System.out.println(adjacent);
                    queue.add(adjacent);
                }
            }
        }
    }
}
