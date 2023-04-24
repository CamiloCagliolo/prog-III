package tp2.binarysearchtree;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args){
        Tree tree = new Tree();

        tree.insert(2);
        tree.insert(5);
        tree.insert(-1);
        tree.insert(-3);
        tree.insert(4);
        tree.insert(6);
        tree.insert(15);
        tree.insert(12);
        tree.insert(9);

        tree.printInOrder();

        System.out.println("Altura: " + tree.getHeight());
        System.out.println("Rama más larga: " + tree.getLongestBranch());
        System.out.println("Frontera: " + tree.getFrontier());
        System.out.println("Mayor valor: " + tree.getMaxElement());
        System.out.println("Elementos en el nivel 2: " + tree.getElementsAtLevel(2));
        System.out.println("Suma de los nodos internos: " + tree.sumInternalNodes());
        System.out.println("Elementos mayores a -2: " + tree.getIntegersGreaterThan(-2));
    }
}
