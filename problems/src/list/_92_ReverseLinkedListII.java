package list;

//https://leetcode.com/problems/reverse-linked-list-ii/

public class _92_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode start;
        ListNode leftEnd;
        if (left == 1) {
            leftEnd = null;
            start = head;
        } else {
            leftEnd = head;
            for (int i = 0; i < left - 2; i++) {
                leftEnd = leftEnd.next;
            }
            start = leftEnd.next;
        }


        // reverse
        ListNode pre = start;
        ListNode cur = start.next;
        pre.next = null;
        int k = right - left;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        start.next = cur;
        if (leftEnd != null) {
            leftEnd.next = pre;
        } else {
            head = pre;
        }
        return head;
    }


}
