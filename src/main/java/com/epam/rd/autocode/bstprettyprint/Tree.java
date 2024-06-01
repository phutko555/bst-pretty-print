package com.epam.rd.autocode.bstprettyprint;

import java.io.IOException;

public class Tree implements PrintableTree {

    private TreeNode<Integer> treeNode = new TreeNode<>();

    @Override
    public void add(int i) {
        treeNode.addToTree(i);
    }

    @Override
    public String prettyPrint() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            treeNode.printTree(stringBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
