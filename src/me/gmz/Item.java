package me.gmz;

public class Item {
    public Item(String name, float weight, float value){
        this.name = name;
        this.weight = weight;
        this.value = value;
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

    private float weight;
    private float value;
    private String name;
}
