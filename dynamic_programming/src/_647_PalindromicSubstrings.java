public class _647_PalindromicSubstrings {

//  public static int countSubstrings(String s) {
//    int[][] dp = new int[s.length()][s.length()];
//
//    int count = 0;
//    for (int i = s.length() - 1; i >= 0; i--) {
//      for (int j = i; j < s.length(); j++) {
//        if (i == j) {
//          dp[i][j] = 1;
//          count++;
//        } else if (s.charAt(i) == s.charAt(j)) {
//          if ((j - i) == 1) {
//            dp[i][j] = 1;
//            count++;
//          } else if (dp[i + 1][j - 1] == 1) {
//            dp[i][j] = 1;
//            count++;
//          }
//        }
//      }
//    }
//
//    return count;
//  }

  public static int countSubstrings(String s) {
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
      // System.out.println(s.substring(i+1,j));
    }

    return c;
  }

  public static void main(String[] args) {
    countSubstrings("xabax");
//    countSubstrings("abc");
//    countSubstrings("abccba");
//    countSubstrings("aaa");
  }
}
