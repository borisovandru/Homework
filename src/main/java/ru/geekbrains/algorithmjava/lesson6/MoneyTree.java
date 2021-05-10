package ru.geekbrains.algorithmjava.lesson6;

public class MoneyTree {
    private Node root;

    public MoneyTree() {
    }

    public Node getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    private void preOrder(Node nodeToStart) {
        if (nodeToStart != null) {
            nodeToStart.getCoin().printer();
            preOrder(nodeToStart.getLeftChild());
            preOrder(nodeToStart.getRightChild());
        }
    }

    private void postOrder(Node nodeToStart) {
        if (nodeToStart != null) {
            postOrder(nodeToStart.getLeftChild());
            postOrder(nodeToStart.getRightChild());
            nodeToStart.getCoin().printer();
        }
    }

    private void inOrder(Node nodeToStart) {
        if (nodeToStart != null) {
            inOrder(nodeToStart.getLeftChild());
            nodeToStart.getCoin().printer();
            inOrder(nodeToStart.getRightChild());
        }
    }

    public Node showMax() {
        Node nodeToCheck = this.root;
        Node max = nodeToCheck;
        while (nodeToCheck != null) {
            nodeToCheck = nodeToCheck.getRightChild();
            if (nodeToCheck != null) {
                max = nodeToCheck;
            }
        }
        return max;
    }

    public Node showMin() {
        Node nodeToCheck = this.root;
        Node min = nodeToCheck;
        while (nodeToCheck != null) {
            nodeToCheck = nodeToCheck.getLeftChild();
            if (nodeToCheck != null) {
                min = nodeToCheck;
            }
        }
        return min;
    }

    public void showTree() {
        Node nodeToStart = this.root;
        if (nodeToStart != null) {
            System.out.println("Симметричный порядок:");
            inOrder(nodeToStart);
            System.out.println();
            System.out.println("Прямой порядок:");
            preOrder(nodeToStart);
            System.out.println();
            System.out.println("Обратный порядок:");
            postOrder(nodeToStart);
        } else {
            System.out.println("The money tree is empty");
        }
    }

    public Node findByCoinValue(int val) {
        Node nodeToCheck = this.root;
        while (nodeToCheck.getCoin().getValue() != val) {
            if (val < nodeToCheck.getCoin().getValue()) {
                nodeToCheck = nodeToCheck.getLeftChild();
            } else {
                nodeToCheck = nodeToCheck.getRightChild();
            }
            if (nodeToCheck == null) {
                return null;
            }
        }
        return nodeToCheck;
    }

    public void insert(Coin coin) {
        Node newNode = new Node(coin);
        int newCoinValue = coin.getValue();
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node nodeToCheck = this.root;
            while (true) {
                Node potentialParent = nodeToCheck;
                if (newCoinValue < nodeToCheck.getCoin().getValue()) {
                    nodeToCheck = nodeToCheck.getLeftChild();
                    if (nodeToCheck == null) {
                        potentialParent.setLeftChild(newNode);
                        break;
                    }
                } else {
                    nodeToCheck = nodeToCheck.getRightChild();
                    if (nodeToCheck == null) {
                        potentialParent.setRightChild(newNode);
                        break;
                    }
                }
            }
        }
    }

    public void delete(int valueOfCoinInNodeToDelete) {
        Node nodeToCheck = this.root;
        Node parent = this.root;

        boolean isLeftChild = true;

        while (nodeToCheck.getCoin().getValue() != valueOfCoinInNodeToDelete) {
            parent = nodeToCheck;
            if (valueOfCoinInNodeToDelete < nodeToCheck.getCoin().getValue()) {
                isLeftChild = true;
                nodeToCheck = nodeToCheck.getLeftChild();
            } else {
                isLeftChild = false;
                nodeToCheck = nodeToCheck.getRightChild();
            }
            if (nodeToCheck == null) {
                break;
            }
        }

        assert nodeToCheck != null;
        if (nodeToCheck.getLeftChild() == null && nodeToCheck.getRightChild() == null) {
            if (nodeToCheck == this.root) {
                this.root = null;
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (nodeToCheck.getRightChild() == null) {
            if (parent == this.root) {
                this.root.setLeftChild(nodeToCheck.getLeftChild());
            } else if (isLeftChild) {
                parent.setLeftChild(nodeToCheck.getLeftChild());
            } else {
                parent.setRightChild(nodeToCheck.getLeftChild());
            }
        } else if (nodeToCheck.getLeftChild() == null) {
            if (parent == this.root) {
                this.root.setRightChild(nodeToCheck.getRightChild());
            } else if (isLeftChild) {
                parent.setLeftChild(nodeToCheck.getRightChild());
            } else {
                parent.setRightChild(nodeToCheck.getRightChild());
            }
        } else {
            Node successor = getSuccessor(nodeToCheck);
            if (nodeToCheck == this.root) {
                this.root = successor;
            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
        }
    }

    public Node getSuccessor(Node predecessor) {
        Node successorParent = predecessor;
        Node successor = predecessor;
        Node nodeToCh = predecessor.getRightChild();

        while (nodeToCh != null) {
            successorParent = successor;
            successor = nodeToCh;
            nodeToCh = nodeToCh.getLeftChild();
        }
        if (successor != predecessor.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(predecessor.getRightChild());
            successor.setLeftChild(predecessor.getLeftChild());
        }
        return successor;
    }
}
