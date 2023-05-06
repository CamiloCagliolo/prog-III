package tp3.graph;
import java.util.ArrayList;

public class Vertex<T> {
    private String name;
    private T value;
    private ArrayList<Edge<T>> adjacency;
    private char colour;

    public Vertex(String id, T value){
        this.name = id;
        this.value = value;
        this.adjacency = new ArrayList<>();
        this.colour = 'w';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Edge<T>> getAdjacency(){
        return new ArrayList<>(adjacency);
    }

    public void addEdge(Edge<T> edge){
        adjacency.add(edge);
    }

    public void setColour(char c){
        colour = c;
    }

    public char getColour(){
        return colour;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Value: " + value;
    }
}
