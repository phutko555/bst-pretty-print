package com.epam.rd.autocode.bstprettyprint;

import java.util.ArrayList;
import java.util.Scanner;

public interface PrintableTree {

    void add(int i);
    String prettyPrint();

    static PrintableTree getInstance() {
        return new Tree();
    }
}
