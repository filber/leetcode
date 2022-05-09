package stack;

//https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.Stack;

public class _232_ImplementQueueUsingStacks {

    public static class MyQueue {

        int[] leftStack = new int[100];
        int leftTop = -1;
        int[] rightStack = new int[100];
        int rightTop = -1;

        public MyQueue() {
        }

        public void push(int x) {
            leftStack[++leftTop] = x;
        }

        public int pop() {
            while (leftTop > 0) {
                rightStack[++rightTop] = leftStack[leftTop--];
            }
            int val = leftStack[leftTop--];
            while (rightTop > -1) {
                leftStack[++leftTop] = rightStack[rightTop--];
            }
            return val;
        }

        public int peek() {
            while (leftTop > 0) {
                rightStack[++rightTop] = leftStack[leftTop--];
            }
            int val = leftStack[leftTop];
            while (rightTop > -1) {
                leftStack[++leftTop] = rightStack[rightTop--];
            }
            return val;
        }

        public boolean empty() {
            return leftTop == -1;
        }
    }
}
