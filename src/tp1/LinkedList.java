package tp1;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedList<T> implements Iterable<T>{
    private Node<T> first;
    private int size;

    public LinkedList(){
        first = null;
        size = 0;
    }

    public void insertFront(T content){
        Node<T> node = new Node<>(content);
        node.setNext(first);
        first = node;
        size++;
    }

    public T extractFront(){
        if(isEmpty()){
            return null;
        }
        Node<T> second = first.getNext();
        T content = first.getContent();
        first = second;
        size--;
        return content;
    }

    public void add(T content){
        Node<T> node = new Node<>(content);
        if(isEmpty()){
            first = node;
            return;
        }
        Node<T> aux = first;
        while(aux.hasNext()){
            aux = aux.getNext();
        }
        aux.setNext(node);
        size++;
    }

    public void delete(T content){
        int deleted = 0;
        while(first != null && first.getContent().equals(content)){
            first = first.getNext();
            deleted++;
        }
        LinkedListIterator<T> iterator = iterator();
        Node<T> next;
        while(iterator.hasNext() && iterator.getPointer().hasNext()){
            next = iterator.getPointer().getNext();
            if(content.equals(next.getContent())){
                iterator.getPointer().setNext(next.getNext());
                deleted++;
            }
            iterator.next();
        }
        size = size - deleted;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public T get(int index){
        if(isEmpty() || index < 0 || index >= size){
            return null;
        }
        Node<T> aux = first;
        for(int i = 1; i <= index; i++){
            if(aux.hasNext()){
                aux = aux.getNext();
            }
        }
        return aux.getContent();
    }

    public int size(){
        return size;
    }

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

    @Override
    public LinkedListIterator<T> iterator() {
        return new LinkedListIterator<T>(first);
    }

    public static <S extends Comparable<S>> LinkedList<S> orderedIntersection(LinkedList<S> l1, LinkedList<S> l2){
        LinkedList<S> result = new LinkedList<>();
        for(S elementFromL1 : l1){
            for(S elementFromL2 : l2){
                if(elementFromL1.equals(elementFromL2)){
                    LinkedList.insertWithOrder(result, elementFromL1);
                }
            }
        }
        return result;
    }

    public static <S> void substraction(LinkedList<S> l1, LinkedList<S> l2){
        for(S el2 : l2){
           l1.delete(el2);
        }
    }

    private static <S extends Comparable<S>> void insertWithOrder(LinkedList<S> list, S element){
        LinkedList<S> auxList = new LinkedList<>();
        S aux;
        aux = list.extractFront();
        while(aux != null && aux.compareTo(element) < 0){
            auxList.insertFront(aux);
            aux = list.extractFront();
        }
        if(auxList.isEmpty()){
            list.insertFront(aux);
        }
        list.insertFront(element);
        while(auxList.size() > 0){
            list.insertFront(auxList.extractFront());
        }
    }
}
