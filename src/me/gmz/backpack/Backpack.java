package me.gmz.backpack;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This backpack, which can contain ")
            .append(maximumWeight)
            .append("kg of objects contains ")
            .append(items.size())
            .append(" items, for a total weight of ")
            .append(currentWeight)
            .append(" (")
            .append(maximumWeight - currentWeight)
            .append(" kg remaining). Its value is ")
            .append(currentValue).append("$\n");

        for(Item item : items){
            sb.append("- ").append(item.getName()).append(" (value: ").append(item.getValue()).append(", weight: ").append(item.getWeight()).append(")\n");
        }

        return sb.toString();
    }

    private final ArrayList<Item> items;
    private float currentWeight;
    private float currentValue;
    private final float maximumWeight;
}
