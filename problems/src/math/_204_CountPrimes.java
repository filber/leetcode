package math;

//https://leetcode.com/problems/count-primes/description/

import java.util.Arrays;

public class _204_CountPrimes {

    public int countPrimes(int n) {
        int[] mark = new int[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (mark[i]==0) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    mark[j*i] = 1;
                }
            }
        }
        return count;
    }
}
