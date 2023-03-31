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
        /* IMPLEMENTACIÓN VIEJA SIN FOREACH
        do{
            if(aux.getContent().equals(object)){
                return index;
            }
            else{
                aux = aux.getNext();
                index++;
            }
        } while(aux != null);
        */
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
        LinkedList<S> auxList = new LinkedList<>();
        S aux;
        for(S elementFromL1 : l1){
            for(S elementFromL2 : l2){
                if(elementFromL1.equals(elementFromL2)){
                    //TODO: Esto funciona, pero ver cómo meter de forma ordenada los elementos usando las funciones básicas del iterator.
                    aux = result.extractFront();
                    while(aux != null && aux.compareTo(elementFromL1) < 0){
                        auxList.insertFront(aux);
                        aux = result.extractFront();
                    }
                    if(auxList.isEmpty()){
                        result.insertFront(aux);
                    }
                    result.insertFront(elementFromL1);
                    while(auxList.size() > 0){
                        result.insertFront(auxList.extractFront());
                    }
                }
            }
        }
        return result;
    }
}
