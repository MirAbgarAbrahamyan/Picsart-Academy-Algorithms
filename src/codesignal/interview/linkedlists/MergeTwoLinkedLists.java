package codesignal.interview.linkedlists;

import helper.ListNode;

public class MergeTwoLinkedLists {
    ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode<Integer> ans = null;
        if (l1.value <= l2.value) {
            ans = l1;
            l1 = l1.next;
        }
        else {
            ans = l2;
            l2 = l2.next;
        }
        ListNode<Integer> ptr = ans;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                ptr.next = l1;
                l1 = l1.next;
            }
            else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        while (l1 != null) {
            ptr.next = l1;
            ptr = ptr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            ptr.next = l2;
            ptr = ptr.next;
            l2 = l2.next;
        }
        return ans;
    }
}
