package array_matrix;

// https://leetcode.com/problems/find-the-duplicate-number/

public class _287_FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }

    public static void main(String[] args) {

        int d1 = findDuplicate(new int[]{1, 3, 4, 2, 2});
        int d2 = findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1});
        int d3 = findDuplicate(new int[]{3, 1, 3, 4, 2});
    }
}
