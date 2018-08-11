package com.sanka.driver;

import com.sanka.node.BinaryNode;
import com.sanka.node.Node;
import com.sanka.node.TernaryNode;
import com.sanka.visitor.PrintVisitor;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Node leaf1 = new BinaryNode(5, new ArrayList<>());
        Node leaf2 = new BinaryNode(10, new ArrayList<>());
        Node leaf3 = new BinaryNode(15, new ArrayList<>());

        Node leaf4 = new BinaryNode(100, new ArrayList<>());

        Node intermediateNode = new TernaryNode(3, Arrays.asList(leaf1, leaf2, leaf3));

        Node root = new BinaryNode(2, Arrays.asList(intermediateNode, leaf4));

        PrintVisitor visitor = new PrintVisitor();
        visitor.visit(root);

        /*
        OUTPUT:
        -------
        Visiting a Node
        Visiting a BinaryNode: 2
        Visiting a TernaryNode: 3
        Visiting a BinaryNode: 5
        Visiting a BinaryNode: 10
        Visiting a BinaryNode: 15
        Visiting a BinaryNode: 100
         */
    }
}
