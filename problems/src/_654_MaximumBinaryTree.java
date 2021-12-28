public class _654_MaximumBinaryTree {
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

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public static TreeNode construct(int[] nums, int start, int end) {
        // 0. Guard conditions
        if (start < 0 || end >= nums.length || start > end) {
            return null; // no element
        } else if (start==end) {
            return new TreeNode(nums[start]);
        }

        // 1. Find the max value and its index
        int maxValue = nums[start];
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        // 2. Recursively construct left&right subtree
        TreeNode leftTree = construct(nums,start,maxIndex-1);
        TreeNode rightTree = construct(nums, maxIndex + 1, end);

        // 3. Construct root
        return new TreeNode(maxValue,leftTree,rightTree);
    }

    public static void main(String[] args) {
        TreeNode t1 = constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});

        TreeNode t2 = constructMaximumBinaryTree(new int[]{3, 2, 1});

        TreeNode t3 = constructMaximumBinaryTree(new int[]{1});

        TreeNode t4 = constructMaximumBinaryTree(new int[]{1,2});

        TreeNode t5 = constructMaximumBinaryTree(new int[]{3,2});
    }
}
