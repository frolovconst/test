package Entity.SortingAlgos;

/**
 * Created by Carioca on 19/12/2016.
 */
public class Sorting {
    public static <T extends Comparable<T>> void QuickSort(T []array){
        int lBorder = 0, rBorder = array.length-1;
        QSort(array, lBorder, rBorder);
    }

    static <T extends Comparable<T>> void QSort(T []array, int LI, int RI){
        if(LI >= RI)
            return;
        int mdlIndx = QSortPartition(array, LI, RI);
        QSort(array, LI, mdlIndx-1);
        QSort(array, mdlIndx+1, RI);
    }

    static <T extends Comparable<T>> int QSortPartition(T []array, int leftIndx, int rightIndx){
        int LI = leftIndx, RI = rightIndx;
        T pivot = array[LI++];
        while(LI < RI){
             while(array[LI].compareTo(pivot) < 0 && LI < rightIndx)
                LI++;
            while(array[RI].compareTo(pivot) >= 0 && RI > LI)
                RI--;
            QSortPartitionSwap(array, LI, RI);
        }
        if(array[LI].compareTo(pivot) < 0) {
            QSortPartitionSwap(array, leftIndx, LI);
            return LI;
        }
        else {
            QSortPartitionSwap(array, leftIndx, LI - 1);
            return LI - 1;
        }
    }

    static <T extends Comparable<T>> void QSortPartitionSwap(T []array, int indx1, int indx2){
        T bfr = array[indx1];
        array[indx1] = array[indx2];
        array[indx2] = bfr;
    }
}
