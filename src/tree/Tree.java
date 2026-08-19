package tree;

import entities.Identifiable;

public class Tree<T extends Comparable<T> & Identifiable> {
    private Node<T> edge;

    public Tree(Node<T> edge) {
        this.edge = edge;
    }

    public Node<T> getEdge() {
        return edge;
    }

    public void addNode(Node<T> node){
        if (edge == null){
            edge = node;
            return;
        }

        dragNode(edge, node);
    }

    private Node<T> currentNode(Node<T> start, Node<T> choice){
        int comparable = choice.getValue().compareTo(start.getValue());

        if (comparable < 0){
            return start.getLeft();
        }

        if(comparable > 0) {
            return start.getRight();
        }

        return null;
    }

    private void dragNode(Node<T> place, Node<T> node) {

        while (true) {

            Node<T> next = currentNode(place, node);

            if (next == null) {

                if (node.getValue().compareTo(place.getValue()) < 0) {
                    place.setLeft(node);
                } else if (node.getValue().compareTo(place.getValue()) > 0) {
                    place.setRight(node);
                }

                return;
            }

            place = next;
        }
    }

    public Node<T> search(Node<T> search) {
        Node<T> current = edge;
        while(current != null){
            if(current.getValue().equals(search.getValue())){
                return current;
            }
            else{
                current = currentNode(current, search);
            }
        }

        return null;
    }

    public Node<T> searchById(int id) {
        return searchById(edge, id);
    }

    private Node<T> searchById(Node<T> node, int id) {
        if (node == null) {
            return null;
        }

        if (node.getValue().getId() == id) {
            return node;
        }

        Node<T> result = searchById(node.getLeft(), id);

        if (result != null) {
            return result;
        }

        return searchById(node.getRight(), id);
    }

    public void printTree() {
        printTree(edge, 0);
    }

    private void printTree(Node<T> node, int level) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.println(node.getValue());

        printTree(node.getLeft(), level + 1);
        printTree(node.getRight(), level + 1);
    }
}
