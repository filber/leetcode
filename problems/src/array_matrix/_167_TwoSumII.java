package array_matrix;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

public class _167_TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            int mid = l + (r - l) / 2;
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                if (numbers[l] + numbers[mid] > target) {
                    r = mid - 1;
                } else {
                    r--;
                }
            } else {
                if (numbers[mid] + numbers[r] < target) {
                    l = mid + 1;
                } else {
                    l++;
                }
            }
        }
        return null;
    }
}
