package tp3;
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

    public void addEdge(String k1, String k2){
        Vertex<T> v1 = vertices.get(k1);
        Vertex<T> v2 = vertices.get(k2);

        Edge<T> edge = new Edge<>(v1, v2);
        v1.addEdge(edge);
    }

    public void addWeightedEdge(String k1, String k2, double weight){
        Vertex<T> v1 = vertices.get(k1);
        Vertex<T> v2 = vertices.get(k2);

        Edge<T> edge = new Edge<>(v1, v2);
        edge.setWeight(weight);
        v1.addEdge(edge);
    }

    public void addLabeledEdge(String k1, String k2, String label){
        Vertex<T> v1 = vertices.get(k1);
        Vertex<T> v2 = vertices.get(k2);

        Edge<T> edge = new Edge<>(v1, v2);
        edge.setLabel(label);
        v1.addEdge(edge);
    }
}
