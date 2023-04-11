package tp1;

public abstract class AbstractNode<T, N extends AbstractNode<T, N>> {
    protected N next;
    protected T content;

    public boolean hasNext(){
        return next != null;
    }

    public void setNext(N n){
        next = n;
    }

    public void setContent(T c){
        content = c;
    }

    public N getNext(){
        return next;
    }

    public T getContent(){
        return content;
    }
}
