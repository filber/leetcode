package dp;

//https://leetcode.com/problems/counting-bits/

public class _338_CountingBits {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i >> 1];
            } else {
                ans[i] = ans[(i - 1) >> 1] + 1;
            }
        }
        return ans;
    }

    public int[] countBitsDP(int n) {
        int[] ans = new int[n + 1];
        int base = 1;
        for (int i = 1; i <= n; i++) {
            if (i == base) {
                ans[i] = 1;
                base *= 2;
            } else {
                int diff = i - base / 2;
                ans[i] = 1 + ans[diff];
            }
        }

        return ans;
    }
}
