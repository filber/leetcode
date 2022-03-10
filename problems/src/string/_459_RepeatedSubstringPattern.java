package string;

public class _459_RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int[] prefix = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && chars[j] != chars[i]) {
                j = prefix[j - 1];
            }
            if (chars[i] == chars[j]) {
                j++;
            }
            prefix[i] = j;
        }

        // n - prefix[n - 1] : length of cycle
        return prefix[n - 1] > 0 && n % (n - prefix[n - 1]) == 0;
    }
}
