package tree;

// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

import java.util.ArrayList;
import java.util.List;

public class _1305_AllElementsInTwoBinarySearchTrees {

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inOrderTraverse(root1, list1);
        inOrderTraverse(root2, list2);

        List<Integer> res = new ArrayList<>(list1.size() + list2.size());

        int l = 0, r = 0;
        while (l < list1.size() && r < list2.size()) {
            int lVal = list1.get(l);
            int rVal = list2.get(r);
            if (lVal == rVal) {
                res.add(lVal);
                res.add(rVal);
                l++;
                r++;
            } else if (lVal < rVal) {
                res.add(lVal);
                l++;
            } else {
                res.add(rVal);
                r++;
            }
        }

        while (l < list1.size()) {
            res.add(list1.get(l));
            l++;
        }

        while (r < list2.size()) {
            res.add(list2.get(r));
            r++;
        }

        return res;
    }

    private static void inOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, list);
        list.add(root.val);
        inOrderTraverse(root.right, list);
    }

    public static void main(String[] args) {
        // [0,1,1,2,3,4]
        List<Integer> l1 = getAllElements(
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(4)),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(3)));
        // [1,1,8,8]
        List<Integer> l2 = getAllElements(
                new TreeNode(1,
                        null,
                        new TreeNode(8)),
                new TreeNode(8,
                        new TreeNode(1),
                        null));

        // [-10,0,0,1,2,5,7,10]
        List<Integer> l3 = getAllElements(
                new TreeNode(0,
                        new TreeNode(-10),
                        new TreeNode(10)),
                new TreeNode(5,
                        new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(2)),
                        new TreeNode(7)));

    }

}
