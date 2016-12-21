package TB;

import Entity.SortingAlgos.Sorting;

/**
 * Created by Carioca on 19/12/2016.
 */
public class SortingTest {
    static final int ARRAY_SIZE = 90;
    public static void main(String[] args) {
        Integer []array = new Integer[ARRAY_SIZE];
        for(int i=0; i<ARRAY_SIZE; i++){
            array[i] = (int)(Math.random() * 20);
        }
        ShowArray(array);
        Sorting.QuickSort(array);
        ShowArray(array);
    }

    static <T extends Comparable<T>> void ShowArray(T []array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        for (int i = 1; i < array.length; i++) {
            if(array[i-1].compareTo(array[i]) == 1) {
                System.out.println("unsorted");
                break;
            }
        }
    }
}
