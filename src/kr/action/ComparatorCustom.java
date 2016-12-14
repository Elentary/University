package kr.action;

import kr.entity.Tree;

import java.util.Comparator;

/**
 * Created by amareelez on 14.12.16.
 */

public class ComparatorCustom implements Comparator<Tree> {
    @Override public int compare(Tree tree, Tree t1) {
        if (!tree.getName().equals(t1.getName()))
            return new Integer(tree.getAge()).compareTo(tree.getAge());
        else
            return -1 * tree.getName().compareTo(tree.getName());
    }
}
