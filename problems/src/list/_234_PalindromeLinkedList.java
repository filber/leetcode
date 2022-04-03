package list;

//https://leetcode.com/problems/palindrome-linked-list/

public class _234_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode fast = head, slow = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd
        if (fast != null) {
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = null;

        ListNode right = reverse(slow);
        ListNode left = head;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = head;
            head = cur;
            cur = tmp;
        }
        return head;
    }
}
