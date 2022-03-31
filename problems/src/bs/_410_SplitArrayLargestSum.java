package bs;

//https://leetcode.com/problems/split-array-largest-sum/

public class _410_SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int l = 0;
        int r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        if (m == 1) {
            return r;
        }

        while (l < r) {
            int cnt = 1;
            int mid = (l + r) >>> 1;
            int sum = 0;
            for (int num : nums) {
                if (sum + num > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += num;
            }
            if (cnt > m) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
