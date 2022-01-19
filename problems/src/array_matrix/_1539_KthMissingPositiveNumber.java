package array_matrix;

// https://leetcode.com/problems/kth-missing-positive-number/

public class _1539_KthMissingPositiveNumber {
    //    Constraints:
//    1 <= arr.length <= 1000
//    1 <= arr[i] <= 1000
//    1 <= k <= 1000
//    arr[i] < arr[j] for 1 <= i < j <= arr.length
    public static int findKthPositive(int[] arr, int k) {
        int expected = 1;
        int m = 0;
        int i = 0;
        while (i < arr.length) {
            if (expected < arr[i]) {
                m++;
                if (m == k) {
                    return expected;
                }
                expected++;
            } else {
                // expected == arr[i]
                expected++;
                i++;
            }
        }

        return expected + k - m - 1;
    }

    public static void main(String[] args) {
        // [1,5,6,8,9,10,12,13,...]
        int p1 = findKthPositive(new int[]{2, 3, 4, 7, 11}, 5); // 9
        // [5,6,7,...]
        int p2 = findKthPositive(new int[]{1, 2, 3, 4}, 2); // 6
    }
}
