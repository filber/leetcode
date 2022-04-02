package array_matrix;

//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

public class _581_ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] arr) {
        int R = 0, L = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (arr[i] < max) {
                R = i;
            }

            int j = n - 1 - i;
            min = Math.min(min, arr[j]);
            if (arr[j] > min) {
                L = j;
            }
        }

        return L == R ? 0 : R - L + 1;
    }
}
