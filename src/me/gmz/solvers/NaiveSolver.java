package me.gmz.solvers;

import me.gmz.backpack.Backpack;
import me.gmz.backpack.ISolver;
import me.gmz.backpack.Item;
import me.gmz.backpack.ItemCannotBeAddedException;
import me.gmz.util.QuickSort;

import java.util.ArrayList;

public class NaiveSolver implements ISolver {
    private int normalize(float value){
        if(value > 0.) return 1;
        if(value < 0.) return -1;
        return 0;
    }

    @Override
    public Backpack solve(ArrayList<Item> data, float backpackWeight) {
        Backpack result = new Backpack(backpackWeight);

        QuickSort.sort(data, (first, second) ->
            normalize(-((first.getValue()/first.getWeight()) - (second.getValue()/second.getWeight())))
        );

        for(Item item: data){
            try{
                result.addItem(item);
            }catch (ItemCannotBeAddedException e){
            }
        }

        return result;
    }
}
