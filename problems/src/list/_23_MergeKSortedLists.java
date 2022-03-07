package list;

//https://leetcode.com/problems/merge-k-sorted-lists/


public class _23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int i, int j) {
        if (i > j) {
            return null;
        } else if (i == j) {
            return lists[i];
        }
        int mid = (i + j) / 2;
        ListNode left = merge(lists, i, mid);
        ListNode right = merge(lists, mid + 1, j);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        ListNode head;
        if (left.val < right.val) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }
        ListNode cur = head;

        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return head;
    }
}
