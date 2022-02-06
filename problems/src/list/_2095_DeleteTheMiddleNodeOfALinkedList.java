package list;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

public class _2095_DeleteTheMiddleNodeOfALinkedList {

    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        pre.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = deleteMiddle(
                new ListNode(1));
        ListNode n2 = deleteMiddle(
                new ListNode(1, new ListNode(2)));
        ListNode n3 = deleteMiddle(
                new ListNode(1, new ListNode(2, new ListNode(3))));
        ListNode n4 = deleteMiddle(
                new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5))))));
        ListNode n5 = deleteMiddle(
                new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5, new ListNode(6)))))));
    }
}
