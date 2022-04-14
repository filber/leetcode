package math;

// https://leetcode.com/problems/number-complement/

public class _476_NumberComplement {

    public int findComplement(int num) {
        int tmp = num;
        tmp = tmp | (tmp >> 1);
        tmp = tmp | (tmp >> 2);
        tmp = tmp | (tmp >> 4);
        tmp = tmp | (tmp >> 8);
        tmp = tmp | (tmp >> 16);
        return tmp ^ num;
    }
}
