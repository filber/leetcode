package tree;

//https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/

import java.util.Stack;

public class _331_VerifyPreorderSerializationOfABinaryTree {

    public boolean isValidSerialization(String preorder) {
        String[] segments = preorder.split(",");
        if (segments.length == 1 && "#".equals(segments[0])) {
            return true;
        }
        Stack<boolean[]> stack = new Stack<>();

        for (int i = 0; i < segments.length; i++) {
            String segment = segments[i];
            if ("#".equals(segment)) {
                if (stack.isEmpty()) {
                    return false;
                }
                boolean[] peek = stack.peek();
                if (!peek[0]) {
                    peek[0] = true;
                } else if (!peek[1]) {
                    peek[1] = true;
                }
            } else {
                stack.push(new boolean[]{false, false});
            }
            while (!stack.isEmpty() && (stack.peek()[0] && stack.peek()[1])) {
                stack.pop();
                if (!stack.isEmpty()) {
                    boolean[] peek = stack.peek();
                    if (!peek[0]) {
                        peek[0] = true;
                    } else if (!peek[1]) {
                        peek[1] = true;
                    }
                }
            }
            if (stack.isEmpty() && i != segments.length - 1) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
