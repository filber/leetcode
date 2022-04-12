package tree;

//https://leetcode.com/problems/binary-tree-paths/

import java.util.ArrayList;
import java.util.List;

public class _257_BinaryTreePaths {

    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        backtracking(new ArrayList<>(), root);
        return ans;
    }

    private void backtracking(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int val : list) {
                sb.append(val).append("->");
            }
            sb.append(root.val);
            ans.add(sb.toString());
        } else {
            list.add(root.val);
            backtracking(list, root.left);
            backtracking(list, root.right);
            list.remove(list.size() - 1);
        }
    }

}
