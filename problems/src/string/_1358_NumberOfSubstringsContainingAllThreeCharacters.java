package string;

//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

public class _1358_NumberOfSubstringsContainingAllThreeCharacters {

    public static int numberOfSubstrings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0, r = 0;
        int res = 0;
        int[] cnt = new int[3];
        cnt[chars[0] - 'a']++;
        while (r < n) {
            if (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                res += n - r;
                cnt[chars[l] - 'a']--;
                l++;
            } else {
                r++;
                if (r < n) {
                    cnt[chars[r] - 'a']++;
                }
            }
        }

        return res;
    }
}
