package dfs;

//https://leetcode.com/problems/restore-ip-addresses/

import java.util.ArrayList;
import java.util.List;

public class _93_RestoreIPAddresses {

    List<String> ans = new ArrayList<>();
    char[] A;
    int[] B = new int[4];

    public List<String> restoreIpAddresses(String s) {
        A = s.toCharArray();
        backtracking(0, 0);
        return ans;
    }

    private void backtracking(int i, int j) {
        if (i == A.length) {
            if (j == B.length) {
                StringBuilder sb = new StringBuilder();
                for (int seg : B) {
                    sb.append(seg);
                    sb.append('.');
                }
                ans.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }
        int val = A[i] - '0';
        if (j > 0 && B[j - 1] > 0 && (10 * B[j - 1] + val) <= 255) {
            B[j - 1] = 10 * B[j - 1] + val;
            backtracking(i + 1, j);
            B[j - 1] = (B[j - 1] - val) / 10;
        }
        if (j < B.length) {
            B[j] = val;
            backtracking(i + 1, j + 1);
        }
    }
}
