package code.wars.count_if;

import java.util.function.Predicate;

class Solution {

    static <T> int countIf(Node<T> head, Predicate<T> p) {

        if (head == null) {
            return 0;
        }

        int count = 0;
        Node<T> node = head;
        do {
            T data = node.data;
            if (p.test(data)) {
                count++;
            }
            node = node.next;
        } while (node != null);
        return count;
    }
}
