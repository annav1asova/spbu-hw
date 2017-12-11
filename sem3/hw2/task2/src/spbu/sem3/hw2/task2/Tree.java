package spbu.sem3.hw2.task2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/** class for Binary Search Tree with Iterator implementation. */
public class Tree<T extends Comparable> implements Iterable<T>{
    private Node<T> root = null;

    /* method that adds some value to tree if it hasn't stored there already. */
    public void add(T value) {
        root = add(value, root);
    }

    /* method that adds some value to tree that has given node as its root. */
    private Node add(T value, Node<T> node) {
        if (node == null) {
            node = new Node(value, null, null);
            return node;
        }
        int sign = node.value.compareTo(value);

        if (sign == 0) {
            return node;
        } else if (sign > 0) {
            node.left = add(value, node.left);
        } else {
            node.right = add(value, node.right);
        }
        return node;
    }

    /* method that removes value from tree if it exists there. */
    public void remove(T value) {
        root = remove(value, root);
    }

    /* method that removes value from tree with given node as its root. */
    private Node remove(T value, Node<T> node) {
        if (node == null) {
            return node;
        }
        int sign = node.value.compareTo(value);
        if (sign > 0) {
            node.left = remove(value, node.left);
        } else if (sign < 0) {
            node.right = remove(value, node.right);
        } else {
            if (node.hasNoChildren()) {
                node = null;
            } else if (node.hasOnlyLeftChild()) {
                node = node.left;
            } else if (node.hasOnlyRightChild()) {
                node = node.right;
            } else {
                Node temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                T data = (T)temp.value;
                remove(data);
                node.value = data;
            }
        }
        return node;
    }

    /* method that returns true if tree is empty and false otherwise. */
    public boolean isEmpty() {
        return root == null;
    }

    public String printTree() {
        return printTree(root);
    }

    private String printTree(Node<T> node) {
        if (node == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(" (");
        sb.append(node.value);
        sb.append(printTree(node.left));
        sb.append(printTree(node.right));
        sb.append(")");
        return sb.toString();
    }

    /* method that generates iterator for tree. */
    @Override
    public Iterator<T> iterator() {
        return new TreeIterator(root);
    }

    /* class for BST Element - Node. */
    private class Node<T extends Comparable> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        private Node(T value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        private boolean hasNoChildren() {
            return left == null && right == null;
        }
        private boolean hasOnlyRightChild() {
            return left == null && right != null;
        }
        private boolean hasOnlyLeftChild() {
            return left != null && right == null;
        }
    }

    /* class for tree iterator. */
    private class TreeIterator implements Iterator<T> {
        Stack<Node> stack;

        /* creation of iterator. */
        public TreeIterator(Node root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /* method that returns false if there is anything else in tree and true otherwise. */
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /* method that return next element of tree (in in-order traversal) or throws exception */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node next = stack.pop();
            Node newRoot = next.right == null ? null : next.right;
            while (newRoot != null) {
                stack.push(newRoot);
                newRoot = newRoot.left;
            }
            return (T)next.value;
        }
    }
}
