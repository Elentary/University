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
        System.out.println("With root deleted: " + tree.leftRightRootTraverse(tree.getRoot()));

        Integer tryToFound = random.nextInt(20);
        Node found = tree.search(tryToFound);
        if (found == null)
            System.out.println(String.format("%d is not found", tryToFound));
        else
            System.out.println(String.format("%d is found at ", tryToFound) + found);
    }
}
