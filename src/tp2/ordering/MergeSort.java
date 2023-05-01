package tp2.ordering;

//Time complexity: O(nlog(n)) for all cases.
public class MergeSort {
    private int[] arr;
    private int[] helper;

    public void sort(int[] values){
        this.arr = values;
        int size = values.length;
        this.helper = new int[size];
        mergeSort(0, size-1);
    }

    private void mergeSort(int low, int high){
        if(low < high){
            int middle = (low + high)/2;
            mergeSort(low, middle);
            mergeSort(middle+1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high){
        for(int i = low; i < high; i++){
            helper[i] = arr[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while(i <= middle && j <= high){
            if(helper[i] <= helper[j]){
                arr[k] = helper[i];
                i++;
            }
            else{
                arr[k] = helper[j];
                j++;
            }
            k++;
        }

        while(i <= middle){
            arr[k] = helper[i];
            k++;
            i++;
        }

        while(j <= high){
            arr[k] = helper[j];
            k++;
            j++;
        }
    }
}
