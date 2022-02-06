package string;
// TOPICS:
// [Sliding Window], [String]

// TIPS:
// Move winStart and winEnd separately
// Record&Refresh the window state
public class _1358_NumberOfSubstringsContainingAllThreeCharacters {

    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int l = 0;
        int r = -1; // start from -1
        int[] cnt = new int[3];
        int ans = 0;

        while (r < n) {
            if (cnt[0] >= 1 && cnt[1] >= 1 && cnt[2] >= 1) {
                // satisfied
                int remain = n - 1 - r;
                ans += remain + 1;
                char lch = s.charAt(l);
                cnt[lch - 'a']--;
                l++;
            } else {
                r++;
                if (r < n) {
                    // not satisfied
                    char rch = s.charAt(r);
                    cnt[rch - 'a']++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int c1 = numberOfSubstrings("aaa"); // 0
        int c2 = numberOfSubstrings("aab"); // 0
        int c3 = numberOfSubstrings("abc"); // 1
        int c4 = numberOfSubstrings("aaacb"); // 3
        int c5 = numberOfSubstrings("abcabc"); // 10
    }
}
