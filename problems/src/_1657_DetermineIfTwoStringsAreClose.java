import java.util.Arrays;

public class _1657_DetermineIfTwoStringsAreClose {
  public static boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }
    int[] frequency1 = new int[26];
    int[] frequency2 = new int[26];
    byte[] bytes1 = word1.getBytes();
    byte[] bytes2 = word2.getBytes();

    byte base = 'a';
    for (int i = 0; i < word1.length(); i++) {
      frequency1[bytes1[i] - base]++;
      frequency2[bytes2[i] - base]++;
    }

    for (int i = 0; i < frequency1.length; i++) {
      if (frequency1[i]==0 && frequency2[i]!=0 ||
          frequency2[i]==0 && frequency1[i]!=0) {
        return false;
      }
    }

    Arrays.sort(frequency1);
    Arrays.sort(frequency2);
    for (int i = 0; i < frequency1.length; i++) {
      if (frequency1[i] != frequency2[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    Input: word1 = "abc", word2 = "bca"
//    Output: true
    closeStrings("abc","bca");

//    Input: word1 = "a", word2 = "aa"
//    Output: false
    closeStrings("a","aa");

//    Input: word1 = "cabbba", word2 = "abbccc"
//    Output: true
    closeStrings("cabbba","abbccc");

//    Input: word1 = "cabbba", word2 = "aabbss"
//    Output: false
    closeStrings("cabbba","aabbss");
  }
}
