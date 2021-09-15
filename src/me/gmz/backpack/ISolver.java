package me.gmz.backpack;

import java.util.ArrayList;

public interface ISolver {
    Backpack solve(ArrayList<Item> data, float backpackWeight);
}
