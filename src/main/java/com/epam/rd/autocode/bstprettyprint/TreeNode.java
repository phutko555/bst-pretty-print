package com.epam.rd.autocode.bstprettyprint;

import java.io.IOException;

public class TreeNode<T extends Comparable<T>> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public void addToTree(T newValue) {

        if (value == null) {
            value = newValue;
            return;
        }
        if (value.equals(newValue)) {
            return;
        }
        if (newValue.compareTo(value) > 0) {
            if (left == null) {
                left = new TreeNode<>();
            }
            left.addToTree(newValue);
        } else {
            if (right == null) {
                right = new TreeNode<>();
            }
            right.addToTree(newValue);
        }
    }

    // printTree exception

    public void printTree(StringBuilder out) throws IOException {
        int count = value.toString().length() - 1;

        if (right != null) {
            right.printTree(out, true, " ".repeat(count));
        }
        connectNodeValue(out);

        if (left != null) {
            left.printTree(out, false, " ".repeat(count));
        }
    }
    public void connectNodeValue(StringBuilder out) {
        if (value == null) {
            out.append("<null>");
        }
        if (right != null && left == null) {
            out.append(value).append("┘");
        }
        else if (right == null && left != null) {
            out.append(value).append("┐");
        }
        else if (right != null && left != null) {
            out.append(value).append("┤");
        } else
            out.append(value);

        out.append("\n");
    }
    private void printTree(StringBuilder out, boolean isRight, String indent)  {


        if (right != null) {
            right.printTree(out, true, indent + (isRight ? " ".repeat(value.toString().length() + 1)
                    : " │" + " ".repeat(value.toString().length() - 1)));
        }
        out.append(indent);
        if (isRight) {
            out.append(" ┌");
        } else {
            out.append(" └");
        }

        connectNodeValue(out);;

        if (left != null) {

            left.printTree(out, false, indent + (isRight ? " │" + " ".repeat(value.toString().length() - 1)
                    : " ".repeat(value.toString().length() + 1)));
        }
    }
}

