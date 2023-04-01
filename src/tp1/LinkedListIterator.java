package tp1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> Pointer;

    public LinkedListIterator(Node<T> head){
        Pointer = head;
    }

    public Node<T> getPointer(){
        return Pointer;
    }

    @Override
    public boolean hasNext() {
        return Pointer != null;
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        T content = Pointer.getContent();
        Pointer = Pointer.getNext();
        return content;
    }
}
