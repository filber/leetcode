package list;

public class _141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {
            fast = fast.next;
            slow = slow.next;
            if (slow != null) {
                slow = slow.next;
            }

            if (slow != null && fast == slow) {
                return true;
            }
        }
        return false;
    }
}
