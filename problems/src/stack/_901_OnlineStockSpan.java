package stack;

import java.util.Stack;

// https://leetcode.com/problems/online-stock-span/
//[Monotonic Stack]
public class _901_OnlineStockSpan {

    static class StockSpanner {

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
            stack.push(new Node(Integer.MAX_VALUE, -1));
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

    public static void main(String[] args) {
        StockSpanner s1 = new StockSpanner();
        int n1_1 = s1.next(100); // 1 [100(1)]
        int n1_2 = s1.next(80); // 1 [100(1),80(1)]
        int n1_3 = s1.next(60); // 1 [100(1),80(1),60(1)]
        int n1_4 = s1.next(70); // 2 [100(1),80(1),70(2)]
        int n1_5 = s1.next(60); // 1 [100(1),80(1),70(2),60(1)]
        int n1_6 = s1.next(75); // 4 [100(1),80(1),75(4)]
        int n1_7 = s1.next(85); // 6 [100(1),85(6)]

        StockSpanner s2 = new StockSpanner();
        int n2_1 = s2.next(29); // 1 [29(1)]
        int n2_2 = s2.next(91); // 2 [91(2)]
        int n2_3 = s2.next(62); // 1 [91(2),62(1)]
        int n2_4 = s2.next(76); // 2 [91(2),76(2)]
        int n2_5 = s2.next(51); // 1 [91(2),76(2),51(1)]

        StockSpanner s3 = new StockSpanner();
        int n3_1 = s3.next(28);
        int n3_2 = s3.next(14);
        int n3_3 = s3.next(28);
    }
}
