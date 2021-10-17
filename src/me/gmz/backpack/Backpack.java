package me.gmz.backpack;

import java.util.ArrayList;

public class Backpack {
    private final ArrayList<Item> items;
    private float currentWeight;
    private float currentValue;
    private final float maximumWeight;

    public Backpack(float maximumWeight){
        this.maximumWeight = maximumWeight;
        this.currentWeight = 0;
        this.currentValue = 0;
        items = new ArrayList<>();
    }

    public Backpack(Backpack another) {
        this.items = new ArrayList<>(another.items);
        this.currentValue = another.currentValue;
        this.currentWeight = another.currentWeight;
        this.maximumWeight = another.maximumWeight;
    }

    public void addItem(Item item){
        items.add(item);
        currentWeight += item.getWeight();
        currentValue += item.getValue();
    }

    public float getCurrentWeight() {
        return currentWeight;
    }

    public float getCurrentValue() {
        return currentValue;
    }

    public float getMaximumWeight() {
        return maximumWeight;
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

        for (Item item : items) {
            sb.append("- ").append(item.getName()).append(" (value: ").append(item.getValue()).append(", weight: ").append(item.getWeight()).append(")\n");
        }

        return sb.toString();
    }
}
