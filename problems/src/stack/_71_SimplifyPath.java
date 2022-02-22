package stack;

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/

public class _71_SimplifyPath {

    public static String simplifyPath(String path) {
        String[] segments = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String segment : segments) {
            if (segment.equals(".") || segment.isBlank()) {
                // ignore
            } else if (segment.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(segment);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            for (String segment : stack) {
                sb.append('/');
                sb.append(segment);
            }
            return sb.toString();
        }
    }
}
