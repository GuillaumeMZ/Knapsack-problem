package me.gmz.tests;

import me.gmz.util.QuickSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class QuickSortTest {
    private static Random r = new Random();

    @Test
    public void test() {
        for(int i = 0; i < 50; ++i){
            ArrayList<Float> asc = generateRandomList();
            ArrayList<Float> desc = generateRandomList();

            QuickSort.sort(asc, (a, b) -> (int)Math.signum(a - b));
            QuickSort.sort(desc, (a, b) -> (int)Math.signum(b - a));

            assertTrue(isAscendingOrdered(asc));
            assertTrue(isDescendingOrdered(desc));
        }
    }

    public boolean isAscendingOrdered(ArrayList<Float> list) {
        for(int i = 0; i < list.size() - 1; ++i)
            if(list.get(i) > list.get(i + 1))
                return false;
        return true;
    }

    public boolean isDescendingOrdered(ArrayList<Float> list) {
        for(int i = 0; i < list.size() - 1; ++i)
            if(list.get(i) < list.get(i + 1))
                return false;
        return true;
    }

    public ArrayList<Float> generateRandomList() {
        ArrayList<Float> list = new ArrayList<>();

        int listSize = r.nextInt(50);
        for(int i = 0; i < listSize; ++i)
            list.add(r.nextFloat()*200);

        return list;
    }
}
