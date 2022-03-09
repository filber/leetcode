package list;

public class _82_RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        int dupVal = Integer.MIN_VALUE;
        while (head != null && (head.val == dupVal ||
                head.next != null && head.val == head.next.val)) {
            if (head.next != null && head.val == head.next.val) {
                dupVal = head.val;
            }
            head = head.next;
        }

        dupVal = Integer.MIN_VALUE;
        ListNode pre = head;
        ListNode cur = head != null ? head.next : null;

        while (cur != null) {
            if (cur.val == dupVal || cur.next != null && cur.val == cur.next.val) {
                dupVal = cur.val;
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }


}
