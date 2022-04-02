package bs;

//https://leetcode.com/problems/split-array-largest-sum/

public class _410_SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int l = max, r = sum;
        if (m == 1) {
            return sum;
        }
        while (l < r) {
            int mid = (l + r) / 2;
            int cnt = count(nums, mid);
            if (cnt <= m) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int count(int[] nums, int sum) {
        int cnt = 0;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (s + nums[i] > sum) {
                s = 0;
                cnt++;
            }
            s += nums[i];
        }
        return cnt + 1;
    }
}
