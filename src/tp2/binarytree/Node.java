package tp2.binarytree;

public class Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T v){
        value = v;
    }

    public void setValue(T v){
        value = v;
    }

    public void setLeft(Node<T> l){
        left = l;
    }

    public void setRight(Node<T> r){
        right = r;
    }

    public T getValue(){
        return value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public boolean hasLeft(){
        return left != null;
    }

    public boolean hasRight(){
        return right != null;
    }

    public boolean hasNoChildren(){
        return !hasLeft() && !hasRight();
    }
}
