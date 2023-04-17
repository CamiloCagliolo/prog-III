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

    public boolean isEmpty(){
        return root == null;
    }

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

    public boolean delete(Integer el){
        return delete(el, root);
    }
    
    private boolean delete(Integer el, Node n){
        if(n.hasNoChild()){
            return false;
        }
        if(el.compareTo(n.getValue()) <= 0){
            Node leftChild = n.getLeft();
            if(el.compareTo(leftChild.getValue()) == 0){
                if(leftChild.hasNoChild()){
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
                if(rightChild.hasNoChild()){
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
        if(n.hasNoChild()){
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

    public List<Integer> getFrontier(){
        ArrayList<Integer> arr = new ArrayList<>();
        getFrontier(root, arr);
        return arr;
    }

    private void getFrontier(Node n, ArrayList<Integer> arr){
        if(n == null){
            return;
        }
        if(n.hasNoChild()){
            arr.add(n.getValue());
        }
        else{
            getFrontier(n.getLeft(), arr);
            getFrontier(n.getRight(), arr);
        }
    }

    public Integer getMaxElement(){
        return getRightmostNode(root).getValue();
    }

    private Node getRightmostNode(Node n){
        if(n.hasRight()){
            return getRightmostNode(n.getRight());
        }
        return n;
    }

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

}
