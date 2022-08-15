package string;

//https://leetcode.com/problems/roman-to-integer/

public class _13_RomanToInteger {

    char[] chars;
    int[] VAL;
    public int romanToInt(String s) {
        VAL = new int[26];
        VAL['I' - 'A'] = 1;
        VAL['V' - 'A'] = 5;
        VAL['X' - 'A'] = 10;
        VAL['L' - 'A'] = 50;
        VAL['C' - 'A'] = 100;
        VAL['D' - 'A'] = 500;
        VAL['M' - 'A'] = 1000;

        chars = s.toCharArray();
        int sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            sum += helper(i);
        }
        return sum;
    }

    private int helper(int i) {
        char ch = chars[i];
        int val = VAL[ch - 'A'];
        if (i < chars.length - 1) {
            if ((ch == 'I' && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) ||
                    (ch == 'X' && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) ||
                    (ch == 'C' && (chars[i + 1] == 'D' || chars[i + 1] == 'M'))) {
                return -val;
            }
        }
        return val;
    }
}
