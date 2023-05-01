package tp2.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Node root;

    public Integer getRoot(){
        return root.getValue();
    }

    public boolean hasElement(Integer el){
        return false;
    }

    // Complexity O(1)
    public boolean isEmpty(){
        return root == null;
    }


    // Complexity O(n) (peor caso, enredadera: se insertan los valores en orden). Arbol balanceado: O(h)
    public void insert(Integer el){
        if(isEmpty()){
            root = new Node(el);
            return;
        }
        insert(el, root);
    }


    private void insert(Integer el, Node n){
        if(n.getValue().compareTo(el) == 0){
            return;
        }
        if(el.compareTo(n.getValue()) < 0){
            if(n.hasLeft()){
                insert(el, n.getLeft());
            }
            else{
                n.setLeft(new Node(el));
            }
        }
        else{
            if(n.hasRight()){
                insert(el, n.getRight());
            }
            else{
                n.setRight(new Node(el));
            }
        }

    }

    // Complexity: peores casos son 1) quitar una hoja de una enredadera, O(n) o
    // 2) quitar un nodo interno, lo cual conlleva buscarlo (O(m)),
    // buscar su rightmostChild (O(n-m)),
    // y luego borrar ese hijo, lo cual es orden O(n-m). Finalmente O(m) + O(n-m) + O(n-m) = O(m+n-m+n-m) = O(2n-m) = O(2n) = O(n). En un arbol balanceado: O(h)

    public boolean delete(Integer el){
        return delete(el, root);
    }

    private boolean delete(Integer el, Node n){
        if(n.hasNoChildren()){
            return false;
        }
        if(el.compareTo(n.getValue()) <= 0){
            Node leftChild = n.getLeft();
            if(el.compareTo(leftChild.getValue()) == 0){
                if(leftChild.hasNoChildren()){
                    n.setLeft(null);
                } else if (leftChild.hasLeft() && leftChild.hasRight()) {
                    Node rightmost = new Node(getRightmostNode(leftChild.getLeft()).getValue());
                    rightmost.setLeft(leftChild.getLeft());
                    rightmost.setRight(leftChild.getRight());
                    n.setLeft(rightmost);
                    delete(rightmost.getValue(), rightmost.getLeft());
                } else if(leftChild.hasLeft()){
                    n.setLeft(leftChild.getLeft());
                }
                else if(leftChild.hasRight()){
                    n.setLeft(leftChild.getRight());
                }
                return true;
            }
            else{
                return delete(el, leftChild);
            }
        }
        else{
            Node rightChild = n.getRight();
            if(el.compareTo(rightChild.getValue()) == 0){
                if(rightChild.hasNoChildren()){
                    n.setRight(null);
                } else if (rightChild.hasLeft() && rightChild.hasRight()) {
                    Node rightmost = new Node(getRightmostNode(rightChild.getLeft()).getValue());
                    rightmost.setLeft(rightChild.getLeft());
                    rightmost.setRight(rightChild.getRight());
                    n.setRight(rightmost);
                    delete(rightmost.getValue(), rightmost);
                } else if(rightChild.hasLeft()){
                    n.setRight(rightChild.getLeft());
                }
                else if(rightChild.hasRight()){
                    n.setRight(rightChild.getRight());
                }
                return true;
            }
            else{
                return delete(el, rightChild);
            }
        }
    }

    // Complexity: O(n) for all prints
    public void printPreOrder(){
        printPreOrder(root);
    }

    private void printPreOrder(Node n){
        if(n == null){
            return;
        }

        System.out.println(n.getValue() + " ");
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }

    public void printInOrder(){
        printInOrder(root);
    }

    private void printInOrder(Node n){
        if(n == null){
            return;
        }

        printInOrder(n.getLeft());
        System.out.println(n.getValue() + " ");
        printInOrder(n.getRight());
    }

    public void printPosOrder(){
        printPosOrder(root);
    }

    private void printPosOrder(Node n){
        if(n == null){
            return;
        }

        printPosOrder(n.getLeft());
        printPosOrder(n.getRight());
        System.out.println(n.getValue() + " ");
    }

    // Complexity: O(n), no pasa más de una vez por cada elemento. Arbol balanceado: O(h)
    public int getHeight(){
        if(isEmpty()){
            return 0;
        }
        return getDepth(root);
    }


    private int getDepth(Node n){
        if(n == null){
            return 0;
        }
        if(n.hasNoChildren()){
            return 1;
        }

        int leftTreeDepth = getDepth(n.getLeft());
        int rightTreeDepth = getDepth(n.getRight());

        if(leftTreeDepth > rightTreeDepth){
            return leftTreeDepth + 1;
        }
        else{
            return rightTreeDepth + 1;
        }
    }

    //Complexity: O(n^2). Peor caso es que tenga que pasar por n nodos y por cada uno llame a getDepth, que es de orden O(n). luego, n*O(n) = O(n^2). En un mejor caso, el árbol es balanceado y es O(h^2)
    public List<Integer> getLongestBranch(){
        ArrayList<Integer> arr = new ArrayList<>();
        if(isEmpty()){
            return arr;
        }
        getLongestBranch(root, arr);
        return arr;
    }

    private void getLongestBranch(Node n, ArrayList<Integer> arr){
        arr.add(n.getValue());
        int depthLeft = getDepth(n.getLeft());
        int depthRight = getDepth(n.getRight());
        if(depthLeft > depthRight){
            getLongestBranch(n.getLeft(), arr);
        }
        else if(depthRight != 0){
            getLongestBranch(n.getRight(), arr);
        }
    }

    // Complexity: O(n)
    public List<Integer> getFrontier(){
        ArrayList<Integer> arr = new ArrayList<>();
        getFrontier(root, arr);
        return arr;
    }

    private void getFrontier(Node n, ArrayList<Integer> arr){
        if(n == null){
            return;
        }
        if(n.hasNoChildren()){
            arr.add(n.getValue());
        }
        else{
            getFrontier(n.getLeft(), arr);
            getFrontier(n.getRight(), arr);
        }
    }

    // Complexity: O(n). Arbol balanceado: O(h)
    public Integer getMaxElement(){
        return getRightmostNode(root).getValue();
    }

    private Node getRightmostNode(Node n){
        if(n.hasRight()){
            return getRightmostNode(n.getRight());
        }
        return n;
    }

    // Complexity: O(n). En un árbol balanceado, O(n/2^level), por ser la máxima cantidad de elementos en un determinado nivel.
    public List<Integer> getElementsAtLevel(int level){
        ArrayList<Integer> arr = new ArrayList<>();
        getElementsAtLevel(root, level, 0, arr);
        return arr;
    }


    private void getElementsAtLevel(Node n, int level, int current, ArrayList<Integer> arr){
        if(n == null){
            return;
        }
        if(current < level){
            getElementsAtLevel(n.getLeft(), level, current + 1, arr);
            getElementsAtLevel(n.getRight(), level, current + 1, arr);
        }
        if(current == level){
            arr.add(n.getValue());
        }
    }

    //Complexity: O(n). Needs to get to every node.
    public int sumInternalNodes(){
        if(isEmpty()){
            return 0;
        }
        return sumInternalNodes(root);
    }

    private int sumInternalNodes(Node n) {
        if (n == null || n.hasNoChildren()) {
            return 0;
        }
        return sumInternalNodes(n.getRight()) + sumInternalNodes(n.getLeft()) + n.getValue();
    }

    //Complexity: O(n), needs to access every node.
    public List<Integer> getIntegersGreaterThan(int k){
        ArrayList<Integer> arr = new ArrayList<>();
        if(isEmpty()){
            return arr;
        }
        storeIntegersGreaterThan(k, root, arr);
        return arr;
    }

    private void storeIntegersGreaterThan(int k, Node n, ArrayList<Integer> arr){
        if(n == null){
            return;
        }
        if(n.getValue() <= k){
            storeIntegersGreaterThan(k, n.getRight(), arr);
        }
        else{
            storeIntegersGreaterThan(k, n.getLeft(), arr);
            arr.add(n.getValue());
            storeIntegersGreaterThan(k, n.getRight(), arr);
        }
    }
}
