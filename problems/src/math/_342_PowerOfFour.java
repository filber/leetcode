package math;

//https://leetcode.com/problems/power-of-four/

public class _342_PowerOfFour {

    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        int lowestBit = n & (-n);
        if ((lowestBit | n) != lowestBit) {
            return false;
        }
        lowestBit -= 1;
        int oneCnt = 0;
        while (lowestBit != 0) {
            lowestBit >>= 1;
            oneCnt += 1;
        }
        return oneCnt % 2 == 0;
    }
}
