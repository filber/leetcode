package list;

//https://leetcode.com/problems/reverse-linked-list-ii/

public class _92_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int L, int R) {
        if (L == R) {
            return head;
        }

        ListNode leftTail = head;
        if (L == 1) {
            leftTail = null;
        } else {
            for (int i = 0; i < L - 2; i++) {
                leftTail = leftTail.next;
            }
        }

        ListNode pre;
        if (L == 1) {
            pre = head;
        } else {
            pre = leftTail.next;
        }
        ListNode reversedTail = pre;
        ListNode cur = pre.next;
        pre.next = null;
        int k = R - L + 1;
        for (int i = 0; i < k - 1; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        reversedTail.next = cur;
        if (leftTail == null) {
            return pre;
        } else {
            leftTail.next = pre;
            return head;
        }
    }
}
