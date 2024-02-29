package tree;

import java.util.*;

//https://leetcode.com/problems/smallest-string-starting-from-leaf/
public class _988_SmallestStringStartingFromLeaf {

    List<Integer> result;

    public String smallestFromLeaf(TreeNode root) {
        result = new ArrayList<>();
        backtracking(new ArrayList<Integer>(),root);
        StringBuilder sb = new StringBuilder();
        for(int i=result.size()-1;i>=0;i--) {
            sb.append((char)(result.get(i).intValue()+'a'));
        }
        return sb.toString();
    }

    private void backtracking(List<Integer> list, TreeNode node) {
        list.add(node.val);
        if(node.left==null && node.right == null) {
            update(list);
        } else {
            if(node.left!=null) {
                backtracking(list,node.left);
            }
            if(node.right!=null) {
                backtracking(list,node.right);
            }
        }
        list.remove(list.size()-1);
    }

    private void update(List<Integer> list) {
        if(result.isEmpty()) {
            result = new ArrayList<>(list);
            return;
        }
        int idx = 0;
        while(idx<list.size() && idx<result.size()) {
            int left = list.get(list.size()-1-idx).intValue();
            int right = result.get(result.size()-1-idx).intValue();
            if(left > right) {
                return;
            } else if(left < right) {
                result = new ArrayList<>(list);
                return;
            }
            idx++;
        }
        if(result.size() > list.size()) {
            result = new ArrayList<>(list);
        }
    }
}
