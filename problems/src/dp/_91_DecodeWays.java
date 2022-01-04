package dp;

//https://leetcode.com/problems/decode-ways/
//[Dynamic Programming]
public class _91_DecodeWays {

    public static int numDecodings(String s) {
      if (s.charAt(0) == '0') {
        return 0;
      }

      int n = s.length();
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = 1;
      char pre = s.charAt(0);
      for (int i = 1; i < n; i++) {
        char ch = s.charAt(i);
        if (ch=='0') {
          if (pre == '1' || pre == '2') {
            dp[i + 1] = dp[i - 1];
          } else {
            return 0;
          }
        } else {
          if (pre == '1') {
            dp[i + 1] = dp[i - 1] + dp[i];
          } else if (pre == '2') {
            if (ch>='1'&&ch<='6') {
              dp[i + 1] = dp[i - 1] + dp[i];
            } else {
              dp[i + 1] = dp[i];
            }
          } else {
            dp[i+1] = dp[i];
          }
        }
        // set dp[i+1]
        pre = ch;
      }


      return dp[n];
    }

    public static void main(String[] args) {
        int n1 = numDecodings("06"); // 0
        int n2 = numDecodings("60"); // 0
        int n3 = numDecodings("226"); // 3
        int n4 = numDecodings("12"); // 2
        int n5 = numDecodings("11106"); // 2
        int n6 = numDecodings("1123"); // 5
    }


}
