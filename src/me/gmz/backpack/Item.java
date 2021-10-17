package me.gmz.backpack;

public class Item {
    private final float weight;
    private final float value;
    private final float ratio;
    private final String name;

    public Item(String name, float weight, float value){
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.ratio = value / weight;
    }

    public String getName(){
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public float getValue() {
        return value;
    }

    public float getRatio() {
        return ratio;
    }
}
