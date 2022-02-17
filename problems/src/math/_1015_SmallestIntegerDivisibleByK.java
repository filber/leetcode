package math;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/smallest-integer-divisible-by-k/
//TOPICS:
//[Math]
public class _1015_SmallestIntegerDivisibleByK {

    public int smallestRepunitDivByK(int k) {
        int r = 0;
        for (int i = 1; i <= k; i++) {
            r = (10 * r + 1) % k;
            if (r == 0) {
                return i;
            }
        }

        return -1;
    }
}
