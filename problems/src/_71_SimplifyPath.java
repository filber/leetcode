import java.util.Stack;

//TOPICS:
//[String],[Stack]

//TIPS:
//Using stack.pop() to handle upper directory
public class _71_SimplifyPath {

    public static String simplifyPath(String path) {
        String[] segments = path.split("/");

        Stack<String> stack = new Stack<>();
        for (String segment : segments) {
            if (".".equals(segment) || segment.isBlank()) {
                // do nothing
            } else if ("..".equals(segment)) {
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
                sb.append("/").append(segment);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {

        String p1 = simplifyPath("//"); // "/"
        String p2 = simplifyPath("/"); // "/"
        String p3 = simplifyPath("/./"); // "/"
        String p4 = simplifyPath("/../");   // "/"
        String p5 = simplifyPath("/../home");   // "/home"
        String p6 = simplifyPath("/../home/");   // "/home"
        String p7 = simplifyPath("/home/../");   // "/"
        String p8 = simplifyPath("/home/..");   // "/"
        String p9 = simplifyPath("/home/"); // "/home"
        String p10 = simplifyPath("/home//foo/");   // "/home/foo"
    }
}
