package tp1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractIterator<T, N extends AbstractNode<T, N>> implements Iterator<T> {
    protected N pointer;

    public N getPointer(){
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
