package me.gmz.solvers;

import me.gmz.backpack.Backpack;
import me.gmz.backpack.ISolver;
import me.gmz.backpack.Item;
import me.gmz.backpack.ItemCannotBeAddedException;
import me.gmz.tree.Tree;

import java.util.ArrayList;

public class BranchAndBoundSolver implements ISolver {
    @Override
    public Backpack solve(ArrayList<Item> data, float backpackWeight) {
        Backpack result = new Backpack(backpackWeight);

        Tree<Item> tree = new Tree<>(null); //The first value of the tree is the empty set
        fillTree(tree, data, 0);

        return new Backpack(12.f);
    }

    private void fillTree(Tree<Item> tree, ArrayList<Item> data, int elementIndex) {
        if(elementIndex >= data.size())
            return;

        tree.setLeftSubTree(new Tree<>(data.get(elementIndex)));
        fillTree(tree.getLeftSubTree(), data, elementIndex + 1);
        tree.setRightSubTree(new Tree<>(null));
        fillTree(tree.getRightSubTree(), data, elementIndex + 1);
    }

    private
}
