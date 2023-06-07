package tp3.services;
import tp3.graph.DirectedGraph;
import tp3.graph.Edge;
import tp3.graph.Vertex;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GraphServices<T> {
    private DirectedGraph<T> graph;

    public GraphServices(DirectedGraph<T> graph){
        this.graph = graph;
    }

    public ArrayList<Vertex<T>> largestPathFromV1ToV2(String key1, String key2){
        ArrayList<ArrayList<Vertex<T>>> allPaths = allPathsFromK1toK2(key1, key2);
        ArrayList<Vertex<T>> largestPath = new ArrayList<>();
        Double largestLength = 0.0;
        for(ArrayList<Vertex<T>> path : allPaths){
            Double pathLength = pathLength(path);
            if(pathLength > largestLength){
                largestLength = pathLength;
                largestPath = path;
            }
        }
        return largestPath;
    }

    private ArrayList<ArrayList<Vertex<T>>> allPathsFromK1toK2(String key1, String key2){
        ArrayList<ArrayList<Vertex<T>>> paths = new ArrayList<>();
        Vertex<T> v1 = graph.getVertex(key1);
        Vertex<T> v2 = graph.getVertex(key2);
        ArrayDeque<ArrayList<Vertex<T>>> graphSweeping = new ArrayDeque<>();
        for(Edge<T> e : v1.getAdjacency()){
            ArrayList<Vertex<T>> newPath = new ArrayList<>();
            newPath.add(v1);
            newPath.add(e.getDestination());
            graphSweeping.add(newPath);
            while(!graphSweeping.isEmpty()){
                ArrayList<Vertex<T>> currentPath = graphSweeping.poll();
                Vertex<T> lastVertex = currentPath.get(currentPath.size() - 1);
                if(lastVertex.equals(v2)){
                    paths.add(currentPath);
                } else {
                    for(Edge<T> e2 : lastVertex.getAdjacency()){
                        ArrayList<Vertex<T>> newPath2 = new ArrayList<>(currentPath);
                        newPath2.add(e2.getDestination());
                        graphSweeping.add(newPath2);
                    }
                }
            }
        }
        return paths;
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


    public HashSet<Vertex<T>> getAllStartPointsTo(String key){
        HashSet<Vertex<T>> startPoints = new HashSet<>();
        for(Vertex<T> v : graph.getVertices()){
            ArrayList<ArrayList<Vertex<T>>> allPaths = allPathsFromK1toK2(v.getName(), key);
            for(ArrayList<Vertex<T>> path : allPaths) {
                for (Vertex<T> v2 : path) {
                    startPoints.add(v2);
                }
            }
        }
        return startPoints;
    }
}
