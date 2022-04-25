package string;

//https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.Arrays;

public class _451_SortCharactersByFrequency {

    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        int[][] cnt = new int[128][2];
        for (char ch : chars) {
            cnt[ch][0] = ch;
            cnt[ch][1]++;
        }

        Arrays.sort(cnt, (a, b) -> b[1] - a[1]);

        int idx = 0;
        for (int i = 0; cnt[i][1] != 0; i++) {
            Arrays.fill(chars, idx, idx + cnt[i][1], (char) cnt[i][0]);
            idx += cnt[i][1];
        }
        return new String(chars);
    }
}
