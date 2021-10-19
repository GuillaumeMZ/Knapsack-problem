package me.gmz.solvers;

import me.gmz.backpack.Backpack;
import me.gmz.backpack.ISolver;
import me.gmz.backpack.Item;
import me.gmz.util.QuickSort;

import java.util.ArrayList;

public class NaiveSolver implements ISolver {

    @Override
    public Backpack solve(ArrayList<Item> data, float backpackWeight) {
        Backpack result = new Backpack(backpackWeight);
        data = new ArrayList<>(data); //We are making a copy of the datalist so the original list order stays the same

        QuickSort.sort(data, (first, second) ->
                (int)Math.signum(second.getRatio() - first.getRatio()) //Sorting in descending order, based on ratio
        );

        for (Item current : data) {
            if (result.getCurrentWeight() + current.getWeight() > backpackWeight) //If the current item cannot be added to the backpack, then we just ignore it
                continue;

            result.addItem(current);
        }

        return result;
    }
}
