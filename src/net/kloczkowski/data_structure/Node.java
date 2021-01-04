package net.kloczkowski.data_structure;

public class Node {
    private final String value;
    private final int quantity;
    private final Node leftSon;
    private final Node rightSon;

    public Node(String value, int quantity) {
        this.value = value;
        this.quantity = quantity;
        leftSon = null;
        rightSon = null;
    }

    public Node(Node leftSon, Node rightSon) {
        this.value = leftSon.getValue() + rightSon.getValue();
        this.quantity = leftSon.getQuantity() + rightSon.getQuantity();
        this.leftSon = leftSon;
        this.rightSon = rightSon;
    }

    public String getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

    public Node getLeftSon() {
        return leftSon;
    }

    public Node getRightSon() {
        return rightSon;
    }
}
