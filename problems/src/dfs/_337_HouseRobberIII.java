package dfs;

//https://leetcode.com/problems/house-robber-iii/
import java.util.HashMap;
import java.util.Map;

//[Depth-First Search]
public class _337_HouseRobberIII {
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

    public static int rob(TreeNode root) {
        int[] ret = robNode(root);
        return Math.max(ret[0], ret[1]);
    }

    // return ret[0] without root, ret[1] with root
    public static int[] robNode(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = robNode(root.left);
        int[] right = robNode(root.right);
        int[] ret = new int[2];
        ret[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ret[1] = left[0] + right[0] + root.val;
        return ret;
    }

    public static int robDFS(TreeNode root) {
        Map<TreeNode,int[]> map = new HashMap<>();
        int max = dfs(root, map, false);
        return max;
    }

    private static int dfs(TreeNode root, Map<TreeNode, int[]> map, boolean parentStolen) {
        if (root==null) {
            return 0;
        } else if (map.containsKey(root)) {
            int[] val = map.get(root);
            if (parentStolen) {
                return val[0];
            } else {
                return val[1];
            }
        }
        int skipRLeft = dfs(root.left,map,false);
        int skipRRight = dfs(root.right,map,false);
        int skipRCnt = skipRLeft + skipRRight;

        int stealRLeft = dfs(root.left,map,true);
        int stealRRight = dfs(root.right,map, true);
        int stealRCnt = stealRLeft + stealRRight;

        int[] count = new int[2];
        count[0] = skipRCnt;
        count[1] = Math.max(count[0], stealRCnt + root.val);
        map.put(root,count);
        if (parentStolen) {
            return count[0];
        } else {
            return count[1];
        }
    }

    public static void main(String[] args) {
        int m1 = rob(new TreeNode(3,
                new TreeNode(2,
                        null,new TreeNode(3)),
                new TreeNode(3,
                        null,new TreeNode(1))));

        int m2 = rob(new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(5,
                        null,
                        new TreeNode(1))));
    }
}
