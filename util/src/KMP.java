import java.util.ArrayList;
import java.util.List;

public class KMP {

    private static int[] buildPrefix(char[] pattern) {
        int len = 0;
        int[] prefix = new int[pattern.length];
        for (int i = 1; i < pattern.length; i++) {
            while (len > 0 && pattern[i] != pattern[len]) {
                len = prefix[len - 1]; // go back until len=0 or P[i]=P[len]
            }
            if (pattern[i] == pattern[len]) {
                len++;
            }
            prefix[i] = len;
        }

        return prefix;
    }

    private static List<Integer> searchKMP(String txt, String pattern) {
        char[] tChars = txt.toCharArray();
        int m = tChars.length;
        char[] pChars = pattern.toCharArray();
        int n = pChars.length;
        List<Integer> ans = new ArrayList<>();

        int[] prefix = buildPrefix(pChars);

        int i = 0, j = 0;
        while (i < m) {
            if (tChars[i] == pChars[j]) {
                i++;
                j++;
                if (j == n) {
                    ans.add(i - n);
                    //already moved i, j goes back to the prefix[n-1]
                    j = prefix[j - 1];
                }
            } else {
                if (j == 0) {
                    // j go back to the start, still can't match, move i to right
                    i++;
                } else {
                    // j go back to the next position just after
                    // the longest common prefix&suffix str
                    // exp: ab[c]xyzab[f],   [f]-->[c]
                    j = prefix[j - 1];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        String txt = "ababababfababababf";
//        String pattern = "ababf";
        String txt = "ababababa";
        String pattern = "abab";
        List<Integer> positions = searchKMP(txt, pattern);
        for (int pos : positions) {
            System.out.println(pos);
        }
    }
}
