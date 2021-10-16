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

        QuickSort.sort(data, (first, second) ->
                (int)Math.signum(-((first.getValue()/first.getWeight()) - (second.getValue()/second.getWeight())))
        );

        for (Item current : data) {
            if (result.getCurrentWeight() + current.getValue() > backpackWeight)
                break;

            result.addItem(current);
        }

        return result;
    }
}
