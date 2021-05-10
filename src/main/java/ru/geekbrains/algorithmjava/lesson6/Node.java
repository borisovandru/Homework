package ru.geekbrains.algorithmjava.lesson6;

public class Node {
    private Node leftChild;
    private Node rightChild;
    private final Coin coin;

    public Node(Coin coin) {
        this.coin = coin;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Coin getCoin() {
        return coin;
    }
}
