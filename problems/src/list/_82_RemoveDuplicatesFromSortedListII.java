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

        // 2. Using Two Pointers to remove duplicates
        ListNode l = head;
        ListNode r = head == null ? null : head.next;
        while (r != null) {
            if (r.val == dupVal || r.next != null && r.val == r.next.val) {
                l.next = r.next;
                dupVal = r.val;
            } else {
                l = r;
            }
            r = r.next;
        }

        return head;
    }
}
