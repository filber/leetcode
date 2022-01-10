package string;

//https://leetcode.com/problems/is-subsequence/
public class _392_IsSubsequence {

  public static boolean isSubsequence(String pat, String txt) {
    int left = 0, right = 0;
    while (left < pat.length() && right < txt.length()) {
      char ch = pat.charAt(left);
      if (txt.charAt(right) == ch) {
        left++;
      }
      right++;
    }
    if (left==pat.length()) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    boolean b1 = isSubsequence("ace", "abcde"); // true
    boolean b2 = isSubsequence("aec", "abcde"); // false
    boolean b3 = isSubsequence("abc", "ahbgdc"); // true
    boolean b4 = isSubsequence("axc", "ahbgdc"); // false
  }
}
