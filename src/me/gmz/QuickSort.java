package me.gmz;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class QuickSort {
    private static final Random r;

    static {
        r = new Random();
    }

    public static<T> void sort(List<T> array, Comparator<? super T> comparator){
        quicksortRec(array, 0, array.size() - 1, comparator);
    }

    private static<T> void quicksortRec(List<T> array, int fi, int li, Comparator<? super T> comparator){
        if(fi < li){
            int pi = r.nextInt(li - fi) + fi;
            pi = partition(array, fi, array.size() - 1, pi, comparator);
            quicksortRec(array, fi, pi, comparator);
            quicksortRec(array, pi+1, li, comparator);
        }
    }

    private static<T> void swap(List<T> array, int firstIndex, int secondIndex){
        T temp = array.get(firstIndex);
        array.set(firstIndex, array.get(secondIndex));
        array.set(secondIndex, temp);
    }

    private static<T> int partition(List<T> array, int fi, int li, int pi, Comparator<? super T> comparator){
        swap(array, pi, li);

        int j = fi;
        for(int i = j; i < li ; i++){
            if(comparator.compare(array.get(i), array.get(li)) <= 0){
                swap(array, i, j);
                j++;
            }
        }

        swap(array, li, j);
        return j;
    }
}
