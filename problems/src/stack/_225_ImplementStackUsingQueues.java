package stack;

//https://leetcode.com/problems/implement-stack-using-queues/

import java.util.ArrayDeque;

public class _225_ImplementStackUsingQueues {

    public static class MyStack {

        ArrayDeque<Integer> leftQueue = new ArrayDeque<>();
        ArrayDeque<Integer> rightQueue = new ArrayDeque<>();

        public MyStack() {
        }

        public void push(int x) {
            leftQueue.addLast(x);
        }

        public int pop() {
            while (leftQueue.size() > 1) {
                rightQueue.addLast(leftQueue.pollFirst());
            }
            int top = leftQueue.pop();
            // swap
            ArrayDeque<Integer> tmp = null;
            tmp = leftQueue;
            leftQueue = rightQueue;
            rightQueue = tmp;

            return top;
        }

        public int top() {
            int t = pop();
            leftQueue.addLast(t);
            return t;
        }

        public boolean empty() {
            return leftQueue.isEmpty();
        }
    }
}
