package math;
// https://leetcode.com/problems/add-digits/

public class _258_AddDigits {

    public static int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }

        return num;
    }

    public static void main(String[] args) {
        int n1 = addDigits(38);
        int n2 = addDigits(0);
    }
}
