package tp3.graph;

public class Edge<T> {
    private Vertex<T> origin;
    private Vertex<T> destination;
    private double weight;
    private String label;

    public Edge(Vertex<T> origin, Vertex<T> destination, Double weight, String label){
        this.origin = origin;
        this.destination = destination;
        this.weight = 1;
        if(weight != null){
            this.weight = weight;
        }
        this.label = label;
    }

    public Vertex<T> getDestination(){
        return destination;
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
