package stack;

//https://leetcode.com/problems/maximum-frequency-stack/

import java.util.*;

public class _895_MaximumFrequencyStack {

    public static class FreqStack {

        Map<Integer, Integer> valMap = new HashMap<>();
        Map<Integer, Stack<Integer>> stackMap = new HashMap<>();
        int maxCnt = Integer.MIN_VALUE;

        public FreqStack() {
        }

        public void push(int x) {
            int cnt = valMap.getOrDefault(x, 0) + 1;
            valMap.put(x, cnt);
            Stack<Integer> stack = stackMap.computeIfAbsent(cnt, k -> new Stack<>());
            stack.push(x);
            maxCnt = Math.max(maxCnt, cnt);
        }

        public int pop() {
            Stack<Integer> stack = stackMap.get(maxCnt);
            int val = stack.pop();
            valMap.put(val, valMap.getOrDefault(val, 1) - 1);
            if (stack.isEmpty()) {
                maxCnt--;
            }
            return val;
        }
    }
}
