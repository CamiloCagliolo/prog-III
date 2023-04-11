package tp1;

import tp1.simple.LinkedList;

public class Stack<T> {
    private LinkedList<T> list;

    public Stack(){
        list = new LinkedList<>();
    }

    public void push(T o){
        list.insertFront(o);
    }

    public T pop(){
        return list.extractFront();
    }

    public T top(){
        return list.get(0);
    }

    public void reverse(){
        LinkedList<T> newList = new LinkedList<>();
        int size = list.size();
        for(int i = 0; i < size; i++){
            newList.insertFront(list.extractFront());
        }
        list = newList;
    }
}
