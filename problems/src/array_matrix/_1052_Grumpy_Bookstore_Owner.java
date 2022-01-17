package array_matrix;

// https://leetcode.com/problems/grumpy-bookstore-owner/

//[Sliding Window],[Prefix Sum]
public class _1052_Grumpy_Bookstore_Owner {

    public static int maxSatisfied(int[] customers, int[] grumpy, int m) {
        int n = customers.length;
        if (n == 1) {
            return customers[0];
        }

        int winSum = 0;
        winSum += customers[0];

        int[] prefixSum = new int[n];
        prefixSum[0] = grumpy[0] == 1 ? 0 : customers[0];
        for (int i = 1; i < n; i++) {
            if (grumpy[i] == 1) {
                prefixSum[i] = prefixSum[i - 1];
            } else {
                prefixSum[i] = prefixSum[i - 1] + customers[i];
            }

            if (i < m) {
                winSum += customers[i];
            }
        }

        int left = 0;
        int right = m - 1;
        int maxSum = 0;
        while (true) {
            int leftSum = left > 0 ? prefixSum[left - 1] : 0;
            int rightSum = prefixSum[n - 1] - prefixSum[right];
            int curSum = leftSum + winSum + rightSum;
            maxSum = Math.max(maxSum, curSum);

            winSum -= customers[left];
            left++;
            right++;
            if (right < n) {
                winSum += customers[right];
            } else {
                break;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int m1 = maxSatisfied(
                new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1},
                3);
        int m2 = maxSatisfied(
                new int[]{1},
                new int[]{0},
                1);
    }
}
