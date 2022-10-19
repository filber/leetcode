package tp;

import java.util.Arrays;

public class _611_ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int cnt = 0;
        for (int c = n - 1; c >= 2 && nums[c - 2] != 0; c--) {
            int C = nums[c];
            int a = 0;
            int b = c - 1;
            while (a < b) {
                int B = nums[b];
                int A = nums[a];
                if (A + B > C) {
                    cnt += b - a;
                    b--;
                } else {
                    a++;
                }
            }
        }
        return cnt;
    }
}
