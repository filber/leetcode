package list;

//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

public class _1721_SwappingNodesInALinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, slow = head;
        int n = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            n++;
        }
        if (fast == null) {
            n *= 2;
        } else {
            n = n * 2 + 1;
        }

        k--;
        int lIdx = Math.min(k, n - 1 - k);
        int rIdx = Math.max(k, n - 1 - k) - n / 2;
        ListNode lNode = head;
        for (int i = 0; i < lIdx; i++) {
            lNode = lNode.next;
        }

        ListNode rNode = slow;
        for (int i = 0; i < rIdx; i++) {
            rNode = rNode.next;
        }

        int tmp = lNode.val;
        lNode.val = rNode.val;
        rNode.val = tmp;
        return head;
    }
}
