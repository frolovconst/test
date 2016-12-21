package Entity.SortingAlgos;

/**
 * Created by Carioca on 19/12/2016.
 */
public class Sorting {
    public static <T extends Comparable<T>> void QuickSort(T []array){
        int lBorder = 0, rBorder = array.length-1;
//        while(lBorder < rBorder){
//
//        }
        QSort(array, lBorder, rBorder);
    }

    static <T extends Comparable<T>> int QSort(T []array, int leftIndx, int rightIndx){
        int LI = leftIndx, RI = rightIndx;
        T pivot = array[LI++];
        while(LI <= RI){
            while(array[LI++].compareTo(pivot) <= 0 && LI < rightIndx);
            while(array[RI--].compareTo(pivot) >= 0 && RI > leftIndx);
            QSortSwap(array, LI-1, RI+1);
        }
        return LI;
    }

    static <T extends Comparable<T>> void QSortSwap(T []array, int indx1, int indx2){
        T bfr = array[indx1];
        array[indx1] = array[indx2];
        array[indx2] = bfr;
    }
}
