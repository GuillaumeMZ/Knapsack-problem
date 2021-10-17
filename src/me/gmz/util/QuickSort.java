package me.gmz.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class QuickSort {
    //TODO better naming
    private static final Random r = new Random();

    //TODO default comparator
    public static<T> void sort(List<T> array, Comparator<? super T> comparator){
        quicksortRec(array, 0, array.size() - 1, comparator);
    }

    private static<T> void quicksortRec(List<T> array, int fi, int li, Comparator<? super T> comparator){
        if(fi < li){
            int pi = r.nextInt(li - fi) + fi;
            pi = partition(array, fi, array.size() - 1, pi, comparator);
            quicksortRec(array, fi, pi-1, comparator);
            quicksortRec(array, pi+1, li, comparator);
        }
    }

    private static<T> int partition(List<T> array, int fi, int li, int pi, Comparator<? super T> comparator){
        Collections.swap(array, pi, li);

        int j = fi;
        for(int i = j; i < li ; i++){
            if(comparator.compare(array.get(i), array.get(li)) <= 0){
                Collections.swap(array, i, j);
                j++;
            }
        }

        Collections.swap(array, li, j);
        return j;
    }
}
