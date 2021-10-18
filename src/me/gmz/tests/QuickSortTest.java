package me.gmz.tests;

import me.gmz.util.QuickSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class QuickSortTest {
    private static final Random r = new Random();

    @Test
    public void test() {
        for(int i = 0; i < 50; ++i){
            List<Float> asc = generateRandomList();
            List<Float> desc = generateRandomList();

            QuickSort.sort(asc);
            QuickSort.sort(desc, (a, b) -> (int)Math.signum(b - a));

            assertTrue(isAscendingOrdered(asc));
            assertTrue(isDescendingOrdered(desc));
        }
    }

    public boolean isAscendingOrdered(List<Float> list) {
        for(int i = 0; i < list.size() - 1; ++i)
            if(list.get(i) > list.get(i + 1))
                return false;
        return true;
    }

    public boolean isDescendingOrdered(List<Float> list) {
        for(int i = 0; i < list.size() - 1; ++i)
            if(list.get(i) < list.get(i + 1))
                return false;
        return true;
    }

    public List<Float> generateRandomList() {
        ArrayList<Float> list = new ArrayList<>();

        int listSize = r.nextInt(50);
        for(int i = 0; i < listSize; ++i)
            list.add(r.nextFloat()*200);

        return list;
    }
}
