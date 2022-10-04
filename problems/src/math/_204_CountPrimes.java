package math;

//https://leetcode.com/problems/count-primes/description/

import java.util.Arrays;

public class _204_CountPrimes {

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int[] p = new int[n];
        Arrays.fill(p, 1);
        p[0] = 0;
        p[1] = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (p[i] == 0) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                p[j] = 0;
            }
        }
        int ans = 0;
        for (int prime : p) {
            ans += prime;
        }
        return ans;
    }
}
