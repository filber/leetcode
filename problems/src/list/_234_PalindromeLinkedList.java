package list;

//https://leetcode.com/problems/palindrome-linked-list/

import java.util.Stack;

public class _234_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode fast = head, slow = head;
        ListNode pre = slow;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // length is odd
        if (fast != null) {
            slow = slow.next;
            pre.next.next = null;
        }
        pre.next = null;

        ListNode rList = reverse(slow);
        while (rList != null) {
            if (rList.val != head.val) {
                return false;
            }
            rList = rList.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        pre.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public boolean isPalindromeStack(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode fast = head, slow = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;

            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        // length is odd
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int peek = stack.pop();
            if (peek != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
