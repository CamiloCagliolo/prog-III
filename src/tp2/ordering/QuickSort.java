package tp2.ordering;
//Time complexity: O(n^2) in worst case (pivot is consistently choosing the maximum or minimum element in the array),
// or O(nlog(n)) in the average case (random ordering that makes the algorithm cut the array roughly in halves).
// This can be improved if the pivot is taken randomly.
public class QuickSort {
    private int[] arr;

    public void sort(int[] arr){
        this.arr = arr;
        sort(0, arr.length-1);
    }

    private void sort(int min, int max){
        if(min >= max){
            return;
        }
        int partition = partition(min, max);
        sort(min, partition);
        sort(partition + 1, max);
    }

    private int partition(int min, int max){
        int pivot = min;
        int current = min + 1;
        int aux1;
        int aux2;

        while(current <= max){
            if(arr[pivot] > arr[current]){
                aux1 = arr[pivot + 1];
                aux2 = arr[current];
                arr[pivot + 1] = arr[pivot];
                arr[pivot] = aux2;
                if(current != pivot + 1){
                    arr[current] = aux1;
                }
                pivot++;
            }
            current++;
        }
        return pivot;
    }
}
