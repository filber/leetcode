import java.util.HashSet;
import java.util.Set;

public class _91_DecodeWays {

  public static int numDecodings(String s) {
    Set<String> set = new HashSet<>();
    for (int i = 1; i <= 26; i++) {
      set.add(String.valueOf(i));
    }

    // initialize DP
    int[] dp = new int[s.length()];
    String self = s.substring(0, 1);
    if (set.contains(self)) {
      dp[0] = 1;
    } else {
      return 0;
    }

    if (s.length()<2) {
      return dp[0];
    }

    self = s.substring(1, 2);
    String pre = s.substring(0, 2);
    if (set.contains(self) && set.contains(pre)) {
      dp[1] = 2;
    } else if (set.contains(self)) {
      dp[1] = 1;
    } else if (set.contains(pre)) {
      dp[1] = 1;
    } else {
      dp[1] = 0;
    }

    for (int i = 2; i < dp.length; i++) {
      self = s.substring(i, i + 1);
      pre = s.substring(i - 1, i + 1);
      int ways = 0;
      if (set.contains(self) && set.contains(pre)) {
        ways = dp[i - 1] + dp[i - 2];
      } else if (set.contains(self)) {
        ways = dp[i-1];
      } else if (set.contains(pre)) {
        ways = dp[i-2];
      } else {
        return 0;
      }
      dp[i] = ways;
    }

    return dp[dp.length - 1];
  }

  public static void main(String[] args) {

    // 0
    System.out.println(numDecodings("06"));

    // 0
    System.out.println(numDecodings("0"));

    // 3
    System.out.println(numDecodings("226"));

    // 2
    System.out.println(numDecodings("12"));

    // 2
    System.out.println(numDecodings("11106"));
  }


}
