package me.gmz.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class QuickSort {
    private static final Random random = new Random();

    public static<T extends Comparable<T>> void sort(List<T> array) {
        sort(array, T::compareTo);
    }

    public static<T> void sort(List<T> array, Comparator<? super T> comparator){
        quicksortRec(array, 0, array.size() - 1, comparator);
    }

    private static<T> void quicksortRec(List<T> array, int firstIndex, int lastIndex, Comparator<? super T> comparator){
        if(firstIndex < lastIndex){
            int pivotIndex = random.nextInt(lastIndex - firstIndex) + firstIndex;
            pivotIndex = partition(array, firstIndex, lastIndex, pivotIndex, comparator);
            quicksortRec(array, firstIndex, pivotIndex-1, comparator);
            quicksortRec(array, pivotIndex+1, lastIndex, comparator);
        }
    }

    private static<T> int partition(List<T> array, int firstIndex, int lastIndex, int pivotIndex, Comparator<? super T> comparator){
        Collections.swap(array, pivotIndex, lastIndex);

        int j = firstIndex;
        for(int i = j; i < lastIndex ; i++){
            if(comparator.compare(array.get(i), array.get(lastIndex)) <= 0){
                Collections.swap(array, i, j);
                j++;
            }
        }

        Collections.swap(array, lastIndex, j);
        return j;
    }
}
