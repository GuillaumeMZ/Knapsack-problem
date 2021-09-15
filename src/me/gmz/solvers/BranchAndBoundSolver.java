package me.gmz.solvers;

import me.gmz.backpack.Backpack;
import me.gmz.backpack.ISolver;
import me.gmz.backpack.Item;
import me.gmz.backpack.ItemCannotBeAddedException;
import me.gmz.tree.Node;
import me.gmz.tree.Tree;

import java.util.ArrayList;

public class BranchAndBoundSolver implements ISolver {
    @Override
    public Backpack solve(ArrayList<Item> data, float backpackWeight) {
        Backpack result = new Backpack(backpackWeight);

        Tree<Item> tree = new Tree<>(null); //The first value of the tree is the empty set
        fillTree(tree, data);
        Node<Item> bestPathLastNode = findBestValue(tree, backpackWeight);

        while(bestPathLastNode.getParent().getValue() != null){
            try {
                result.addItem(bestPathLastNode.getValue());
            } catch (ItemCannotBeAddedException e) {
                e.printStackTrace(); //Not normal: this item should be addable to the backpack
            }
            bestPathLastNode = bestPathLastNode.getParent();
        }

        return result;
    }

    //========================================= Tree walking utils======================================================

    private Node<Item> findBestValue(Tree<Item> itemTree, float maximumValue){
        float currentMaximumValue = 0.f;
        Node<Item> firstNode = null;

        for(Node<Item> itemNode : itemTree.getRoot().getChildren()){
            float currentPathValue = ...;

            if(currentPathValue >= currentMaximumValue && currentPathValue <= maximumValue){
                maximumValue = currentPathValue;
                firstNode = itemNode;
            }
        }
    }

    private float evaluatePath(Node<Item> itemNode, float currentValue){
        if(itemNode.getChildren() == null)
            return currentValue;
        else{
            for(Node<Item> childrenItems : itemNode.getChildren())

        }
    }

    //========================================= Tree filling utils =====================================================

    private void fillTree(Tree<Item> itemTree, ArrayList<Item> data){
        //Filling the first line of the tree with all the items
        for(int i = 0; i < data.size(); ++i){
            Node<Item> newNode = itemTree.getRoot().addChild(data.get(i));
            fillChildren(data, newNode, i); //Recursively filling the children
        }
    }

    private void fillChildren(ArrayList<Item> data, Node<Item> current, int parentIndex){
        if(parentIndex == data.size() - 1) //If we get to the last item, it means the current branch cannot be expanded anymore.
            return;

        for(int i = parentIndex + 1; i < data.size(); ++i){
            Node<Item> next = current.addChild(data.get(i));
            fillChildren(data, next, i);
        }
    }
}
