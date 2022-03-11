package list;

//https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/

import java.util.HashSet;
import java.util.Set;

public class _1836_RemoveDuplicatesFromAnUnsortedLinkedList {

    //For example if the linked list is 12->11->12->21->41->43->21
    //then you should convert the list to 41->43.
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> removeSet = new HashSet<>();
        ListNode cur = head;
        // 1. Detect duplicates
        while (cur != null) {
            if (numSet.contains(cur.val)) {
                removeSet.add(cur.val);
            } else {
                numSet.add(cur.val);
            }
            cur = cur.next;
        }

        // 2. Move head to skip duplicates
        while (head != null && removeSet.contains(head.val)) {
            head = head.next;
        }

        // 3. Using Two Pointers to remove duplicates
        ListNode l = head;
        ListNode r = head == null ? null : head.next;
        while (r != null) {
            if (removeSet.contains(r.val)) {
                l.next = r.next;
            } else {
                l = r;
            }
            r = r.next;
        }

        return head;
    }
}
