import java.util.Stack;

// TIPS: reversing the right part of the linked list
public class _143_ReorderList {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

//    Constraints:
//        The number of nodes in the list is in the range [1, 5 * 104].
//            1 <= Node.val <= 1000
    public static void reorderList(ListNode head) {
        // 0. Guard conditions
        if (head.next == null || // one element
            head.next.next == null) // two elements
        {
            return; // do nothing
        }

        // 1. Using fast&slow pointers to locate the middle position
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null) {
            if (fast.next.next == null) {
                break;
            }
            slow = slow.next; // move one position
            fast = fast.next;
            if (fast.next!=null) {
                fast = fast.next; // move twice
            }
        }

        // 2. Split the List into two parts
        ListNode leftHead = head;
        ListNode rightHead = slow.next;
        slow.next = null; // break the list

        // 3. Reverse the right part
        rightHead =  reverseList(rightHead);

        // 4. Merging two parts together
        while (rightHead!=null) {
            ListNode leftCur = leftHead;
            leftHead = leftHead.next;
            leftCur.next = rightHead;

            ListNode rightCur = rightHead;
            rightHead = rightHead.next;
            rightCur.next = leftHead;
        }
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            // do nothing
            return head;
        } else {
            // two or more elements
            ListNode left = head;
            ListNode right = head.next;
            left.next = null;
            while (right != null) {
                ListNode nextRight = right.next;
                right.next = left;
                left = right;
                right = nextRight;
            }
            return left;
        }
    }

    public static void main(String[] args) {
        // Input: head = [1,2,3,4]
        // Output: [1,4,2,3]
        ListNode h1 = new ListNode(1,
                    new ListNode(2,
                    new ListNode(3,
                    new ListNode(4))));
//        reverseList(h1);
        reorderList(h1);

        // Input: head = [1,2,3,4,5]
        // Output: [1,5,2,4,3]
        ListNode h2 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));
        reorderList(h2);

        // Input: head = [1]
        // Output: [1]
        ListNode h3 = new ListNode(1);
        reorderList(h3);

        // Input: head = [1,2]
        // Output: [1,2]
        ListNode h4 = new ListNode(1,new ListNode(2));
        reorderList(h4);

        // Input: head = [1,2,3,4,5,6,7]
        // Output: [1,7,2,6,3,6,4]
        ListNode h5 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5,
                new ListNode(6,
                new ListNode(7
        )))))));
        reorderList(h5);
    }
}
