package ps;

public class _1422_MaximumScoreAfterSplittingAString {

    public int maxScore(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        char[] chars = s.toCharArray();

        int[] prefixCnt = new int[n];
        prefixCnt[0] = '1' - chars[0];
        for (int i = 1; i < n; i++) {
            prefixCnt[i] = prefixCnt[i - 1] + ('1' - chars[i]);
        }

        int[] suffixCnt = new int[n];
        suffixCnt[n - 1] = chars[n - 1] - '0';
        for (int i = n - 2; i >= 0; i--) {
            suffixCnt[i] = suffixCnt[i + 1] + (chars[i] - '0');
        }

        int rst = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            rst = Math.max(rst, prefixCnt[i] + suffixCnt[i + 1]);
        }
        return rst;
    }
}
