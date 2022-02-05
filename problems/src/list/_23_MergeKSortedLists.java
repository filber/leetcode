package list;

//https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.PriorityQueue;

public class _23_MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private static ListNode merge(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        } else if (i < j) {
            int mid = (i + j) / 2;
            ListNode l = merge(lists, i, mid);
            ListNode r = merge(lists, mid + 1, j);
            return merge(l, r);
        } else {
            return null;
        }
    }

    private static ListNode merge(ListNode l, ListNode r) {
        ListNode h = new ListNode(0);
        ListNode cur = h;
        while (l != null && r != null) {
            ListNode minNode;
            if (l.val < r.val) {
                minNode = l;
                l = l.next;
            } else {
                minNode = r;
                r = r.next;
            }
            minNode.next = null;
            cur.next = minNode;
            cur = cur.next;
        }

        if (l != null) {
            cur.next = l;
        }

        if (r != null) {
            cur.next = r;
        }

        return h.next;
    }

    public static ListNode mergeKListsPQ(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                pq.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        if (pq.isEmpty()) {
            return null;
        }

        ListNode head = pq.poll();
        head.next = null;
        ListNode cur = head;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            node.next = null;
        }

        return head;
    }

    public static ListNode mergeKListsLoop(ListNode[] lists) {
        int n = lists.length;
        ListNode head = null;
        ListNode cur = null;
        while (true) {
            // 1. Init
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            ListNode minNode = null;

            // 2. Find min
            for (int i = 0; i < n; i++) {
                ListNode node = lists[i];
                if (node != null && node.val < min) {
                    min = node.val;
                    minNode = node;
                    minIdx = i;
                }
            }

            // 3. All Lists are empty
            if (min == Integer.MAX_VALUE) {
                break;
            }

            // 4. Cut the node from original link
            lists[minIdx] = lists[minIdx].next;
            minNode.next = null;

            // 5. Link to head
            if (cur == null) {
                cur = minNode;
                head = cur;
            } else {
                cur.next = minNode;
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        // [[1,4,5],[1,3,4],[2,6]]
        // [1,1,2,3,4,4,5,6]
        ListNode[] l1 = new ListNode[3];
        l1[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        l1[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        l1[2] = new ListNode(2, new ListNode(6));
        ListNode h1 = mergeKLists(l1);

        ListNode h2 = mergeKLists(new ListNode[0]);

        ListNode h3 = mergeKLists(new ListNode[1]);
    }
}
