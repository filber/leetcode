package stack;

//https://leetcode.com/problems/min-stack/

import java.util.Stack;

public class _155_MinStack {

    class MinStack {

        Stack<int[]> stack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new int[]{val, val});
            } else {
                int min = Math.min(val, stack.peek()[1]);
                stack.push(new int[]{val, min});
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }
}
