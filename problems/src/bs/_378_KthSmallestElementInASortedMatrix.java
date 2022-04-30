package bs;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

public class _378_KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        long l = matrix[0][0], r = matrix[n - 1][n - 1];
        while (l < r) {
            long mid = l + (r - l) / 2;
            int count = count(matrix, mid);
            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    public int count(int[][] matrix, long target) {
        int count = 0;
        int n = matrix.length;
        int i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= target) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}