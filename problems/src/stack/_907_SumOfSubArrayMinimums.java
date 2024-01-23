package stack;

//https://leetcode.com/problems/sum-of-subarray-minimums/

import java.util.Arrays;
import java.util.Stack;

public class _907_SumOfSubArrayMinimums {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] right = new int[n];
        Arrays.fill(right, n);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            int val = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] >= val) {
                int peek = stack.pop();
                right[peek] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            right[stack.pop()] = n;
        }

        int[] left = new int[n];
        Arrays.fill(left, -1);
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int val = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] > val) {
                int peek = stack.pop();
                left[peek] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            left[stack.pop()] = -1;
        }

        long result = 0;
        long mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            long val = arr[i];
            long l = i - left[i];
            long r = right[i] - i;
            result += l * val * r;
        }
        return (int) (result % mod);
    }
}
