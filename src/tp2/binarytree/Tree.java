package tp2.binarytree;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;

public class Tree<T> {
    private Node<T> root;

    //TODO: métodos básicos para poder manipular este árbol.

    //Ejercicio 4
    private void fillEmptyNodes(Node<Integer> n){
        if(n.hasLeft()){
            fillEmptyNodes(n.getLeft());
        }
        if(n.hasRight()){
            fillEmptyNodes(n.getRight());
        }
        fillInternalNode(n);
    }

    private void fillInternalNode(Node<Integer> n){
        if(n.hasNoChildren()){
            return;
        }
        Integer leftValue = 0;
        Integer rightValue = 0;
        if(n.hasLeft()){
            leftValue = n.getLeft().getValue();
        }
        if(n.hasRight()){
            rightValue = n.getRight().getValue();
        }
        n.setValue(rightValue - leftValue);
    }


    //Ejercicio 5: para árbol de caracteres
    private void getWordsWithLessThanNVocals(int n, String partialWord, Node<Character> node, ArrayList<String> arr){
        if(node.hasNoChildren()){
            String completeWord = partialWord + node.getValue();
            if(n == countVocals(completeWord)){
                arr.add(completeWord);
            }
        }
        if(node.hasLeft()){
            getWordsWithLessThanNVocals(n, partialWord + node.getValue(), node.getLeft(), arr);
        }
        if(node.hasRight()){
            getWordsWithLessThanNVocals(n, partialWord + node.getValue(), node.getRight(), arr);
        }
    }

    private int countVocals(String s){
        int count = 0;
        CharacterIterator it = new StringCharacterIterator(s);
        while(it.current() != CharacterIterator.DONE){
            char c = Character.toUpperCase(it.current());
            switch (c) {
                case 'A', 'E', 'I', 'O', 'U' -> count++;
            }
            it.next();
        }
        return count;
    }

}
