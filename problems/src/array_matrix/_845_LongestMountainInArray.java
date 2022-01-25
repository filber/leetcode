package array_matrix;

// https://leetcode.com/problems/longest-mountain-in-array/

public class _845_LongestMountainInArray {

    public static int longestMountain(int[] N) {
        int n = N.length;
        if (n < 3) {
            return 0;
        }

        // 0:TryUpHill, 1:UpHill, 2:DownHill
        int status = 0;
        int curLen = 0;
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            // TryUpHill
            if (status == 0) {
                if (N[i - 1] < N[i]) {
                    status = 1; // change to UpHill
                    curLen = 2;
                }
            }
            // UpHill
            else if (status == 1) {
                if (N[i - 1] < N[i]) {
                    curLen++;
                } else if (N[i - 1] == N[i]) {
                    curLen = 0;
                    status = 0;  // change to TryUpHill
                } else {
                    curLen++;
                    status = 2;  // change to DownHill
                    maxLen = Math.max(maxLen, curLen);
                }
            }
            // DownHill
            else {
                if (N[i - 1] < N[i]) {
                    status = 1; // change to UpHill
                    curLen = 2;
                } else if (N[i - 1] == N[i]) {
                    curLen = 0;
                    status = 0;
                } else {
                    curLen++;
                    maxLen = Math.max(maxLen, curLen);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int l1 = longestMountain(new int[]{2, 2, 2});
        // 5
        int l2 = longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5});
        // 4
        int l3 = longestMountain(new int[]{1, 4, 4, 5, 3, 2});
        // 4
        int l4 = longestMountain(new int[]{1, 4, 3, 2, 5, 2});
        // 4
        int l5 = longestMountain(new int[]{1, 4, 3, 2, 3, 4, 5});
        // 8
        int l6 = longestMountain(new int[]{1, 4, 3, 2, 3, 4, 5, 4, 3, 2, 1});
    }
}
