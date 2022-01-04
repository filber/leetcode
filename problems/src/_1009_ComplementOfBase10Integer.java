//https://leetcode.com/problems/complement-of-base-10-integer/

//[Bit Manipulation]
// Pay attention to constraints!
public class _1009_ComplementOfBase10Integer {
    public static int bitwiseComplement(int n) {
        if (n==0) {
            return 1;
        }

        int full = n;
        full = full>>1 | full;
        full = full>>2 | full;
        full = full>>4 | full;
        full = full>>8 | full;
        full = full>>16 | full;
        return full - n;
    }

    public static void main(String[] args) {
        int c1 = bitwiseComplement(5);
        int c2 = bitwiseComplement(7);
        int c3 = bitwiseComplement(10);
    }
}
