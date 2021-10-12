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

        System.out.println(getMaximumValue(tree));

        return result;
    }

    private void fillTree(Tree<Item> tree, ArrayList<Item> data, int elementIndex) {
        if(elementIndex >= data.size()) {
            //Supprimer des nodes si besoin (tant que l'arbre n'a pas de "frère")
            return;
        }

        tree.setLeftSubTree(new Tree<>(data.get(elementIndex)));
        tree.setRightSubTree(new Tree<>(null));

        fillTree(tree.getLeftSubTree(), data, elementIndex + 1); //Ajouter que si ça ne dépasse pas le max ; si ça dépasse, vérifier que juste avant ça ne soit pas en-dessous de la borne min
        fillTree(tree.getRightSubTree(), data, elementIndex + 1); //Pareil ici
    }

    private float getMaximumValue(Tree<Item> tree) {
        float value = tree.getValue() == null? 0 : tree.getValue().getValue();

        if(tree.getLeftSubTree() == null && tree.getRightSubTree() == null)
            return value;

        if(tree.getLeftSubTree() == null)
            return value + getMaximumValue(tree.getRightSubTree());
        if(tree.getRightSubTree() == null)
            return value + getMaximumValue(tree.getLeftSubTree());

        return Math.max(value + getMaximumValue(tree.getLeftSubTree()), value + getMaximumValue(tree.getRightSubTree()));
    }
}
