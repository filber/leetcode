public class _1382_BalanceABinarySearchTree {

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

    public static TreeNode balanceBST(TreeNode root) {
        int[] nodeValues = new int[10000];
        int cnt = inOrderTraverse(root,nodeValues,0);
        return balanceBST(nodeValues, 0, cnt - 1,cnt);
    }

    public static TreeNode balanceBST(int[] nums,int start,int end,int cnt) {
        if (start < 0 || end >= cnt || start > end) {
            return null; // no element
        } else if (start == end) {
            return new TreeNode(nums[start]);
        }
        int middleIndex = (start + end) / 2;
        int middleValue = nums[middleIndex];
        TreeNode leftTree = balanceBST(nums, start, middleIndex - 1, cnt);
        TreeNode rightTree = balanceBST(nums, middleIndex + 1, end, cnt);
        return new TreeNode(middleValue,leftTree,rightTree);
    }

    private static int inOrderTraverse(TreeNode root, int[] nums, int start) {
        if (root==null) {
            return start;
        } else if (root.left!=null) {
            // traverse the left subtree
            start = inOrderTraverse(root.left,nums,start);
        }
        nums[start] = root.val;
        // traverse the right subtree
        return inOrderTraverse(root.right, nums, start + 1);
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        r1 = balanceBST(r1);

        TreeNode r2 = new TreeNode(2,
                      new TreeNode(1),
                      new TreeNode(3));
        r2 = balanceBST(r2);

        TreeNode r3 = new TreeNode(1,null,
                      new TreeNode(2,null,
                      new TreeNode(3,null,
                      new TreeNode(4))));
        r3 = balanceBST(r3);
    }
}
