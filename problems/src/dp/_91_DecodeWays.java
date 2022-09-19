package dp;

//https://leetcode.com/problems/decode-ways/

public class _91_DecodeWays {

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        // dp[i]: number of decodings for s[0,i]
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            char pre = chars[i - 2];
            char cur = chars[i - 1];
            if (pre == '0') {
                if (cur == '0') {
                    // [100]
                    return 0;
                } else {
                    // [102] => [[10],2]
                    // [202] => [[20],2]
                    dp[i] = dp[i - 1];
                }
            } else if (pre == '1') {
                if (cur == '0') {
                    // [210] => [[2],10]
                    dp[i] = dp[i - 2];
                } else {
                    //[112] = [[11],2] + [[1],12]
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else if (pre == '2') {
                if (cur == '0') {
                    // [120] =>[[1],20]
                    dp[i] = dp[i - 2];
                } else if (cur >= '1' && cur <= '6') {
                    // [123] =>[[1],23] + [[12],3]
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    // [127] =>[[12],7]
                    dp[i] = dp[i - 1];
                }
            } else {
                if (cur=='0') {
                    return 0;
                } else {
                    // [134] =>[[13],4]
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[chars.length];
    }
}
