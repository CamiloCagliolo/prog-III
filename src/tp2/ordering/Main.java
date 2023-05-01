package tp2.ordering;

import java.util.Arrays;

public class Main {
    public static void main(String [] args){
        int[] arr = createRandomArray(5, 0, 100);
        arr[1] = arr[0];
        arr[2] = arr[0];
        System.out.println(imprimirArreglo(arr));
        QuickSort sorter = new QuickSort();
        sorter.sort(arr);
        System.out.println(imprimirArreglo(arr));
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
