package me.gmz.tree;

public class Tree<T> {
    private final Node<T> rootNode;

    public Tree(T initialValue){
        rootNode = new Node<>(null, initialValue);
    }

    public Node<T> getRoot(){
        return rootNode;
    }
}
