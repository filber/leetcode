package array_matrix;

// https://leetcode.com/problems/middle-of-the-linked-list/
//TOPICS:
//[Linked List],[Two Pointers]
// TIPS:
// Using fast&slow pointers
public class _876_MiddleOfTheLinkedList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode middleNode(ListNode head) {
        if (head.next==null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast!= null) {
                fast = fast.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode n1 = middleNode(new ListNode(1));

        ListNode n2 = middleNode(
                new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5))))));

        ListNode n3 = middleNode(
                new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5,
                new ListNode(6)))))));
    }
}
