package com.sparta.sj.Searchers;

import com.sparta.sj.Searchers.Exceptions.NodeNotFoundException;

import java.util.List;

public interface GenericBinaryTree<T extends Comparable>{
    T getRootElement();

    int getNumberOfElements();

    void addElement(T element) throws NodeNotFoundException;

    void addElements(List<T> elements) throws NodeNotFoundException;

    boolean findElement(T value) throws NodeNotFoundException;

    T getLeftChild(T element) throws NodeNotFoundException;

    T getRightChild(T element) throws NodeNotFoundException;

    List<T> getSortedTreeAsc() throws NodeNotFoundException;

    List<T> getSortedTreeDesc() throws NodeNotFoundException;

}
