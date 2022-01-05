package tree;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//[Tree]
public class _108_ConvertSortedArrayToBinarySearchTree {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * @param start inclusive
     * @param end exclusive
     */
    public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int midIndex = (start + end) / 2;

        TreeNode leftChild = sortedArrayToBST(nums, start, midIndex - 1);
        TreeNode rightChild = sortedArrayToBST(nums, midIndex + 1, end);
        TreeNode root = new TreeNode(nums[midIndex], leftChild, rightChild);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root1 = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        TreeNode root2 = sortedArrayToBST(new int[]{-10, -3, 0, 5});
        TreeNode root3 = sortedArrayToBST(new int[]{-10});
        TreeNode root4 = sortedArrayToBST(new int[]{-10,-3});
    }

}
