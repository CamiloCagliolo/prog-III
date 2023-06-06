package tp3.services;
import tp3.graph.DirectedGraph;
import tp3.graph.Edge;
import tp3.graph.Vertex;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class GraphServices<T> {
    private DirectedGraph<T> graph;

    public GraphServices(DirectedGraph<T> graph){
        this.graph = graph;
    }

    public ArrayList<Vertex<T>> largestPathFromV1ToV2(String key1, String key2){
        Vertex<T> v1 = graph.getVertex(key1);
        Vertex<T> v2 = graph.getVertex(key2);
        ArrayList<Vertex<T>> largestPath = new ArrayList<>();
        ArrayDeque<ArrayList<Vertex<T>>> graphSweeping = new ArrayDeque<>();
        for(Edge<T> e : v1.getAdjacency()){
            ArrayList<Vertex<T>> newPath = new ArrayList<>();
            newPath.add(e.getDestination());
            graphSweeping.add(newPath);
            while(!graphSweeping.isEmpty()){
                ArrayList<Vertex<T>> currentPath = graphSweeping.poll();
                Vertex<T> lastVertex = currentPath.get(currentPath.size() - 1);
                if(lastVertex.equals(v2)){
                    if(pathLength(currentPath) > pathLength(largestPath)){
                        largestPath = currentPath;
                    }
                } else {
                    for(Edge<T> e2 : lastVertex.getAdjacency()){
                        ArrayList<Vertex<T>> newPath2 = new ArrayList<>(currentPath);
                        newPath2.add(e2.getDestination());
                        graphSweeping.add(newPath2);
                    }
                }
            }
        }
        return largestPath;
    }

    private Double pathLength(ArrayList<Vertex<T>> path){
        Double length = 0.0;
        for(int i = 0; i < path.size() - 1; i++){
            Vertex<T> v1 = path.get(i);
            Vertex<T> v2 = path.get(i + 1);
            for(Edge<T> e : v1.getAdjacency()){
                if(e.getDestination().equals(v2)){
                    length += e.getWeight();
                }
            }
        }
        return length;
    }

}
