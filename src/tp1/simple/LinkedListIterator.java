package tp1.simple;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> pointer;

    public LinkedListIterator(Node<T> head){
        pointer = head;
    }

    public Node<T> getPointer(){
        return pointer;
    }

    @Override
    public boolean hasNext() {
        return pointer != null;
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        T content = pointer.getContent();
        pointer = pointer.getNext();
        return content;
    }
}
