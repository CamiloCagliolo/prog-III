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
                 System.out.println(endVertex.getName());
                 endVertex.setColour('y');
                 depthFirstSearch(endVertex);
             }
        }
        v.setColour('b');
    }
}
