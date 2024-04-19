package code.wars.reverse_linked_list;

import java.util.Stack;

public class Kata {

    public static Node reverse(Node node) {

        if (node == null) {
            return null;
        }

        Stack<Node> nodes = getStackOfNodes(node);

        Node first = nodes.pop();
        Node current = first;

        while (!nodes.isEmpty()) {
            Node next = nodes.pop();
            current.next = next;
            current = next;
        }

        current.next = null;

        return first;
    }

    private static Stack<Node> getStackOfNodes(Node node) {

        Stack<Node> nodes = new Stack<>();
        nodes.push(node);
        Node currentNode = node;
        while (currentNode.next != null) {
            Node next = currentNode.next;
            nodes.push(next);
            currentNode = next;
        }
        return nodes;
    }

    static class Node {

        Integer element;

        Node next;

        public Node(Integer element) {

            this.element = element;
        }
    }
}
