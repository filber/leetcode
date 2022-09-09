package sw;

public class _EX_LongestKInterspaceSubstring {

    public String longest(String word, int k) {
        char[] chars = word.toCharArray();
        int l = 0;
        char lCh = chars[l];
        int maxLen = 0;
        int startIdx = 0;
        for (int r = 0; r < chars.length; r++) {
            if (Math.abs(chars[r] - lCh) > k) {
                l = r;
            }
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                startIdx = l;
            }
            lCh = chars[r];
        }
        return word.substring(startIdx, startIdx + maxLen);
    }
}
