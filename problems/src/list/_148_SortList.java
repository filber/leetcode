// https://leetcode.com/problems/sort-list/
package list;

public class _148_SortList {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode fast = head, slow = head;
        while (slow.next != null && slow.next.next != null) {
            fast = fast.next;
            slow = slow.next.next;
        }

        ListNode firstPart = head;
        ListNode secondPart = fast.next;
        fast.next = null;
        firstPart = sortList(firstPart);
        secondPart = sortList(secondPart);

        ListNode ans;
        if (firstPart.val < secondPart.val) {
            ans = firstPart;
            firstPart = firstPart.next;
        } else {
            ans = secondPart;
            secondPart = secondPart.next;
        }
        ans.next = null;
        ListNode cur = ans;

        while (firstPart != null && secondPart != null) {
            if (firstPart.val < secondPart.val) {
                cur.next = firstPart;
                firstPart = firstPart.next;
            } else {
                cur.next = secondPart;
                secondPart = secondPart.next;
            }
            cur = cur.next;
        }

        if (firstPart != null) {
            cur.next = firstPart;
        }
        if (secondPart != null) {
            cur.next = secondPart;
        }

        return ans;
    }
}
