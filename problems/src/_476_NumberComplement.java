
// TOPICS:
// [Bit Manipulation]

// TIPS:
// Moving the most left 1-flag to each right positions
// Or Using 1 as a mask and moving it to left repetitively.
public class _476_NumberComplement {

    public static int findComplementV2(int num) {
        int n = num;
        n |= n>>>1;
        n |= n>>>2;
        n |= n>>>4;
        n |= n>>>8;
        n |= n>>>16;
        return n ^ num;
    }

    public static int findComplement(int num) {
        int copy = num;
        int mask = 1;
        while (copy > 0) {
            num = num ^ mask;
            mask <<= 1;
            copy >>= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        int c1 = findComplement(5); // 2
        int c2 = findComplement(3); // 0
    }
}
