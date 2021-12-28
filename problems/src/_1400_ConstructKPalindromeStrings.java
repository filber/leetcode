public class _1400_ConstructKPalindromeStrings {

  public static boolean canConstruct(String s, int k) {
    if (s.length() < k) {
      return false;
    }

    int[] charCount = new int[26];
    for (byte ch : s.getBytes()) {
      charCount[ch - 'a']++;
    }

    int oddCount = 0;
    for (int i = 0; i < charCount.length; i++) {
      if (charCount[i] % 2 == 1) {
        oddCount++;
      }
    }

    if (oddCount > k) {
      return false;
    } else {
      return true;
    }
  }

  public static void main(String[] args) {
    boolean example1 = canConstruct("annabelle", 2);
    boolean example2 = canConstruct("leetcode", 3);
    boolean example3 = canConstruct("true", 4);
    boolean example4 = canConstruct("yzyzyzyzyzyzyzy", 2);
    boolean example5 = canConstruct("cr", 7);

  }
}
