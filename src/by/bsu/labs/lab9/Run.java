package by.bsu.labs.lab9;

import java.util.Random;

/**
 * Created by amareelez on 9.11.16.
 */

public class Run {
    public static void main(String[] args) {
        CustomTree<Integer> tree = new CustomTree<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++)
            tree.add(random.nextInt(10));
        System.out.println("LRRoot traverse: " + tree.leftRightRootTraverse(tree.getRoot()));
        System.out.println("LRootR traverse: " + tree.leftRootRightTraverse(tree.getRoot()));
        System.out.println("RootLR traverse: " + tree.rootLeftRightTraverse(tree.getRoot()));
        tree.delete(tree.getRoot().getKey());
        System.out.println("With root deleted: " + tree.rootLeftRightTraverse(tree.getRoot()));

        Integer tryToFound = random.nextInt(20);
        Node found = tree.search(tryToFound);
        if (found == null)
            System.out.println(String.format("%d is not found", tryToFound));
        else
            System.out.println(String.format("%d is found at ", tryToFound) + found);
        while (true) {
            if (!refactor(tree, tree.getRoot()))
                break;
        }
        System.out.println("RootLR traverse: " + tree.rootLeftRightTraverse(tree.getRoot()));
    }

    static boolean refactor(CustomTree<Integer> tree, Node<Integer> node) {
        if (node == null)
            return false;
        if (node.left != null)
            refactor(tree, node.left);
        if (node.right != null)
            refactor(tree, node.right);
        if (node.hasTwoChildren() && node != tree.getRoot()) {
            if (node.parent.getKey().compareTo(0) < 0)
                tree.delete(node.left);
            else
                tree.delete(node.right);
            return true;
        }
        return false;
    }
}
