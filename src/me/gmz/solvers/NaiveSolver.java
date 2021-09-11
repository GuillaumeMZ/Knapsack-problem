package me.gmz.solvers;

import me.gmz.Backpack;
import me.gmz.ISolver;
import me.gmz.Item;
import me.gmz.ItemCannotBeAddedException;

import java.util.ArrayList;
import java.util.Collections;

public class NaiveSolver implements ISolver {
    private int clamp(float value){
        if(value > 0.) return 1;
        if(value < 0.) return -1;
        return 0;
    }

    @Override
    public Backpack solve(ArrayList<Item> data, int backpackWeight) {
        Backpack result = new Backpack(backpackWeight);

        Collections.sort(data, (first, second) ->
            clamp((first.getValue()/first.getWeight()) - (second.getValue()/second.getWeight()))
        );

        for(Item item: data){
            try{
                result.addItem(item);
            }catch (ItemCannotBeAddedException e){
                //Let's do nothing.
            }
        }

        return result;
    }
}
