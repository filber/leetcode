//TOPICS:
//[Linked List],[Two Pointers]

// TIPS:
// Using fast&slow pointers
public class _2095_DeleteTheMiddleNodeOfALinkedList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast!=null) {
                fast = fast.next;
            }
        }

        // delete middle node;
        ListNode middle = slow.next;
        slow.next = middle.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = deleteMiddle(
                new ListNode(1));
        ListNode n4 = deleteMiddle(
                new ListNode(1,
                new ListNode(2)));
        ListNode n5 = deleteMiddle(
                new ListNode(1,
                new ListNode(2,
                new ListNode(3))));
        ListNode n2 = deleteMiddle(
                new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5))))));

        ListNode n3 = deleteMiddle(
                new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5,
                new ListNode(6)))))));
    }
}
