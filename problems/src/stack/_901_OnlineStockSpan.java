package stack;

import java.util.Stack;

// https://leetcode.com/problems/online-stock-span/
//[Monotonic Stack]
public class _901_OnlineStockSpan {

    public static class StockSpanner {

        static class Node {
            int val;
            int cnt;

            public Node(int val, int cnt) {
                this.val = val;
                this.cnt = cnt;
            }
        }

        Stack<Node> stack;

        public StockSpanner() {
            stack = new Stack<>();
            stack.push(new Node(Integer.MAX_VALUE, -1)); // sentry
        }

        public int next(int price) {
            Node node = new Node(price, 1);
            while (stack.peek().val <= price) {
                node.cnt += stack.pop().cnt;
            }
            stack.push(node);
            return node.cnt;
        }
    }
}
