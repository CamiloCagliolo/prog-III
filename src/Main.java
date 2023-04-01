import tp1.simple.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();

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

        System.out.println(LinkedList.orderedIntersection(list1, list2));

    }
}