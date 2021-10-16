package me.gmz.tree;

public class Tree<T> {
    private T value;
    private Tree<T> leftSubTree;
    private Tree<T> rightSubTree;

    public Tree() {
        this.value = null;
        this.leftSubTree = null;
        this.rightSubTree = null;
    }

    public Tree(T value) {
        this();
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Tree<T> getLeftSubTree() {
        return leftSubTree;
    }

    public void setLeftSubTree(Tree<T> leftSubTree) {
        this.leftSubTree = leftSubTree;
    }

    public Tree<T> getRightSubTree() {
        return rightSubTree;
    }

    public void setRightSubTree(Tree<T> rightSubTree) {
        this.rightSubTree = rightSubTree;
    }
}
