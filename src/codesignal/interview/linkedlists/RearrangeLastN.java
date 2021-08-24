package codesignal.interview.linkedlists;

import helper.ListNode;

public class RearrangeLastN {
    ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
        ListNode<Integer> left = l;
        ListNode<Integer> right = l;
        while (n-- > 0) {
            right = right.next;
        }
        if (right != null) {
            while (right.next != null) {
                right = right.next;
                left = left.next;
            }
            right.next = l;
            l = left.next;
            left.next = null;
        }
        return l;
    }
}
