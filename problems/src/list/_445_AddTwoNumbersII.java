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

        ListNode ans = add(l1, m - 1, l2, n - 1);
        if (ans.val >= 10) {
            // handle head if it's GE 10
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
            return new ListNode(left.val + right.val);
        }

        int sum;
        ListNode next;
        if (l == r) {
            next = add(left.next, l - 1, right.next, r - 1);
            sum = left.val + right.val;
        } else if (l > r) {
            next = add(left.next, l - 1, right, r);
            sum = left.val;
        } else {
            next = add(left, l, right.next, r - 1);
            sum = right.val;
        }
        sum += next.val / 10;
        next.val %= 10;
        return new ListNode(sum, next);
    }

}
