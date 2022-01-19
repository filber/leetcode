package array_matrix;

public class _141_LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (slow == null || fast == null) {
                return false;
            } else {
                slow = slow.next;
                fast = fast.next;
            }

            if (fast == null) {
                return false;
            } else {
                fast = fast.next;
            }
        } while (fast != slow);

        return true;
    }

    public static void main(String[] args) {
        ListNode h1_1 = new ListNode(3);
        ListNode h1_2 = new ListNode(2);
        h1_1.next = h1_2;
        ListNode h1_3 = new ListNode(0);
        h1_2.next = h1_3;
        ListNode h1_4 = new ListNode(-4, h1_2);
        h1_3.next = h1_4;
        boolean b1 = hasCycle(h1_1);

        ListNode h2_1 = new ListNode(1);
        ListNode h2_2 = new ListNode(2);
        h2_1.next = h2_2;
        h2_2.next = h2_1;
        boolean b2 = hasCycle(h2_1);

        ListNode h3_1 = new ListNode(1);
        boolean b3 = hasCycle(h3_1);

        ListNode h4_1 = new ListNode(1, new ListNode(2));
        boolean b4 = hasCycle(h4_1);

        ListNode h5_1 = new ListNode(1);
        h5_1.next = h5_1;
        boolean b5 = hasCycle(h5_1);
    }
}
