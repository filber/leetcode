package math;

// https://leetcode.com/problems/calculate-money-in-leetcode-bank/
public class _1716_CalculateMoneyInLeetcodeBank {

    public static int totalMoney(int n) {
        int rowStartVal = (n - 1) / 7 + 1;
        int baseSum = 28;
        int preSum = baseSum * (rowStartVal - 1) + (rowStartVal - 1) * (rowStartVal - 2) * 7 / 2;

        int offset = (n - 1) % 7;
        int rowSum = (rowStartVal + rowStartVal + offset) * (offset + 1) / 2;
        int total = preSum + rowSum;

        return total;
    }

    public static int totalMoneyLoop(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            int base = (i - 1) / 7 + 1;
            int offset = (i - 1) % 7;
            total += base + offset;
        }

        return total;
    }

    public static void main(String[] args) {
        int m1 = totalMoney(4); // 10
        int m2 = totalMoney(10); // 37
        int m3 = totalMoney(20); // 96
        int m4 = totalMoney(175); // 2800
    }
}
