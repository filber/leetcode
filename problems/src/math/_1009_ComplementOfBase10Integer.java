package math;

//https://leetcode.com/problems/complement-of-base-10-integer/

// Pay attention to constraints!
public class _1009_ComplementOfBase10Integer {
    public static int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        int mask = n;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;
        int res = mask ^ n;
        return res;
    }
}
