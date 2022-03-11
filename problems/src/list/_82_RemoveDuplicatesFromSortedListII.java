package list;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/


public class _82_RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        // 1. Move head to skip duplicates
        int dupVal = Integer.MIN_VALUE;
        while (head != null &&
                (head.val == dupVal ||
                (head.next != null && head.val == head.next.val)
                )) {
            if (head.next != null && head.val == head.next.val) {
                dupVal = head.val;
            }
            head = head.next;
        }

        ListNode pre = head;
        ListNode cur = head == null ? null : head.next;
        while (cur != null) {
            if (cur.val == dupVal || cur.next != null && cur.val == cur.next.val) {
                pre.next = cur.next;
                dupVal = cur.val;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }
}
