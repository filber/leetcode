package array_matrix;

//https://leetcode.com/problems/linked-list-random-node/

import java.util.Random;

public class _382_LinkedListRandomNode {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private int[] arr = new int[10001];
    private int cnt = 0;
    private Random random = new Random();

    public _382_LinkedListRandomNode(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            arr[cnt] = temp.val;
            cnt++;
            temp = temp.next;
        }
    }

    public int getRandom() {
        int index = random.nextInt(cnt);
        return arr[index];
    }
}
