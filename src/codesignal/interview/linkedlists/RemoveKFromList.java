package codesignal.interview.linkedlists;

import helper.ListNode;

public class RemoveKFromList {
    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        while (l != null && l.value.equals(k)) {
            l = l.next;
        }
        if (l == null) {
            return null;
        }
        ListNode<Integer> current = l.next;
        ListNode<Integer> prev = l;
        while (current != null) {
            while (current != null && current.value.equals(k)) {
                prev.next = current.next;
                current = current.next;
            }
            if (current != null) {
                current = current.next;
                prev = prev.next;
            }
        }
        return l;
    }
}
