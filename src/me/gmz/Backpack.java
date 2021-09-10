package me.gmz;

import java.util.ArrayList;

public class Backpack {
    public Backpack(int maximumWeight){
        this.maximumWeight = maximumWeight;
        this.currentWeight = 0;
        this.currentValue = 0;
        items = new ArrayList<>();
    }

    public void addItem(Item item) throws ItemCannotBeAddedException{
        if(currentWeight + item.getWeight() <= maximumWeight){
            items.add(item);
            currentWeight += item.getWeight();
            currentValue += item.getValue();
        }

        throw new ItemCannotBeAddedException("This item cannot be added.");
    }

    public int getCurrentWeight(){
        return currentWeight;
    }

    public int getCurrentValue(){
        return currentValue;
    }

    private ArrayList<Item> items;
    private int maximumWeight, currentWeight, currentValue;
}
