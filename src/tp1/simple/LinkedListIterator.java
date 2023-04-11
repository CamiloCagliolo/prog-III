package tp1.simple;

import tp1.AbstractIterator;
import java.util.Iterator;

public class LinkedListIterator<T> extends AbstractIterator<T, Node<T>> implements Iterator<T> {

    public LinkedListIterator(Node<T> head){
        pointer = head;
    }
}
