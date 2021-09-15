package me.gmz.solvers;

import me.gmz.backpack.Backpack;
import me.gmz.backpack.ISolver;
import me.gmz.backpack.Item;
import me.gmz.tree.Tree;

import java.util.ArrayList;

public class BranchAndBoundSolver implements ISolver {
    @Override
    public Backpack solve(ArrayList<Item> data, float backpackWeight) {
        Backpack result = new Backpack(backpackWeight);

        Tree<Item> tree = new Tree<>(null); //The first value of the tree is the empty set

        return result;
    }
}
