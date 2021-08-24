package codesignal.interview.linkedlists;

import helper.ListNode;

public class IsListPalindrome {
    ListNode<Integer> reverse(ListNode<Integer> head) {
        ListNode<Integer> prev = null;
        while (head != null) {
            ListNode<Integer> next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    boolean isListPalindrome(ListNode<Integer> l) {
        ListNode<Integer> slow = l;
        ListNode<Integer> fast = l;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode<Integer> secondHalfPtr = reverse(slow);
        while (secondHalfPtr != null) {
            if (!l.value.equals(secondHalfPtr.value)) {
                return false;
            }
            secondHalfPtr = secondHalfPtr.next;
            l = l.next;
        }
        return true;
    }
}
