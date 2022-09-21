package bs;

//https://leetcode.com/problems/split-array-largest-sum/

public class _410_SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
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
        int tmpSum = 0;
        for (int num : nums) {
            if (tmpSum + num < sum) {
                tmpSum += num;
            } else if (tmpSum + num == sum) {
                cnt++;
                tmpSum = 0;
            } else {
                cnt++;
                tmpSum = num;
            }
        }
        if (tmpSum > 0) {
            cnt++;
        }
        return cnt;
    }
}
