package tp1.doublelist;

import tp1.AbstractIterator;
import java.util.Iterator;

public class DoubleLinkedListIterator<T> extends AbstractIterator<T, DoubleNode<T>> implements Iterator<T> {

    public DoubleLinkedListIterator(DoubleNode<T> head){
        pointer = head;
    }

}
