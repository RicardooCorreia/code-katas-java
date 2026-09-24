package code.wars.can_you_get_the_loop;

class Node {

    private Node next;

    Node(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}