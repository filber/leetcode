package list;

//https://leetcode.com/problems/intersection-of-two-linked-lists/

public class _160_IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tail = headA;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = headB;

        ListNode slow = headA, fast = headA;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            tail.next = null;
            return null;
        }

        slow = headA;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        tail.next = null;
        return slow;
    }
}
