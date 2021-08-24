package codesignal.interview.linkedlists;

import helper.ListNode;

public class AddTwoHugeNumbers {
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

    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        a = reverse(a);
        b = reverse(b);
        ListNode<Integer> futureHead = new ListNode<>(0);
        ListNode<Integer> c = futureHead;
        int carry = 0;
        while (a != null || b!= null) {
            int valueOfA = (a != null) ? a.value : 0;
            int valueOfB = (b != null) ? b.value : 0;
            int sum = valueOfA + valueOfB + carry;
            carry = sum / 10000;
            int numThatFits = sum % 10000;

            c = new ListNode<>(numThatFits);
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
            c = c.next;
        }

        if (carry > 0) {
            c.next = new ListNode<>(carry);
        }
        return reverse(futureHead.next);
    }
}
