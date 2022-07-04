package list;

//https://leetcode.com/problems/odd-even-linked-list/

public class _328_OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode even = evenHead;
        ListNode cur = head;
        int idx = 1;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (idx % 2 == 1) {
                odd.next = cur;
                odd = odd.next;
            } else {
                even.next = cur;
                even = even.next;
            }
            idx++;
            cur = next;
        }

        odd.next = evenHead.next;
        return oddHead.next;
    }
}
