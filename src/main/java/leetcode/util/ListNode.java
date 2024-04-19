package leetcode.util;

import leetcode.AddTwoNumbers;

import java.util.List;
import java.util.Objects;

public class ListNode {
    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ListNode{");
        sb.append("val=").append(val);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    public static ListNode listToListNode(List<Integer> integerList) {

        ListNode firstNode = new ListNode();
        firstNode.val = integerList.get(0);

        ListNode current = firstNode;
        for (int i = 1; i < integerList.size(); i++) {
            ListNode node = new ListNode();
            node.val = integerList.get(i);
            current.next = node;
            current = node;
        }

        return firstNode;
    }

    public static ListNode of(Integer... elements) {

        return listToListNode(List.of(elements));
    }
}