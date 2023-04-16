package tp2.binarysearchtree;
import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    private Node pointer;

    public TreeIterator(Node p){
        pointer = p;
    }

    public Node getPointer(){
        return pointer;
    }

    public Node goLeft(){
        pointer = pointer.getLeft();
        return pointer;
    }

    public Node goRight(){
        pointer = pointer.getRight();
        return pointer;
    }

    @Override
    public boolean hasNext() {
        return pointer != null;
    }

    @Override
    public Integer next() {
        return null;
    }
}
