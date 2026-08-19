package tree;

public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> right;
    private Node<T> left;
    private Node<T> father;
    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void addFather(Node<T> father){
        this.father = father;
    }
}
