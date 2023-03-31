package tp1;

public class Node<T> {
    private Node<T> next;
    private T content;

    public Node(Node<T> n, T c){
        next = n;
        content = c;
    }

    public Node(T c){
        next = null;
        content = c;
    }

    public boolean hasNext(){
        return next != null;
    }

    public void setNext(Node<T> n){
        next = n;
    }

    public void setContent(T c){
        content = c;
    }

    public Node<T> getNext(){
        return next;
    }

    public T getContent(){
        return content;
    }
}
