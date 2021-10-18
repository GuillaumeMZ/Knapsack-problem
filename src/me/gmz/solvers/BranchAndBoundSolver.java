package me.gmz.solvers;

import me.gmz.backpack.Backpack;
import me.gmz.backpack.ISolver;
import me.gmz.backpack.Item;
import me.gmz.tree.Tree;

import java.util.ArrayList;

public class BranchAndBoundSolver implements ISolver {
    private Backpack minimal;
    private ArrayList<Item> data;

    @Override
    public Backpack solve(ArrayList<Item> data, float backpackWeight) {
        minimal = new NaiveSolver().solve(data, backpackWeight); //Minimal value
        this.data = data;

        Tree<Backpack> tree = new Tree<>(new Backpack(backpackWeight)); //The first value of the tree is the empty set
        fillTree(tree, 0);

        return minimal; //The last minimal value is the maximal value
    }

    private void fillTree(Tree<Backpack> tree, int elementIndex) {
        if(elementIndex == data.size() || tree.getValue().getCurrentValue() + getRemainingItemsValue(elementIndex) < minimal.getCurrentValue()) {
            return;
        }

        Backpack next = new Backpack(tree.getValue());
        next.addItem(data.get(elementIndex));

        if(next.getCurrentWeight() <= next.getMaximumWeight()) {
            tree.setLeftSubTree(new Tree<>(next));

            if(next.getCurrentValue() > minimal.getCurrentValue())
                minimal = next;

            fillTree(tree.getLeftSubTree(), elementIndex + 1);
        }

        tree.setRightSubTree(new Tree<>(new Backpack(tree.getValue())));
        fillTree(tree.getRightSubTree(), elementIndex + 1);
    }

    private float getRemainingItemsValue(int indexStart) {
        float sum = 0;
        for(; indexStart < data.size(); ++indexStart)
            sum += data.get(indexStart).getValue();

        return sum;
    }
}
