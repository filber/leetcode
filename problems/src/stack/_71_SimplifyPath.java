package stack;

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/

public class _71_SimplifyPath {

    public String simplifyPath(String path) {
        String[] segments = path.split("/");
        String[] stack = new String[segments.length];
        int top = -1;

        for (String segment : segments) {
            if (".".equals(segment) || segment.isEmpty()) {
                // ignore
            } else if ("..".equals(segment)) {
                if (top >= 0) {
                    top--;
                }
            } else {
                stack[++top] = segment;
            }
        }

        if (top == -1) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append('/').append(stack[i]);
        }
        return sb.toString();
    }

}
