package tp2.ordering;

import java.util.Arrays;

public class Main {
    public static void main(String [] args){
        int[] arrOriginal = createRandomArray(10000000, 0, 100000000);

        int[] arr1 = arrOriginal.clone();
        QuickSort sorter1 = new QuickSort();
        long startTime1 = System.currentTimeMillis();
        sorter1.sort(arr1);
        long endTime1 = System.currentTimeMillis();
        System.out.println("Total execution time for quicksort: " + (endTime1 - startTime1));

        int[] arr2 = arrOriginal.clone();
        MergeSort sorter2 = new MergeSort();
        long startTime2 = System.currentTimeMillis();
        sorter2.sort(arr2);
        long endTime2 = System.currentTimeMillis();
        System.out.println("Total execution time for mergesort: " + (endTime2 - startTime2));
    }

    //Complexity: O(n^2)
    public static void bubbleSort(int[] arr){
        int aux;
        for(int i = arr.length; i >= 0 ; i--){
            for(int j = 0; j < i-1; j++){
                if(arr[j] > arr[j+1]){
                    aux = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }
    //Complexity: O(n^2)
    public static void selectionSort(int[] arr){
        int aux;
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
               if(arr[i] > arr[j]){
                   aux = arr[i];
                   arr[i] = arr[j];
                   arr[j] = aux;
               }
            }
        }
    }

    //Este método elige dejar de pasar si detecta que ya está ordenado.
    public static void bubbleSortAdapt(int[] arr){
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped){
            swapped = false;
            j++;
            for(int i=0; i < arr.length-j; i++){
                if(arr[i] > arr[i+1]){
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public static String imprimirArreglo(int[] arr){
        String arreglo = "[" + arr[0];
        for(int i = 1; i < arr.length - 1; i++){
            arreglo = arreglo + ", " + arr[i];
        }
        arreglo += ", " + arr[arr.length-1] + "]";
        return arreglo;
    }

    public static int[] createRandomArray(int size, int min, int max){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = (int) (Math.random()*(max-min) + min);
        }
        return arr;
    }
}
