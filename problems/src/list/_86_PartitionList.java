package list;

//https://leetcode.com/problems/partition-list/

public class _86_PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0);
        ListNode left = leftHead;
        ListNode rightHead = new ListNode(0);
        ListNode right = rightHead;

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (cur.val < x) {
                left.next = cur;
                left = left.next;
            } else {
                right.next = cur;
                right = right.next;
            }
            cur = next;
        }
        left.next = rightHead.next;
        return leftHead.next;
    }
}
