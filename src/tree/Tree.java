package tree;

public class Tree<T extends Comparable<T>> {
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
