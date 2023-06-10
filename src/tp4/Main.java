package tp4;

import tp3.graph.DirectedGraph;
import tp3.graph.Vertex;
import tp3.services.GraphServices;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //Ejercicio 1: Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente
        //en un sentido. Una de las salas se denomina entrada y la otra salida. Construir un algoritmo que
        //permita ir desde la entrada a la salida atravesando la máxima cantidad de salas.

        DirectedGraph<String> salas = new DirectedGraph<>();
        GraphServices<String> servicio = new GraphServices<>(salas);
        ArrayList<Vertex<String>> caminoMásLargo = servicio.largestPathFromV1ToV2("Entrada", "Salida");
        System.out.println(caminoMásLargo);




    }
}
