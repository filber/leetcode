package dp;

// https://leetcode.com/problems/palindromic-substrings/
public class _647_PalindromicSubstrings {

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int cnt = 0;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = len - 1 + i;
                if (j >= n) {
                    break;
                }
                if (len == 1) {
                    dp[i][i] = true;
                } else if (len == 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                  dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }
                if (dp[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int countSubstringsTP(String s) {
        int c=0;
        for(int i=0;i<s.length();i++) {
            //odd length
            c +=  checkPalin(i,i,s);
            //even length
            c += checkPalin(i,i+1,s);
        }
        return c;
    }
    public static int checkPalin(int i, int j, String s) {
        int c=0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;j++;c++;
        }

        return c;
    }
}
