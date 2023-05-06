package tp3.graph;

public class Edge<T> {
    private Vertex<T> v1;
    private Vertex<T> v2;
    private double weight;
    private String label;

    public Edge(Vertex<T> v1, Vertex<T> v2, Double weight, String label){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = 1;
        if(weight != null){
            this.weight = weight;
        }
        this.label = label;
    }

    public Vertex<T> getV2(){
        return v2;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
