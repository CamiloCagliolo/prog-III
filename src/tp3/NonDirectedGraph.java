package tp3;

public class NonDirectedGraph<T> extends DirectedGraph<T>{

    @Override
    public void addEdge(String k1, String k2){
        super.addEdge(k1, k2);
        super.addEdge(k2, k1);
    }

    @Override
    public void addWeightedEdge(String k1, String k2, double weight){
        super.addWeightedEdge(k1, k2, weight);
        super.addWeightedEdge(k2, k1, weight);
    }

    @Override
    public void addLabeledEdge(String k1, String k2, String label){
        super.addLabeledEdge(k1, k2, label);
        super.addLabeledEdge(k2, k1, label);
    }
}
