package tp2.binarysearchtree;

import java.util.Iterator;
import java.util.List;

public class Tree implements Iterable<Integer>{
    private Node root;

    public Integer getRoot(){
        return root.getValue();
    }

    public boolean hasElement(Integer el){
        return false;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(Integer el){
        Node newNode = new Node(el);
        if(isEmpty()){
            root = newNode;
            return;
        }

        TreeIterator iterator = iterator();
        Node pointer = iterator.getPointer();

        while(iterator.hasNext()){
            if(pointer.getValue().compareTo(el) == 0){
                return;
            }
            else if(pointer.getValue().compareTo(el) < 0){
                if(pointer.hasLeft()){
                    pointer = iterator.goLeft();
                }
                else{
                    pointer.setLeft(newNode);
                    return;
                }
            }
            else{
                if(pointer.hasRight()){
                    pointer = iterator.goRight();
                }
                else{
                    pointer.setRight(newNode);
                    return;
                }
            }
        }
    }

    public boolean delete(Integer el){

    }

    public int getHeight(){

    }

    public void printPosOrder(){

    }

    public void printPreOrder(){

    }

    public void printInOrder(){

    }

    public List<Integer> getLongestBranch(){

    }

    public List<Integer> getFrontera(){

    }

    public Integer getMaxElement(){

    }

    public List<Integer> getElementsAtLevel(int level){

    }


    @Override
    public TreeIterator iterator() {
        return new TreeIterator(root);
    }
}
