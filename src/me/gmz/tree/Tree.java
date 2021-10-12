package me.gmz.tree;

public class Tree<T> {
    private T value;
    private Tree<T> leftSubTree;
    private Tree<T> rightSubTree;
    private Tree<T> parent;

    public Tree() {
        this.value = null;
        this.leftSubTree = null;
        this.rightSubTree = null;
        this.parent = null;
    }

    public Tree(T value) {
        this();
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Tree<T> getLeftSubTree() {
        return leftSubTree;
    }

    public void setLeftSubTree(Tree<T> leftSubTree) {
        this.leftSubTree = leftSubTree;
        this.leftSubTree.setParent(this);
    }

    public Tree<T> getRightSubTree() {
        return rightSubTree;
    }

    public void setRightSubTree(Tree<T> rightSubTree) {
        this.rightSubTree = rightSubTree;
        this.rightSubTree.setParent(this);
    }

    public Tree<T> getParent() {
        return parent;
    }

    public void setParent(Tree<T> parent) {
        this.parent = parent;
    }
}
