package codesignal.interview.linkedlists;

import helper.ListNode;

public class ReverseNodesInKGroups {
    ListNode<Integer> reverse(ListNode<Integer> head, int k) {
        ListNode<Integer> prev = null;
        while (head != null && k-- > 0) {
            ListNode<Integer> next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        ListNode<Integer> ans = new ListNode<>(Integer.MIN_VALUE);
        ListNode<Integer> ansPtr = ans;
        ListNode<Integer> ptr = l;
        while (ptr != null) {
            ListNode<Integer> ptrForReverse = ptr;
            int count = 0;
            while (ptr != null && count < k) {
                ptr = ptr.next;
                count++;
            }
            if (count == k) {
                ansPtr.next = reverse(ptrForReverse, k);
                ansPtr = ptrForReverse;
            } else {
                ansPtr.next = ptrForReverse;
            }
        }
        return ans.next;
    }
}
