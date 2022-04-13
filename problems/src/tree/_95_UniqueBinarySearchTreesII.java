package tree;

//https://leetcode.com/problems/unique-binary-search-trees-ii/

import java.util.ArrayList;
import java.util.List;

public class _95_UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return backtracking(n, 1);
    }

    private List<TreeNode> backtracking(int n, int l) {
        List<TreeNode> list = new ArrayList<>();
        if (n == 0) {
            return list;
        } else if (n == 1) {
            list.add(new TreeNode(l));
            return list;
        }

        for (int i = 0; i <= n - 1; i++) {
            List<TreeNode> leftNodes = backtracking(i, l);
            List<TreeNode> rightNodes = backtracking(n - 1 - i, l + i + 1);
            if (leftNodes.isEmpty()) {
                for (int j = 0; j < rightNodes.size(); j++) {
                    TreeNode root = new TreeNode(l + i);
                    root.right = rightNodes.get(j);
                    list.add(root);
                }
            } else if (rightNodes.isEmpty()) {
                for (int j = 0; j < leftNodes.size(); j++) {
                    TreeNode root = new TreeNode(l + i);
                    root.left = leftNodes.get(j);
                    list.add(root);
                }
            } else {
                for (int j = 0; j < leftNodes.size(); j++) {
                    for (int k = 0; k < rightNodes.size(); k++) {
                        TreeNode root = new TreeNode(l + i);
                        root.left = leftNodes.get(j);
                        root.right = rightNodes.get(k);
                        list.add(root);
                    }
                }
            }
        }

        return list;
    }
}
