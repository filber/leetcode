package stack;

import java.util.*;

public class _895_MaximumFrequencyStack {

    public static class FreqStack {

        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Stack<Integer>> stackMap = new HashMap<>();

        int maxFreq = Integer.MIN_VALUE;

        public FreqStack() {
        }

        public void push(int x) {
            int count = freqMap.getOrDefault(x, 0) + 1;
            freqMap.put(x, count);
            if (count > maxFreq) {
                maxFreq = count;
            }

            Stack<Integer> stack = stackMap.computeIfAbsent(count, k -> new Stack<>());
            stack.push(x);
        }

        public int pop() {
            int res = stackMap.get(maxFreq).pop();

            if (stackMap.get(maxFreq).isEmpty()) {
                maxFreq--;
            }

            int count = freqMap.get(res) - 1;
            freqMap.put(res, count);
            return res;
        }
    }
}
