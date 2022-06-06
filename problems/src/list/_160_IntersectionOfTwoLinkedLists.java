package list;

//https://leetcode.com/problems/intersection-of-two-linked-lists/

public class _160_IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmp = headA;
        ListNode tailA = null;
        while (tmp != null) {
            tailA = tmp;
            tmp = tmp.next;
        }

        tailA.next = headB;

        ListNode slow = headA;
        ListNode fast = headA;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            tailA.next = null;
            return null;
        }
        fast = headA;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        tailA.next = null;
        return slow;
    }
}
