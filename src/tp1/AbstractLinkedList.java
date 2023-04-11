package tp1;

public abstract class AbstractLinkedList<T, N extends AbstractNode<T, N>> implements Iterable<T>{
    protected N first;
    protected N last;
    protected int size;

    public int size(){
        return size;
    }

    protected void incrementSize(){
        size++;
    }

    protected void decrementSize(){
        size--;
    }

    public boolean isEmpty(){
        return first == null;
    };

    public abstract void insertFront(T content);

    protected void insertFront(N node){
        node.setNext(first);
        first = node;
        incrementSize();
    }

    public T extractFront(){
        if(isEmpty()){
            return null;
        }
        N second = first.getNext();
        T content = first.getContent();
        first = second;
        decrementSize();
        return content;
    };

    public abstract void add(T content);

    protected N add(N node){
        if(isEmpty()){
            first = node;
        }
        else{
            last.setNext(node);
        }
        N previous = last;
        last = node;
        incrementSize();
        return previous;
    }

    public abstract void delete(T content);

    public int indexOf(T object){
        if(isEmpty()){
            return -1;
        }
        int index = 0;
        for(T element : this){
            if(element.equals(object)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean contains(T object){
        if(isEmpty()){
            return false;
        }
        for(T element : this){
            if(element.equals(object)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String result = "";
        if(!isEmpty()){
            int index = 0;
            for(T element : this){
                result += "[" + index + "] => " + element + "\n";
                index++;
            }
        }
        return result;
    }
}
