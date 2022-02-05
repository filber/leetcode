package list;

// https://leetcode.com/problems/reverse-nodes-in-k-group/

public class _25_ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int cnt = k;

        // 1. Measure length of List
        ListNode cur = head;
        while (cur!=null&&cnt!=0) {
            cur = cur.next;
            cnt --;
        }

        // 2. Len < k, no need for reversing
        if (cnt != 0) {
            return head;
        }


        // 3. Reverse the list
        cur = head;
        ListNode next = cur.next;
        cur.next = null;
        for (int i = 0; i < k - 1; i++) {
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }


        // 4. Link to next reversed List
        head.next = reverseKGroup(next,k);
        return cur;
    }


    public static void main(String[] args) {
        ListNode l3 = reverseKGroup(
                new ListNode(1,
                new ListNode(2,
                new ListNode(3))), 2);

        // [2,1,4,3,5]
        ListNode l1 = reverseKGroup(
                new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5))))),2);
        // [3,2,1,4,5]
        ListNode l2 = reverseKGroup(
                new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5))))),3);
    }


}
