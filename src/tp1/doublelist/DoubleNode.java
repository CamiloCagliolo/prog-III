package tp1.doublelist;

import tp1.AbstractNode;

public class DoubleNode<T> extends AbstractNode<T, DoubleNode<T>> {
    private DoubleNode<T> previous;

    public DoubleNode(T c){
        content = c;
    }

    public DoubleNode(DoubleNode<T> n, T c){
        next = n;
        content = c;
    }

    public DoubleNode(DoubleNode<T> p, DoubleNode<T> n, T c){
        previous = p;
        next = n;
        content = c;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    public boolean hasPrevious(){
        return previous != null;
    }
}
