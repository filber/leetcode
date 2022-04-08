package tree;

//https://leetcode.com/problems/binary-tree-paths/

import java.util.ArrayList;
import java.util.List;

public class _257_BinaryTreePaths {

    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(new ArrayList<>(), root);
        return ans;
    }

    private void dfs(List<Integer> list, TreeNode node) {
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int val : list) {
                sb.append(val);
                sb.append("->");
            }
            sb.append(node.val);
            ans.add(sb.toString());
            return;
        }

        if (node.left != null) {
            list.add(node.val);
            dfs(list, node.left);
            list.remove(list.size() - 1);
        }

        if (node.right != null) {
            list.add(node.val);
            dfs(list, node.right);
            list.remove(list.size() - 1);
        }
    }
}
