package tp1.doublelist;

import tp1.AbstractLinkedList;
import tp1.simple.LinkedList;

public class DoubleLinkedList<T> extends AbstractLinkedList<T, DoubleNode<T>> implements Iterable<T>{

    @Override
    public DoubleLinkedListIterator<T> iterator() {
        return new DoubleLinkedListIterator<T>(first);
    }

    @Override
    public void insertFront(T content) {
        DoubleNode<T> node = new DoubleNode<>(content);
        first.setPrevious(node);
        super.insertFront(node);
    }

    @Override
    public T extractFront() {
        T content = super.extractFront();
        first.setPrevious(null);
        return content;
    }

    @Override
    public void add(T content){
        DoubleNode<T> node = new DoubleNode<>(content);
        DoubleNode<T> previous = super.add(node);
        node.setPrevious(previous);
    }

    @Override
    public void delete(T content){
        int deleted = 0;
        while(first != null && first.getContent().equals(content)){
            first = first.getNext();
            first.setPrevious(null);
            deleted++;
        }
        DoubleLinkedListIterator<T> iterator = iterator();
        DoubleNode<T> next;
        while(iterator.hasNext() && iterator.getPointer().hasNext()){
            next = iterator.getPointer().getNext();
            if(content.equals(next.getContent())){
                iterator.getPointer().setNext(next.getNext());
                next.getNext().setPrevious(iterator.getPointer());
                deleted++;
            }
            iterator.next();
        }
        size = size - deleted;
    }

    public T get(int index){
        if(isEmpty() || index < 0 || index >= size){
            return null;
        }
        DoubleNode<T> aux;
        if(index < size/2){
            aux = first;
            for(int i = 1; i <= index; i++){
                aux = aux.getNext();
            }
        }
        else{
            aux = last;
            for(int i = size-1; i > index; i--){
                aux = aux.getPrevious();
            }
        }
        return aux.getContent();
    }

    public static <S> void substraction(LinkedList<S> l1, LinkedList<S> l2){
        for(S el2 : l2){
            l1.delete(el2);
        }
    }
}
