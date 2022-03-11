package string;

//https://leetcode.com/problems/multiply-strings/

public class _43_MultiplyStrings {

    public String multiply(String num1, String num2) {
        char[] leftChars = num1.toCharArray();
        int m = leftChars.length;
        if (m == 1 && leftChars[0] == '0') {
            return "0";
        }
        char[] rightChars = num2.toCharArray();
        int n = rightChars.length;
        if (n == 1 && rightChars[0] == '0') {
            return "0";
        }

        int[] product = new int[m + n + 1];
        for (int i = m - 1; i >= 0; i--) {
            int left = leftChars[i] - '0';
            for (int j = n - 1; j >= 0; j--) {
                int right = rightChars[j] - '0';
                product[i + j + 2] += left * right;
            }
        }

        for (int i = product.length - 1; i > 0; i--) {
            product[i - 1] += product[i] / 10;
            product[i] %= 10;
        }

        int offset = 0;
        while (product[offset] == 0) {
            offset++;
        }
        char[] chars = new char[product.length - offset];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ('0' + product[i + offset]);
        }
        return new String(chars);
    }
}
