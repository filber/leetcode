package list;

//https://leetcode.com/problems/swap-nodes-in-pairs/

public class _24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        } else if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode nextList = swapPairs(next.next);
        next.next = head;
        head.next = nextList;
        return next;
    }
}
