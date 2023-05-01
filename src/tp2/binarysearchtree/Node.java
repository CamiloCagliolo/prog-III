package tp2.binarysearchtree;

public class Node {
    protected Integer value;
    protected Node left;
    protected Node right;

    public Node(){
        value = null;
        left = null;
        right = null;
    }

    public Node(Integer v){
        value = v;
    }

    public void setValue(Integer v){
        value = v;
    }

    public void setLeft(Node l){
        left = l;
    }

    public void setRight(Node r){
        right = r;
    }

    public Integer getValue(){
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
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
