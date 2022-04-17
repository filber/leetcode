package string;

//https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.Arrays;

public class _451_SortCharactersByFrequency {

    public String frequencySort(String s) {
        int[][] frequency = new int[128][2];
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (char ch : chars) {
            frequency[ch][0] = ch;
            frequency[ch][1]++;
        }

        Arrays.sort(frequency, (a, b) -> b[1] - a[1]);

        int idx = 0;
        for (int i = 0; frequency[i][1] != 0; i++) {
            Arrays.fill(chars, idx, idx + frequency[i][1], (char) frequency[i][0]);
            idx += frequency[i][1];
        }

        return new String(chars);
    }
}
