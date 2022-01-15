package math;

// https://leetcode.com/problems/beautiful-array/

import java.util.Arrays;

// TIPS: When doing mathematics problems, considering:
// positive&negative
// even&odd, always even:2*a,  always odd:2*a-1
// transformations(a*V, a+V, a*V+b, V/a, V%a, V^a)
// recursively construct from BottomToTop/TopToBottom
// avoid struggling at obvious laws of number
public class _932_BeautifulArray {

    // (1) A is BA, then a*A + b is BA
    // (2) A is BA of only even, b is BA of only odd, then [A,B] is BA
    public static int[] beautifulArray(int n) {
        // 1. Initialize array
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        constructBA(nums, 0, n - 1);
        return nums;
    }

    private static void constructBA(int[] nums, int start, int end) {
        // 0. Guard condition
        if (start==end) {
            // one element
            return;
        }

        // 1. Build left&right separately
        int middle = (start + end) / 2;
        // build left part
        constructBA(nums,start,middle);
        // build right part
        constructBA(nums, middle + 1, end);

        // 3. Join two parts together
        // left*2 -1
        for (int i = start; i <= middle; i++) {
            nums[i] = nums[i] * 2 - 1;
        }
        // right*2
        for (int i = middle + 1; i <= end; i++) {
            nums[i] = nums[i] * 2;
        }
    }

    public static void main(String[] args) {
        int[] n1 = beautifulArray(1);
        int[] n2 = beautifulArray(2);
        int[] n3 = beautifulArray(3);
        int[] n4 = beautifulArray(4);
        int[] n5 = beautifulArray(5);
        int[] n6 = beautifulArray(6);
        int[] n7 = beautifulArray(7);
        int[] n8 = beautifulArray(8);
        int[] n9 = beautifulArray(9);
        int[] n10 = beautifulArray(10);
    }
}
