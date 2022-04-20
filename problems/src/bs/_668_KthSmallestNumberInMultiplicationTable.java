package bs;

//https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/

public class _668_KthSmallestNumberInMultiplicationTable {

    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = count(m, n, mid);
            if (cnt < k) {
                // mid UP
                l = mid + 1;
            } else {
                // mid DOWN
                r = mid;
            }
        }
        return l;
    }

    private int count(int m, int n, int target) {
        int i = m, j = 1;
        int count = 0;
        while (i >= 1 && j <= n) {
            int val = i * j;
            if (val <= target) {
                count += i;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
