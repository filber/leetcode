package tree;

//https://leetcode.com/problems/house-robber-iii/

//[Depth-First Search]
public class _337_HouseRobberIII {

    public static int rob(TreeNode root) {
        int[] ret = robNode(root);
        return Math.max(ret[0], ret[1]);
    }

    // return ret[0] without root, ret[1] with root
    public static int[] robNode(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = robNode(root.left);
        int[] right = robNode(root.right);

        int withRoot = root.val + left[0] + right[0];
        int withoutRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{withoutRoot, withRoot};
    }


    public static void main(String[] args) {
        int m1 = rob(new TreeNode(3,
                new TreeNode(2,
                        null, new TreeNode(3)),
                new TreeNode(3,
                        null, new TreeNode(1))));

        int m2 = rob(new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(5,
                        null,
                        new TreeNode(1))));
    }
}
