// https://leetcode.com/problems/sort-list/
package list;

/**
 * TIPS: using fast-slow pointers to locate the middle of a linked list
 */
public class _148_SortList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

//    Constraints:
//    The number of nodes in the list is in the range [0, 5 * 104].
//            -105 <= Node.val <= 105
    public static ListNode sortList(ListNode head) {
        // 0. Guard conditions
        if (head == null) {
            return null; // no element
        } else if (head.next == null) {
            return head; // one element
        }

        // 1. Find Middle
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next == null || fast.next.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        // 2. Break the list into two chains
        ListNode leftChain = head;
        ListNode rightChain = slow.next;
        slow.next = null;

        // 3. Sort two chains separately
        leftChain = sortList(leftChain);
        rightChain = sortList(rightChain);
        // return either chain if the other one is empty
        if (leftChain == null) {
            return rightChain;
        } else if (rightChain == null) {
            return leftChain;
        }

        // 4. Merge two chains
        // 4.1. Initialize head and cursor
        if (leftChain.val <= rightChain.val) {
            head = leftChain;
            leftChain = leftChain.next;
        } else {
            head = rightChain;
            rightChain = rightChain.next;
        }
        head.next = null;
        ListNode cur = head;

        // 4.2 append both
        while (leftChain != null && rightChain != null) {
            if (leftChain.val <= rightChain.val) {
                cur.next = leftChain;
                leftChain = leftChain.next;
            } else {
                cur.next = rightChain;
                rightChain = rightChain.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        // 4.3. append left remaining
        while (leftChain != null) {
            cur.next = leftChain;
            leftChain = leftChain.next;
            cur = cur.next;
            cur.next = null;
        }
        // 4.4. append right remaining
        while (rightChain != null) {
            cur.next = rightChain;
            rightChain = rightChain.next;
            cur = cur.next;
            cur.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        // 4,2,1,3
        ListNode h1 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        // 1,2,3,4
        ListNode s1 = sortList(h1);

        // -1,5,3,4,0
        ListNode h2 = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        // -1,0,3,4,5
        ListNode s2 = sortList(h2);

        // null
        ListNode s3 = sortList(null);

        // 1
        ListNode s4 = sortList(new ListNode(1));

        // 4,19,14,5,-3,1,8,5,11,15
        ListNode h5 = new ListNode(4,
                new ListNode(19,
                new ListNode(14,
                new ListNode(5,
                new ListNode(-3,
                new ListNode(1,
                new ListNode(8,
                new ListNode(5,
                new ListNode(11,
                new ListNode(15
                        ))))))))));
        ListNode s5 = sortList(h5);

    }
}
