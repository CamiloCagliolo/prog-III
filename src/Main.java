import tp1.doublelist.DoubleLinkedList;
import tp1.simple.LinkedList;

public class Main {
    public static void main(String[] args) {
        /*LinkedList<Integer> list1 = new LinkedList<>();

        list1.add(5);
        list1.add(3);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        list1.add(1);

        LinkedList<Integer> list2 = new LinkedList<>();

        list2.add(2);
        list2.add(4);
        list2.add(1);
        list2.add(10);
        list2.add(9);
        list2.add(5);

        System.out.println(list1);
        System.out.println(list2);

        System.out.println(LinkedList.orderedIntersection(list1, list2));*/

        /*DoubleLinkedList<Integer> doublelist = new DoubleLinkedList<>();

        doublelist.add(2);
        doublelist.add(8);
        doublelist.add(3);
        doublelist.add(1);
        doublelist.add(9);
        doublelist.add(14);
        doublelist.add(12);
        doublelist.add(13);

        System.out.println(doublelist);
        System.out.println(doublelist.get(6));

        System.out.println(isPalindrome("abcba"));*/

        Integer[] arr = new Integer[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }

        System.out.println(arrayIsOrdered(arr));
    }

    public static boolean isPalindrome(String s){
        if(s.length() == 1 || s.length() == 0){
            return true;
        }

        if(s.charAt(0) == s.charAt(s.length()-1)){
            return isPalindrome(s.substring(1,s.length()-1));
        }
        else{
            return false;
        }
    }

    public static <S extends Comparable<S>> boolean arrayIsOrdered(S[] arr){
        return check(0, arr);
    }

    public static <S extends Comparable<S>> boolean check(int index, S[] arr){
        if(index + 1 >= arr.length){
           return true;
        }
        if(arr[index].compareTo(arr[index+1]) < 0){
            return check(index+1, arr);
        }
        else{
            return false;
        }
    }
}