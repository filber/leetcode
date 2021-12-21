/**
 * TIPS: Convert LinkedList to Array which allowing random access
 */
public class _109_ConvertSortedListToBinarySearchTree {
    /**
    Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
    Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode sortedListToBST(ListNode head) {
        int[] nums = convertToArray(head);
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(nums[start], null, null);
        } else {
            int rootIndex = (start + end) / 2;
            int rootValue = nums[rootIndex];
            TreeNode leftTree = sortedArrayToBST(nums, start, rootIndex - 1);
            TreeNode rightTree = sortedArrayToBST(nums, rootIndex + 1, end);
            return new TreeNode(rootValue, leftTree, rightTree);
        }
    }

    private static int[] convertToArray(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        cur = head;
        int[] nums = new int[count];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = cur.val;
            cur = cur.next;
        }
        return nums;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        TreeNode t1 = sortedListToBST(h1);

        ListNode h2 = new ListNode(-10);
        TreeNode t2 = sortedListToBST(h2);

        ListNode h3 = new ListNode(-10, new ListNode(-3));
        TreeNode t3 = sortedListToBST(h3);
    }
}
