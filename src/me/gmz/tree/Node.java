package me.gmz.tree;

import java.util.LinkedList;

public class Node<T> {
    private T value;
    private Node<T> parent;
    private final LinkedList<Node<T>> children;

    public Node(){
        this(null, null);
    }

    public Node(T initialValue){
        this(null, initialValue);
    }

    public Node(Node<T> parent, T value){
        this.parent = parent;
        this.value = value;
        this.children = new LinkedList<>();
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public Node<T> getParent(){
        return parent;
    }

    public void setParent(Node<T> parent){
        this.parent = parent;
    }

    public void addChild(Node<T> child){
        children.add(child);
    }

    public LinkedList<Node<T>> getChildren(){
        return children;
    }

    public void removeChild(int childIndex){
        children.remove(childIndex);
    }
}
