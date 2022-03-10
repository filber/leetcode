package list;

//https://leetcode.com/problems/add-two-numbers/

public class _2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry > 0) {
                return new ListNode(carry);
            } else {
                return null;
            }
        }

        if (l1 == null) {
            return addNumbers(l2, carry);
        } else if (l2 == null) {
            return addNumbers(l1, carry);
        }

        l1.val += l2.val + carry;
        l1.next = addTwoNumbers(l1.next, l2.next, l1.val / 10);
        l1.val %= 10;
        return l1;
    }

    public ListNode addNumbers(ListNode l, int carry) {
        if (l == null) {
            if (carry > 0) {
                return new ListNode(carry);
            } else {
                return null;
            }
        }
        l.val += carry;
        if (l.val >= 10) {
            l.next = addNumbers(l.next, l.val / 10);
            l.val %= 10;
        }
        return l;
    }
}
