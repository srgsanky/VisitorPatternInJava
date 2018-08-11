package com.sanka.node;

import com.sanka.visitor.Visitor;

import java.util.List;

public class BinaryNode implements Node {
    private final int value;
    private final List<Node> children;

    public BinaryNode(int value, List<Node> children) {
        this.value = value;
        this.children = children;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // calls Visitor.visit(BinaryNode).
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public List<Node> getChildren() {
        return children;
    }
}
