package list;

//https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/

import java.util.HashSet;
import java.util.Set;

public class _1836_RemoveDuplicatesFromAnUnsortedLinkedList {

    //For example if the linked list is 12->11->12->21->41->43->21
    //then you should convert the list to 41->43.
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        Set<Integer> reduceSet = new HashSet<>();
        Set<Integer> removeSet = new HashSet<>();
        while (cur != null) {
            if (reduceSet.contains(cur.val)) {
                removeSet.add(cur.val);
            } else {
                reduceSet.add(cur.val);
            }
            cur = cur.next;
        }

        while (head != null && removeSet.contains(head.val)) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
        }

        ListNode pre = head;
        cur = head == null ? null : head.next;

        while (cur != null) {
            if (removeSet.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }
}
