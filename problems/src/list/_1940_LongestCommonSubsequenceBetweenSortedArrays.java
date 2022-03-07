package list;

import java.util.ArrayList;
import java.util.List;

public class _1940_LongestCommonSubsequenceBetweenSortedArrays {
    // Constraints:
    // 2<=arr.length<=100
    // 1<=arr[i].length<=100
    // 1<=arr[i][j]<=100
    // arr[i] is in strict increasing order


    // Divide and conquer
    public List<Integer> longestCommonSubsequences(int[][] arr) {
        List<Integer> ans = longestCommonSubsequences(arr, 0, arr.length - 1);
        return ans;
    }

    public List<Integer> longestCommonSubsequences(int[][] arr, int i, int j) {
        List<Integer> ans = new ArrayList<>();
        if (i == j) {
            for (int val : arr[i]) {
                ans.add(val);
            }
            return ans;
        }

        int mid = (i + j) / 2;
        List<Integer> left = longestCommonSubsequences(arr, i, mid);
        List<Integer> right = longestCommonSubsequences(arr, mid + 1, j);
        int l = 0, r = 0;
        int m = left.size(), n = right.size();

        while (l < m && r < n) {
            while (l < m && left.get(l) < right.get(r)) {
                l++;
            }

            while (r < n && l < m && right.get(r) < left.get(l)) {
                r++;
            }

            if (l < m && r < n && left.get(l).equals(right.get(r))) {
                ans.add(left.get(l));
                l++;
                r++;
            }
        }

        return ans;
    }
}
