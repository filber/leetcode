package array_matrix;

// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
// [Sliding Window]
public class _1343_NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        threshold *= k;
        int l = 0, r = 0;
        int winSum = 0;
        int cnt = 0;

        // Init first window
        while (r < k) {
            winSum += arr[r];
            r++;
        }
        if (winSum >= threshold) {
            cnt++;
        }

        while (r < arr.length) {
            winSum += arr[r];
            r++;
            winSum -= arr[l];
            l++;

            if (winSum >= threshold) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int n1 = numOfSubarrays(new int[]{1}, 1, 1); // 1
        int n2 = numOfSubarrays(new int[]{1}, 1, 2); // 0
        int n3 = numOfSubarrays(new int[]{1, 1, 1}, 3, 1); // 1
        int n4 = numOfSubarrays(new int[]{1, 1, 1}, 3, 2); // 0
        int n5 = numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4); // 3
        int n6 = numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5); // 6
    }
}
