package tp3;

public class Edge<T> {
    private Vertex<T> v1;
    private Vertex<T> v2;
    private double weight;
    private String label;

    public Edge(Vertex<T> v1, Vertex<T> v2){
        this.v1 = v1;
        this.v2 = v2;
        weight = 1;
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
