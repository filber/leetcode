package array_matrix;

//https://www.geeksforgeeks.org/find-first-k-natural-numbers-missing-given-array/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _EX_FindFirstKNaturalNumbersMissingInGivenArray {

    // Natural numbers start from 1

    public int[] findKMissing(int nums[], int k) {
        Arrays.sort(nums);
        int l = 0;
        while (l < nums.length && nums[l] <= 0) {
            l++;
        }

        int[] rst = new int[k];
        int r = 0;
        int expect = 1;

        while (l < nums.length && r < k) {
            while (r < k && nums[l] != expect) {
                rst[r++] = expect++;
            }
            expect++;
            l++;
        }

        while (r < k) {
            rst[r++] = expect++;
        }
        return rst;
    }
}
