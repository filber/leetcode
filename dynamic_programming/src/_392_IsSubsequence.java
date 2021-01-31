public class _392_IsSubsequence {

  public static boolean isSubsequence(String pat, String txt) {
    if (pat.isEmpty()) {
      return true;
    }
    if (txt.isEmpty()) {
      return false;
    }

    int patIndex = 0;
    int txtIndex = 0;
    byte[] patBytes = pat.getBytes();
    byte[] txtBytes = txt.getBytes();
    while (patIndex < pat.length() && txtIndex < txt.length()) {
      if (patBytes[patIndex] == txtBytes[txtIndex]) {
        patIndex++;
      }
      txtIndex++;
    }

    if (patIndex == pat.length()) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {

    isSubsequence("ace", "abcde");
    isSubsequence("aec", "abcde");

//    Input: s = "abc", t = "ahbgdc"
//    Output: true
    isSubsequence("abc", "ahbgdc");
//    Input: s = "axc", t = "ahbgdc"
//    Output: false
    isSubsequence("axc", "ahbgdc");
  }
}
