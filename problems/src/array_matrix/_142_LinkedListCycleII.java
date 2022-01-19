package array_matrix;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class _142_LinkedListCycleII {

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

//    Constraints:
//        The number of the nodes in the list is in the range [0, 104].
//        -105 <= Node.val <= 105
//        pos is -1 or a valid index in the linked-list.

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        // 1. Use fast&slow to detect cycle
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (slow == null || fast== null) {
                // no cycle
                return null;
            } else {
                slow = slow.next;
                fast = fast.next;
            }

            if (fast == null) {
                // no cycle
                return null;
            } else {
                fast = fast.next;
            }
        } while (fast != slow);

        // 2. Find length of cycle
        int cycleLen = 0;
        do {
            slow = slow.next;
            fast = fast.next.next;
            cycleLen++;
        } while (slow != fast);

        // 3. Get entry of the cycle
        // fast pointer walks len steps, then slow pointer starts to walk
        slow = head;
        fast = head;
        for (int i = 0; i < cycleLen; i++) {
            fast = fast.next;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode h1_1 = new ListNode(3);
        ListNode h1_2 = new ListNode(2);
        h1_1.next = h1_2;
        ListNode h1_3 = new ListNode(0);
        h1_2.next = h1_3;
        ListNode h1_4 = new ListNode(-4, h1_2);
        h1_3.next = h1_4;
        ListNode h1 = detectCycle(h1_1);

        ListNode h2_1 = new ListNode(1);
        ListNode h2_2 = new ListNode(2);
        h2_1.next = h2_2;
        h2_2.next = h2_1;
        ListNode h2 = detectCycle(h2_1);

        ListNode h3_1 = new ListNode(1);
        ListNode h3 = detectCycle(h3_1);

        ListNode h4_1 = new ListNode(1, new ListNode(2));
        ListNode h4 = detectCycle(h4_1);

        ListNode h5_1 = new ListNode(1);
        h5_1.next = h5_1;
        ListNode h5 = detectCycle(h5_1);
    }
}
