package list;

//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1171_RemoveZeroSumConsecutiveNodesFromLinkedList {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode startnode = new ListNode(0);
        startnode.next = head;
        int prefixsum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(prefixsum, startnode);
        while (head != null) {
            prefixsum += head.val;
            map.put(prefixsum, head);
            head = head.next;
        }
        head = startnode;
        prefixsum = 0;
        while (head != null) {
            prefixsum += head.val;
            head.next = map.get(prefixsum).next;
            head = head.next;
        }
        return startnode.next;
    }
}
