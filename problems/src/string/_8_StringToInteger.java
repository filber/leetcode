package string;

// https://leetcode.com/problems/string-to-integer-atoi/

import java.util.Stack;

public class _8_StringToInteger {

    public static int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int i = 0;
        // 1. Read in and ignore any leading whitespace.
        while (i< s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check if the next character is '-' or '+'.
        char signal = '+';
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            signal = s.charAt(i);
            i++;
        }
        // omit leading zeros
        while (i< s.length() && s.charAt(i) == '0') {
            i++;
        }

        // 3. Read in next the characters until the next non-digit character or the end of the input is reached.
        Stack<Character> stack = new Stack<>();
        while (i< s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            stack.push(s.charAt(i));
            i++;
        }

        // 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
        // If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
        int base = 1;
        int cur = 0;
        int threshold = signal == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        boolean overflow = stack.size() > 10;
        while (!stack.isEmpty() && overflow == false) {
            int val = stack.pop()-'0';
            int change = val * base;
            if (base!=1 && change %10 != 0) {
                overflow = true;
                break;
            }
            if (signal == '+') {
                cur += change;
                if (cur < 0) {
                    overflow = true;
                    break;
                }
            } else {
                cur -= change;
                if (cur > 0) {
                    overflow = true;
                    break;
                }
            }
            base*= 10;
        }

        // 5. If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1],
        // then clamp the integer so that it remains in the range.
        if (overflow) {
            return threshold;
        }

        // 6. Return the integer as the final result.
        return cur;
    }


    public static void main(String[] args) {
        int v1 = myAtoi("42"); // 42
        int v2 = myAtoi("    -42"); // -42
        int v3 = myAtoi("4193 with words"); // 4193
        int v4 = myAtoi(" "); // 0
        int v11 = myAtoi("2147483646"); // 2147483646
        int v5 = myAtoi("2147483647"); // 2147483647
        int v6 = myAtoi("2147483648"); // 2147483647
        int v7 = myAtoi("-2147483648"); // -2147483648
        int v8 = myAtoi("-2147483647"); // -2147483647
        int v9 = myAtoi("-6147483648"); // -2147483648
        int v10 = myAtoi("5147483648"); // 2147483647
        int v12 = myAtoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"); // 2147483647
    }

}
