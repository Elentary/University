package by.bsu.labs.lab9;

/**
 * Created by amareelez on 9.11.16.
 */

class Node<T extends Comparable<T>> {
    Node<T> left = null, right = null, parent = null;
    private T key;

    public Node(T key) {
        this.key = key;
    }

    Node(T key, Node<T> parent) {
        this.key = key;
        this.parent = parent;
    }

    public T getKey() {
        return key;
    }

    void setKey(T value) {
        key = value;
    }

    @Override public String toString() {
        return "Node{" + "left=" + left.getKey() + ", right=" + right.getKey() + ", parent="
            + parent.getKey() + ", key=" + key + '}';
    }
}


public class CustomTree<T extends Comparable<T>> {
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
        temp = new Node<>(value, prev);
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

        if (target.left == null && target.right == null) {
            if (target == root)
                root = null;
            if (target.parent.left == target)
                target.parent.left = null;
            else
                target.parent.right = null;
        } else if (target.left == null || target.right == null) {
            if (target != root) {
                if (target.left == null) {
                    if (target.parent.left == null)
                        target.parent.right = target.right;
                    else
                        target.parent.left = target.right;
                    target.right.parent = target.parent;
                } else {
                    if (target.parent.left == null)
                        target.parent.right = target.left;
                    else
                        target.parent.left = target.left;
                    target.left.parent = target.parent;
                }
            } else if (target.left == null) {
                target.right.parent = null;
                root = target.right;
            } else {
                target.left.parent = null;
                root = target.left;
            }

        } else {
            Node<T> nextTarget = target.right;
            while (nextTarget.left != null) {
                nextTarget = nextTarget.left;
            }

            target.setKey(nextTarget.getKey());
            if (nextTarget.parent.left == nextTarget) {
                nextTarget.parent.left = nextTarget.right;
            } else {
                nextTarget.parent.right = nextTarget.right;
            }
            if (nextTarget.right != null)
                nextTarget.right.parent = nextTarget.parent;
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
        if (node.left != null)
            stringBuilder.append(leftRightRootTraverse(node.left));
        if (node.right != null)
            stringBuilder.append(leftRightRootTraverse(node.right));
        stringBuilder.append(node.getKey()).append(" ");
        return stringBuilder.toString();
    }

    public String rootLeftRightTraverse(Node<T> node) {
        StringBuilder stringBuilder = new StringBuilder();
        if (node == null)
            return "";
        stringBuilder.append(node.getKey());
        if (node.left != null)
            stringBuilder.append(" ").append(rootLeftRightTraverse(node.left));
        if (node.right != null) {
            if (stringBuilder.charAt(stringBuilder.length() - 1) != ' ')
                stringBuilder.append(" ");
            stringBuilder.append(rootLeftRightTraverse(node.right));
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) != ' ')
            stringBuilder.append(" ");
        return stringBuilder.toString();
    }

    public Node<T> getRoot() {
        return root;
    }

    public String leftRootRightTraverse(Node<T> node) {
        StringBuilder stringBuilder = new StringBuilder();
        if (node == null)
            return "";

        if (node.left != null)
            stringBuilder.append(leftRootRightTraverse(node.left));
        if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) != ' ')
            stringBuilder.append(" ");
        stringBuilder.append(node.getKey());
        if (node.right != null)
            stringBuilder.append(" ").append(leftRootRightTraverse(node.right));
        if (stringBuilder.charAt(stringBuilder.length() - 1) != ' ')
            stringBuilder.append(" ");
        return stringBuilder.toString();
    }
}
