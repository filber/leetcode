package list;

//https://leetcode.com/problems/rotate-list/

public class _61_RotateList {

//    Constraints:
//    The number of nodes in the list is in the range [0, 500].
//    -100 <= Node.val <= 100
//    0 <= k <= 2 * 10^9

    public ListNode rotateRight(ListNode head, int k) {
        int len = getLen(head);
        if (len == 0) {
            return head;
        }

        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode left = head;
        ListNode right = head;
        int jumps = len - k;
        while (jumps > 1) {
            right = right.next;
            jumps--;
        }
        ListNode pre = right;
        right = right.next;
        pre.next = null;// cut the link

        pre = right;
        ListNode cur = right.next;
        while (cur != null) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = left;

        return right;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

}
