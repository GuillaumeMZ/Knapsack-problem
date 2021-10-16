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

        Tree<Backpack> tree = new Tree<>(new Backpack(backpackWeight)); //The first value of the tree is the empty set
        fillTree(tree, data, 0);

        System.out.println(getMaximumValue(tree, backpackWeight));

        return result;
    }

    private void fillTree(Tree<Backpack> tree, ArrayList<Item> data, int elementIndex) {
        if(elementIndex == data.size()) {
            //Supprimer des nodes si besoin (tant que l'arbre n'a pas de "frère")
            return;
        }

        tree.setLeftSubTree(new Tree<>(new Backpack(tree.getValue()))); //Ajouter que si ça ne dépasse pas le max ; si ça dépasse, vérifier que juste avant ça ne soit pas en-dessous de la borne min
        tree.getLeftSubTree().getValue().addItem(data.get(elementIndex));
        fillTree(tree.getLeftSubTree(), data, elementIndex + 1);

        tree.setRightSubTree(new Tree<>(new Backpack(tree.getValue())));
        fillTree(tree.getRightSubTree(), data, elementIndex + 1);
    }

    private Tree<Backpack> getMaximumValue(Tree<Backpack> tree, float backpackWeight) {

        if(tree.getLeftSubTree() == null && tree.getRightSubTree() == null)
            return tree;

        if(tree.getLeftSubTree() == null){
            if(tree.getRightSubTree().getValue().getCurrentWeight() > backpackWeight || valeur)
                return tree;
            return getMaximumValue(tree.getRightSubTree(), backpackWeight);
        }


    }
}
