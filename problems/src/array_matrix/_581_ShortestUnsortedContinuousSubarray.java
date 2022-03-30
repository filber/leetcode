package array_matrix;

//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

public class _581_ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int R = 0;
        int L = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max) {
                R = i;
            } else {
                max = arr[i];
            }

            int j = arr.length - 1 - i;
            if (min < arr[j]) {
                L = j;
            } else {
                min = arr[j];
            }
        }

        return R == L ? 0 : R - L + 1;
    }
}
