package tp1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> current;

    public LinkedListIterator(Node<T> head){
        current = head;
    }

    public T getCurrentContent(){
        return current.getContent();
    }

    public Node<T> getCurrent(){
        return current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        T content = current.getContent();
        current = current.getNext();
        return content;
    }
}
