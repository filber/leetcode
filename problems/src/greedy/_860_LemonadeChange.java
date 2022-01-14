package greedy;
// https://leetcode.com/problems/lemonade-change/

public class _860_LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {
        int fiveCnt = 0;
        int tenCnt = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveCnt++;
            } else if (bill == 10) {
                if (fiveCnt == 0) {
                    return false;
                } else {
                    fiveCnt--;
                    tenCnt++;
                }
            } else {
                if (tenCnt == 0) {
                    if (fiveCnt < 3) {
                        return false;
                    } else {
                        fiveCnt -= 3;
                    }
                } else {
                  tenCnt -= 1;
                    if (fiveCnt == 0) {
                        return false;
                    } else {
                        fiveCnt -= 1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b1 = lemonadeChange(new int[]{5, 5, 5, 10, 20}); // true
        boolean b2 = lemonadeChange(new int[]{5, 5, 10}); // true
        boolean b3 = lemonadeChange(new int[]{10, 10}); // false
        boolean b4 = lemonadeChange(new int[]{5, 5, 10, 10, 20}); // false
    }
}
