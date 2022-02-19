package greedy;

import java.util.Arrays;

public class _870_AdvantageShuffle {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] N2 = new int[n][2];
        for (int i = 0; i < n; i++) {
            N2[i][0] = i;
            N2[i][1] = nums2[i];
        }

        Arrays.sort(nums1);
        Arrays.sort(N2,(a,b)->a[1]-b[1]);

        int[] res = new int[n];
        int l = 0;
        int r = n-1;
        for (int num : nums1) {
            if (num <= N2[l][1]) {
                res[N2[r][0]] = num;
                r--;
            } else {
                res[N2[l][0]] = num;
                l++;
            }
        }
        return res;
    }
}
