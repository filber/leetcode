package greedy;

//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

import java.util.Arrays;

public class _1647_MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        for (char ch : chars) {
            cnt[ch - 'a']++;
        }
        Arrays.sort(cnt);

        int result = 0;
        for (int i = 24; i >= 0 && cnt[i] > 0; i--) {
            if (cnt[i + 1] == 0) {
                result += cnt[i];
                cnt[i] = 0;
            } else if (cnt[i] >= cnt[i + 1]) {
                result += (cnt[i] - cnt[i + 1] + 1);
                cnt[i] = cnt[i + 1] - 1;
            }
        }
        return result;
    }
}
