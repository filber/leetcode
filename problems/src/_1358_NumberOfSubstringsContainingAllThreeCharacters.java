
// TOPICS:
// [Sliding Window], [String]

// TIPS:
// Move winStart and winEnd separately
// Record&Refresh the window state
public class _1358_NumberOfSubstringsContainingAllThreeCharacters {

    public static int numberOfSubstrings(String s) {
        int len = s.length();
        int cnt = 0;
        int start = 0;
        int end = 2;
        int[] alphaCnt = new int[3];
        alphaCnt[s.charAt(0) - 'a'] ++;
        alphaCnt[s.charAt(1) - 'a']++;
        alphaCnt[s.charAt(2) - 'a']++;

        while (end < len && start < len - 2) {
            // satisfying
            if (alphaCnt[0] > 0 && alphaCnt[1] > 0 && alphaCnt[2] > 0) {
                cnt += len - end;

                alphaCnt[s.charAt(start) - 'a']--;
                start++;
                if (end - start < 2) {
                    end++;
                    if (end<len) {
                        // refresh cnt
                        alphaCnt[s.charAt(end) - 'a'] ++;
                    }
                }
            }
            // not satisfying
            else {
                end++;
                if (end<len) {
                    // refresh cnt
                    alphaCnt[s.charAt(end) - 'a'] ++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int c1 = numberOfSubstrings("aaa"); // 0
        int c2 = numberOfSubstrings("aab"); // 0
        int c3 = numberOfSubstrings("abc"); // 1
        int c4 = numberOfSubstrings("aaacb"); // 3
        int c5 = numberOfSubstrings("abcabc"); // 10
    }
}
