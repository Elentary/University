package by.bsu.labs.lab9;

/**
 * Created by amareelez on 9.11.16.
 */

class Node<T extends Comparable> {
    Node<T> left = null, right = null, parent = null;
    private T key;

    public Node(T key) {
        this.key = key;
    }

    Node(T key, Node<T> parent) {
        this.key = key;
        this.parent = parent;
    }

    T getKey() {
        return key;
    }
}


public class CustomTree<T extends Comparable> {
    private Node<T> root = null;

    public CustomTree() {
    }

    public CustomTree(Node<T> root) {
        this.root = root;
    }

    public void add(T value) {
        Node<T> temp = root, prev = null;
        while (temp != null) {
            if (value.compareTo(temp.getKey()) < 0) {
                prev = temp;
                temp = temp.left;
            } else {
                prev = temp;
                temp = temp.right;
            }
        }
        temp = new Node<T>(value, prev);
        if (root == null)
            root = temp;
        if (prev != null) {
            if (value.compareTo(prev.getKey()) < 0)
                prev.left = temp;
            else
                prev.right = temp;
        }
    }

    public void delete(T value) {
        if (root == null)
            throw new NullPointerException("One can't simply delete from empty tree");
        Node<T> target = search(value);
        if (target == null)
            return;
        Node<T> nextTarget = target.right, prevNextTarget = target;
        while (nextTarget != null && nextTarget.left != null) {
            prevNextTarget = nextTarget;
            nextTarget = nextTarget.left;
        }
        prevNextTarget.left = null;
        if (nextTarget != null) {
            nextTarget.parent = target.parent;
            nextTarget.left = target.left;
            nextTarget.right = target.right;
            target.left.parent = nextTarget;
            target.right.parent = nextTarget;
            if (target.getKey().compareTo(target.parent.getKey()) < 0)
                target.parent.left = nextTarget;
            else
                target.parent.right = nextTarget;
        } else {
            if (target.getKey().compareTo(target.parent.getKey()) < 0)
                target.parent.left = target.left;
            else
                target.parent.right = target.left;
            target.left.parent = target.parent;
        }
    }

    public Node<T> search(T value) {
        if (root == null)
            return null;
        Node<T> result = root;
        while (result.getKey() != value) {
            if (value.compareTo(result.getKey()) < 0)
                result = result.left;
            else
                result = result.right;
        }
        return result;
    }

    public String leftRightRootTraverse(Node<T> node) {
        StringBuilder stringBuilder = new StringBuilder();
        if (node == null)
            return "";
        stringBuilder.append(leftRightRootTraverse(node.left));
        stringBuilder.append(leftRightRootTraverse(node.right)).append(" ");
        stringBuilder.append(node.getKey()).append(" ");
        return stringBuilder.toString();
    }

    public String rootLeftRightTraverse(Node<T> node) {
        StringBuilder stringBuilder = new StringBuilder();
        if (node == null)
            return "";

        stringBuilder.append(node.getKey());
        stringBuilder.append(rootLeftRightTraverse(node.left)).append(" ");
        stringBuilder.append(rootLeftRightTraverse(node.right)).append(" ");
        return stringBuilder.toString();
    }

    public Node<T> getRoot() {
        return root;
    }

    public String leftRootRightTraverse(Node<T> node) {
        StringBuilder stringBuilder = new StringBuilder();
        if (node == null)
            return "";

        stringBuilder.append(leftRootRightTraverse(node.left));
        stringBuilder.append(node.getKey()).append(" ");
        stringBuilder.append(leftRootRightTraverse(node.right)).append(" ");
        return stringBuilder.toString();
    }
}
