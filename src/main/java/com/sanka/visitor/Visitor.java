package com.sanka.visitor;

import com.sanka.node.BinaryNode;
import com.sanka.node.Node;
import com.sanka.node.TernaryNode;

/**
 * Visitor interface based on the Visitor design pattern. This represents the operations to be performed on a node
 * without adding the operations on the nodes directly.
 */
public interface Visitor {

    void visit(Node node);

    void visit(BinaryNode node);

    void visit(TernaryNode node);
}
