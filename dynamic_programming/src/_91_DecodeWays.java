public class _91_DecodeWays {

  public int numDecodings(String s) {
    final int length = s.length();
    if (length == 0) {
      return 0;
    }
    if (s.charAt(0) == '0') {
      return 0;
    }

    int[] dp = new int[length + 1];
    dp[0] = 1;

    for (int i = 0; i < length; i++) {
      // match by single character, ways don't increase! remain dp[i]
      // 0 means we can't decode this way
      dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];
      // match by double character
      if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
        // ways increase by dp[i-1]
        dp[i + 1] += dp[i - 1];
      }
    }

    return dp[length];
  }

  public static void main(String[] args) {
    _91_DecodeWays instance = new _91_DecodeWays();
    int ways = instance.numDecodings("10");
    assert ways == 3;
  }


}
