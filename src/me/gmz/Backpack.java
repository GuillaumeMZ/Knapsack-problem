package me.gmz;

import java.util.ArrayList;

public class Backpack {
    public Backpack(float maximumWeight){
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

            return;
        }

        throw new ItemCannotBeAddedException("This item cannot be added.");
    }

    public float getCurrentWeight(){
        return currentWeight;
    }

    public float getCurrentValue(){
        return currentValue;
    }

    public float getFreeSpace(){
        return maximumWeight - currentWeight;
    }

    private ArrayList<Item> items;
    private float currentWeight;
    private float currentValue;
    private final float maximumWeight;
}
