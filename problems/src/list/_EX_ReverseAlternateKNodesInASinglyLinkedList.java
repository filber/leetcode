package list;

//https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/

public class _EX_ReverseAlternateKNodesInASinglyLinkedList {

    public ListNode kAltReverse(ListNode head, int k) {
        if (head == null) {
            return null;
        } else if (k <= 1) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        for (int i = 0; i < k - 1 && cur != null; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        head.next = cur;
        cur = skip(cur, k - 1);
        if (cur != null) {
            cur.next = kAltReverse(cur.next, k);
        }

        return pre;
    }

    private ListNode skip(ListNode head, int k) {
        for (int i = 0; i < k && head != null; i++) {
            head = head.next;
        }
        return head;
    }
}
