package me.gmz.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

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
        children = new LinkedList<>();
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

    public Node<T> addChild(T childValue){
        Node<T> newNode = new Node<>(this, childValue);
        children.add(newNode);
        return newNode;
    }

    public List<Node<T>> getChildren(){
        return children;
    }

    public void removeChild(int childIndex){
        children.remove(childIndex);
    }

    public void removeChildIf(Predicate<? super Node<T>> predicate){
        children.removeIf(predicate);
    }
}
