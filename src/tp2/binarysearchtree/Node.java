package tp2.binarysearchtree;

public class Node {
    private Integer value;
    private Node left;
    private Node right;

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

    public boolean hasNoChild(){
        return !hasLeft() && !hasRight();
    }
}
