package stack;

//https://leetcode.com/problems/sum-of-subarray-minimums/

import java.util.Arrays;

public class _907_SumOfSubArrayMinimums {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n]; // store the index of the closest smaller value before i
        int[] right = new int[n]; // store the index of the closest smaller value after i
        Arrays.fill(right, n);
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            while (top >= 0 && arr[stack[top]] >= arr[i]) {
                int peek = stack[top];
                right[peek] = i;
                top--;
            }
            if (top >= 0) {
                left[i] = stack[top];
            }
            stack[++top] = i;
        }


        long sum = 0;
        final int modulo = (int) (1e9 + 7);
        for (int i = 0; i < n; i++) {
            long x = i - left[i];
            long y = right[i] - i;
            long delta = x * y * arr[i];
            sum += delta;
        }
        return (int) (sum % modulo);
    }
}
