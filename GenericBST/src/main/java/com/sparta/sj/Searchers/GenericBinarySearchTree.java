package com.sparta.sj.Searchers;

import com.sparta.sj.Searchers.Exceptions.NodeNotFoundException;
import com.sparta.sj.Searchers.Objects.Employee;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class GenericBinarySearchTree<T extends Comparable> implements GenericBinaryTree<T> {

    private Node root;
    private int counter;
    private Node currentNode;
    private LinkedList<T> ascendingList;
    private LinkedList<T> descendingList;
    private LinkedList<T> stack;
    final static Logger logger = Logger.getLogger(GenericBinarySearchTree.class);

    private class Node {


        private final T value;
        private Node left;
        private Node right;


        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public Node getLeft(){
           return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight(){
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

    }


    @Override
    public T getRootElement(){
        return root.getValue();
    }

    @Override
    public int getNumberOfElements(){
        return counter;
    }

    @Override
    public void addElement(T element){
        if (root == null) {
            root = new Node(element);
        } else {
            addElementHelper(element, root);
        }
        counter++;
    }

    @Override
    public void addElements(List<T> elements)  {
        for (int i = 0; i < elements.size(); i++) {
            addElement(elements.get(i));
        }
    }

    @Override
    public boolean findElement(T value) throws NodeNotFoundException {
        try {
            return findElementHelper(value, root);
        }catch(NodeNotFoundException e){
            logger.error("Node not found findElement: "+ e);
        }
        throw new NodeNotFoundException();
    }

    @Override
    public T getLeftChild(T element) throws NodeNotFoundException{
            Node node = findNode(element, root);
            if(!hasLeft(node)) {
                throw new NodeNotFoundException("currentNode: "+((Employee) node.getValue()).getName());
            }else{
                return node.getLeft().getValue();
            }
    }

    @Override
    public T getRightChild(T element) throws NodeNotFoundException {

            Node node = findNode(element, root);
            if(hasRight(node)){
                return node.getRight().getValue();
            }else{
                throw new NodeNotFoundException();
            }

    }

    @Override
    public List<T> getSortedTreeAsc() throws NodeNotFoundException {
        try {
            return sortedListHelper(root);
        }catch(NodeNotFoundException e){
            logger.error("Node not found: "+ e);
            throw new NodeNotFoundException();
        }

    }

    @Override
    public List<T> getSortedTreeDesc() throws NodeNotFoundException {
        try {
            List<T> ls = getSortedTreeAsc();
            List<T> newls = new LinkedList<>();

            for (int i = ls.size() - 1; i >= 0; i--) {
                newls.add(ls.get(i));
            }
            return newls;
        }
        catch(NodeNotFoundException e){
            logger.error("Node not found: "+ e);
            throw new NodeNotFoundException();
        }

    }

    public boolean hasRight(Node current) {
        try {

            if (current.getRight()!=null) {
                return true;
            }else{

                return false;
            }
        }
        catch(NullPointerException e){
            logger.error("No left node: ", e);
            return false;
        }
    }

    public boolean hasLeft(Node current){
        try {
            if (current.getLeft()!=null) {
                return true;
            } else {
                return false;
            }
        }
        catch(NullPointerException e){
            logger.error("No left node: ", e);
            return false;
        }
    }

    //Add element in the correct place if the element is not null
    private void addElementHelper(T element, Node current) {

            T currentElement = current.getValue();
            Node node = new Node(element);
            if (element.compareTo(currentElement) == -1) {
                if (current.getLeft() == null) {
                    current.setLeft(node);
                } else if (current.getLeft() != null) {
                    current = current.getLeft();
                    addElementHelper(element, current);
                }
            } else if (element.compareTo(currentElement) == 1) {
                if (current.getRight() == null) {
                    current.setRight(node);
                } else if (current.getRight() != null) {
                    current = current.getRight();
                    addElementHelper(element, current);
                }
            }

    }

    //finds element in the correct place if the element is null returns false
    private boolean findElementHelper(T element, Node current) throws NodeNotFoundException{

            T currentElement = current.getValue();
            boolean found = false;

            if (element.compareTo(currentElement) == 0) {
                found = true;
            } else if (element.compareTo(currentElement) == -1) {
                if (current.getLeft() == null) {
                    found = false;
                } else if (current.getLeft() != null) {
                    current = current.getLeft();
                    found = findElementHelper(element, current);
                }
            } else if (element.compareTo(currentElement) == 1) {
                if (current.getRight() == null) {
                    found = false;
                } else if (current.getRight() != null) {
                    current = current.getRight();
                    found = findElementHelper(element, current);
                }
            }
            return found;

    }

    //finds the node that matches the element
    private Node findNode(T element, Node current){

            T currentElement = current.getValue();

            if (element.equals(currentElement)) {
                currentNode = current;
                return current;

            }
            if (element.compareTo(currentElement) == -1) {
                if (current.getLeft() == null) {
                    return current;
                } else if (current.getLeft() != null) {
                    current = current.getLeft();
                    findNode(element, current);
                }
            } else if (element.compareTo(currentElement) == 1) {
                if (current.getRight() == null) {
                    return current;
                } else if (current.getRight() != null) {
                    current = current.getRight();
                    findNode(element, current);
                }
            }
            return current;


    }

    private LinkedList<T> sortedListHelper(Node current) throws NodeNotFoundException{
        try {
            LinkedList<T> ls = new LinkedList<T>();
            LinkedList<T> rightls = new LinkedList<T>();
            if (hasLeft(current)) {
                ls = sortedListHelper(current.getLeft());
                ls.add(current.getValue());
                if (hasRight(current)) {
                    rightls = sortedListHelper(current.getRight());
                    ls.addAll(rightls);
                }
                return ls;
            } else if (!hasLeft(current)) {
                ls.add(current.getValue());
                if (hasRight(current)) {
                    rightls = sortedListHelper(current.getRight());
                    ls.addAll(rightls);
                }
                return ls;
            }
            return ls;
        }catch(NodeNotFoundException e){
            logger.error("Node not found: "+ e);
            throw new NodeNotFoundException();
        }

    }


}