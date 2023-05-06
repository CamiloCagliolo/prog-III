package tp3.graph;

public class NonDirectedGraph<T> extends DirectedGraph<T>{

    @Override
    public void addEdge(String k1, String k2, Double weight, String label){
        super.addEdge(k1, k2, weight, label);
        super.addEdge(k2, k1, weight, label);
    }
}
