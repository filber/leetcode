package greedy;

//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

import java.util.Arrays;

public class _1647_MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            count[ch - 'a']++;
        }
        Arrays.sort(count);
        int deletions = 0;
        for (int i = 25; i > 0; i--) {
            if (count[i] == 0) {
                while (i > 0 && count[i - 1] != 0) {
                    deletions += count[i - 1];
                    count[i - 1] = 0;
                    i--;
                }
                break;
            } else {
                if (count[i - 1] == count[i]) {
                    count[i - 1]--;
                    deletions++;
                } else if (count[i - 1] > count[i]) {
                    deletions += count[i - 1] - count[i] + 1;
                    count[i - 1] = count[i] - 1;
                }
            }
        }
        return deletions;
    }
}
