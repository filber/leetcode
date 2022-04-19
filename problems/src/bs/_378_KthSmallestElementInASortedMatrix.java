package bs;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

public class _378_KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        long l = matrix[0][0], r = matrix[n - 1][n - 1];
        while (l < r) {
            long mid = l + (r - l) / 2;
            int cnt = count(matrix, mid);
            if (cnt < k) {
                // mid UP
                l = mid + 1;
            } else {
                // mid DOWN
                r = mid;
            }
        }
        return (int) l;
    }

    // count of numbers in matrix that LE target
    public int count(int[][] matrix, long target) {
        int n = matrix.length;
        //  O(n+n), starting from bottom-left corner
        int x1 = 0, y1 = 0, x2 = n - 1, y2 = n - 1;
        int count = 0;
        while (x2 >= 0 && y1 < n) {
            if (target < matrix[x1][y1]) {
                break;
            } else if (target >= matrix[x2][y2]) {
                count += (x2 - x1 + 1) * (y2 - y1 + 1);
                break;
            } else {
                int val = matrix[x2][y1];
                if (val <= target) {
                    count += (x2 - x1 + 1);
                    y1++;
                } else {
                    x2--;
                }
            }
        }
        return count;
    }
}