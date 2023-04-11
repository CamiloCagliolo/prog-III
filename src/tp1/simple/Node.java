package tp1.simple;

import tp1.AbstractNode;

public class Node<T> extends AbstractNode<T, Node<T>> {

    public Node(Node<T> n, T c){
        next = n;
        content = c;
    }

    public Node(T c){
        next = null;
        content = c;
    }
}
