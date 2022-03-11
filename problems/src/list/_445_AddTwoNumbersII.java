package list;

//https://leetcode.com/problems/add-two-numbers-ii/

public class _445_AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. Measure Length
        int m = 0, n = 0;
        ListNode lNode = l1, rNode = l2;
        while (lNode != null) {
            lNode = lNode.next;
            m++;
        }
        while (rNode != null) {
            rNode = rNode.next;
            n++;
        }

        // 2. Guard condition
        if (m == 1 && l1.val == 0) {
            return l2;
        }
        if (n == 1 && l2.val == 0) {
            return l1;
        }

        // 3. add two list
        ListNode ans = add(l1, m - 1, l2, n - 1);
        if (ans.val >= 10) {
            // 4. handle head if it's GE 10
            ListNode head = new ListNode(ans.val / 10, ans);
            ans.val %= 10;
            return head;
        } else {
            return ans;
        }
    }

    public ListNode add(ListNode left, int l, ListNode right, int r) {
        if (l == 0 && r == 0) {
            // reaching the end
            left.val += right.val;
            return left;
        }

        if (l == r) {
            ListNode next = add(left.next, l - 1, right.next, r - 1);
            left.val += right.val + next.val / 10;
            left.next = next;
            next.val %= 10;
            return left;
        } else if (l > r) {
            ListNode next = add(left.next, l - 1, right, r);
            left.val += next.val / 10;
            left.next = next;
            next.val %= 10;
            return left;
        } else {
            ListNode next = add(left, l, right.next, r - 1);
            right.val += next.val / 10;
            right.next = next;
            next.val %= 10;
            return right;
        }
    }
}
