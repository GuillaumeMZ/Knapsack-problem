package me.gmz.solvers;

import me.gmz.backpack.Backpack;
import me.gmz.backpack.ISolver;
import me.gmz.backpack.Item;
import me.gmz.tree.Tree;

import java.util.ArrayList;

public class BranchAndBoundSolver implements ISolver {
    @Override
    public Backpack solve(ArrayList<Item> data, float backpackWeight) {
        Tree<Backpack> tree = new Tree<>(new Backpack(backpackWeight)); //The first value of the tree is the empty set
        fillTree(tree, data, 0);

        return getMaximumValue(tree).getValue();
    }

    private void fillTree(Tree<Backpack> tree, ArrayList<Item> data, int elementIndex) {
        if(elementIndex == data.size()) {
            return;
        }

        Backpack next = new Backpack(tree.getValue());
        next.addItem(data.get(elementIndex));

        if(next.getCurrentWeight() <= next.getMaximumWeight()) {
            tree.setLeftSubTree(new Tree<>(next));
            fillTree(tree.getLeftSubTree(), data, elementIndex + 1);
        }

        tree.setRightSubTree(new Tree<>(new Backpack(tree.getValue())));
        fillTree(tree.getRightSubTree(), data, elementIndex + 1);
    }

    private Tree<Backpack> getMaximumValue(Tree<Backpack> tree) { //Since the tree doesn't have a combination whose value is greater than the maximum, we don't need to pass the maximum as an argument
        if(tree.getLeftSubTree() == null && tree.getRightSubTree() == null)
            return tree;
        if(tree.getLeftSubTree() == null)
            return getMaximumValue(tree.getRightSubTree());
        if(tree.getRightSubTree() == null)
            return getMaximumValue(tree.getLeftSubTree());

        Tree<Backpack> resultLeft = getMaximumValue(tree.getLeftSubTree());
        Tree<Backpack> resultRight = getMaximumValue(tree.getRightSubTree());

        return resultLeft.getValue().getCurrentValue() > resultRight.getValue().getCurrentValue() ? resultLeft : resultRight;
    }
}
