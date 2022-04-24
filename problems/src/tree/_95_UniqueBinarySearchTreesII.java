package tree;

//https://leetcode.com/problems/unique-binary-search-trees-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _95_UniqueBinarySearchTreesII {


    public List<TreeNode> generateTrees(int n) {
        return backtracking(n, 1);
    }

    private List<TreeNode> backtracking(int n, int start) {
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return Arrays.asList(new TreeNode(start));
        }

        List<TreeNode> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<TreeNode> leftNodes = backtracking(i, start);

            List<TreeNode> rightNodes = backtracking(n - 1 - i, start + i + 1);
            if (leftNodes == null) {
                for (int j = 0; j < rightNodes.size(); j++) {
                    TreeNode root = new TreeNode(start + i);
                    root.right = rightNodes.get(j);
                    ans.add(root);
                }
            } else if (rightNodes == null) {
                for (int j = 0; j < leftNodes.size(); j++) {
                    TreeNode root = new TreeNode(start + i);
                    root.left = leftNodes.get(j);
                    ans.add(root);
                }
            } else {
                for (int j = 0; j < leftNodes.size(); j++) {
                    for (int k = 0; k < rightNodes.size(); k++) {
                        TreeNode root = new TreeNode(start + i);
                        root.left = leftNodes.get(j);
                        root.right = rightNodes.get(k);
                        ans.add(root);
                    }
                }
            }
        }
        return ans;
    }
}
