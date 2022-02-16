package list;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int[] nums) {
        if (nums== null || nums.length == 0) {
            return;
        }
        this.val = nums[0];
        ListNode cur = this;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
    }

    public int[] toArray() {
        ListNode cur = this;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int[] res = new int[len];
        int i = 0;
        cur = this;
        while (cur != null) {
            res[i++] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
