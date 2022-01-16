package math;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/smallest-integer-divisible-by-k/
//TOPICS:
//[Math],[Hash Map]
public class _1015_SmallestIntegerDivisibleByK {

    public static int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int r = 0;
        for (int N = 1; N <= k; N++){
            r = (10 * r + 1) % k;
            if (r == 0) return N;
        }
        return -1;
    }

    public static int smallestRepunitDivByKMap(int k) {
        int len = 0;
        int m = 0;
        Set<Integer> modulo = new HashSet<>();
        while (true) {
            m = (m * 10 + 1) % k;
            len++;
            if (m == 0) {
                return len;
            }
            if (modulo.contains(m)) {
                return -1;
            }
            modulo.add(m);
        }
    }

    public static void main(String[] args) {
        int l1 = smallestRepunitDivByK(1); // 1 [1]
        int l2 = smallestRepunitDivByK(2); // -1
        int l3 = smallestRepunitDivByK(3); // 3 [111]
        int l4 = smallestRepunitDivByK(5); // -1
        int l5 = smallestRepunitDivByK(17); // 16
    }


}
