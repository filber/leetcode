package list;

//https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/


public class _EX_ReverseAlternateKNodesInASinglyLinkedList {

    public ListNode kAltReverse(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }

        // reverse first k nodes
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        for (int i = 0; i < k - 1 && cur != null; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (cur == null) {
            return pre;
        } else {
            head.next = cur;
        }

        // skip k-1 nodes
        for (int i = 0; i < k - 1 && cur != null; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            return pre;
        }
        cur.next = kAltReverse(cur.next, k);
        return pre;
    }
}
