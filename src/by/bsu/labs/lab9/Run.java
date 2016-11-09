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
        System.out.println(tree.leftRightRootTraverse(tree.getRoot()));
        System.out.println(tree.leftRootRightTraverse(tree.getRoot()));
        System.out.println(tree.rootLeftRightTraverse(tree.getRoot()));
    }
}
