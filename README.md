# Visitor pattern:

## Intent
Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.

## Implementation concern in Java - visit/accept
If visitor represents an operation to be performed on the elements of an object structure, why are we not calling the visitor.visit operation directly on the visitor? We see Java code where the visitor calls the object's accept which then calls the visitor's visit again. Why do we need this convoluted implementation?

Visitor pattern prescribes double-dispatch. A single dispatch is when the appropriate method is called based on the object on which the method is called. For example

```java
class Node {
    public void method1() {
    }

    public void method2() {
    }
}

class BinaryNode extends Node {
    public void method2() {
    }
}


class Driver {
    public static void main(String[] args) {
        Node n = new BinaryNode();

        n.method1(); // Calls Node's method
        n.method2(); // Calls BinaryNode's method

        n = new Node();

        n.method1(); // Calls Node's method
        n.method2(); // Calls Node's method
    }
}

```

Double dispatch is when the appropriate method is called based on the object on which the method is called and also the method's parameters. Java does not support double dispatch. For e.g.

```java
class Visitor {
    public void visit(Node node) {
        System.out.println("visit on Node is called");
    }

    public void visit(BinaryNode binaryNode) {
        System.out.println("visit on BinaryNode is called");
    }
}

class Driver {
    public static void main(String[] args) {
        Visitor visitor = new Visitor();

        Node n = new Node();

        visitor.visit(n); // Calls Visitor.visit(Node)

        n = new BinaryNode();

        visitor.visit(n); // Calls Visitor.visit(Node). But we want it to call Visitor.visit(BinaryNode).
    }
}
```

In order to solve this problem, implementations use the visit/accept call i.e. use 2 single dispatches to achieve a double dispatch. When the ``Visitor`` calls ``Node.accept(this)``, the accept method of the appropriate ``Node`` is called. Now the accept method calls ``Visitor.visit(this)`` - this makes sure that the visit method of the concrete node type is called.


## References
https://stackoverflow.com/questions/9132178/what-is-the-point-of-accept-method-in-visitor-pattern/16629618