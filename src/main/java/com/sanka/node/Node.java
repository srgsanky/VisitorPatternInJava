package com.sanka.node;

import com.sanka.visitor.Visitor;

import java.util.List;

/**
 * Represents a Node.
 */
public interface Node {
    /**
     * Accepts a visitor and calls the appropriate method on the visitor.
     *
     * @param visitor A visitor.
     */
    void accept(Visitor visitor);

    /**
     * Get the node's value.
     *
     * @return Node's value.
     */
    int getValue();

    /**
     * Get the children of the current node (if any).
     *
     * @return Children of the current node or empty list if no children exists.
     */
    List<Node> getChildren();
}
