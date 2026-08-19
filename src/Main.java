import entities.Client;
import tree.Node;
import tree.Tree;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("João Batista", 18);
        Client client2 = new Client("Miguel Francisco", 20);
        Client client3 = new Client("Antonio Franco", 16);
        Client client4 = new Client("Francisco", 22);
        Client client5 = new Client("Gilberto Silva", 14);
        Client client6 = new Client("João", 17);

        Node<Client> node1 = new Node<>(client1);
        Node<Client> node2 = new Node<>(client2);
        Node<Client> node3 = new Node<>(client3);
        Node<Client> node4 = new Node<>(client4);
        Node<Client> node5 = new Node<>(client5);
        Node<Client> node6 = new Node<>(client6);

        Tree<Client> tree = new Tree<>(node1);
        tree.addNode(node2);
        tree.addNode(node3);
        tree.addNode(node4);
        tree.addNode(node5);
        tree.addNode(node6);

        tree.printTree();
    }
}