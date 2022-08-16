package list;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class _19_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode pre = null;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (pre == null) {
            return slow.next;
        } else {
            pre.next = slow.next;
            return head;
        }
    }
}
