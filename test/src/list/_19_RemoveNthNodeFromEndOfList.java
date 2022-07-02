package list;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class _19_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastPtr = head;
        for (int i = 0; i < n; i++) {
            fastPtr = fastPtr.next;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (fastPtr != null) {
            pre = cur;
            cur = cur.next;
            fastPtr = fastPtr.next;
        }

        if (pre == null) {
            return head.next;
        }
        pre.next = cur.next;
        return head;
    }
}
