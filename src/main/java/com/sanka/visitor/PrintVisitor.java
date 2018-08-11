package com.sanka.visitor;

import com.sanka.node.BinaryNode;
import com.sanka.node.Node;
import com.sanka.node.TernaryNode;

/**
 * A visitor that prints the type of the node being visited.
 */
public class PrintVisitor implements Visitor {
    @Override
    public void visit(Node node) {
        System.out.println("Visiting a Node");
        node.accept(this);
    }

    @Override
    public void visit(BinaryNode node) {
        System.out.println("Visiting a BinaryNode: " + node.getValue());

        for(Node child : node.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(TernaryNode node) {
        System.out.println("Visiting a TernaryNode: " + node.getValue());

        for(Node child : node.getChildren()) {
            child.accept(this);
        }
    }
}
