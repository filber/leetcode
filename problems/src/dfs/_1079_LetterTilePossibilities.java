package dfs;
// https://leetcode.com/problems/letter-tile-possibilities/

import java.util.*;

public class _1079_LetterTilePossibilities {

    private int[] charCnt;
    int remain;
    int cnt = 0;
    private Character[] letters;

    public int numTilePossibilities(String tiles) {
        charCnt = new int[26];
        char[] chars = tiles.toCharArray();
        remain = chars.length;

        Set<Character> set = new HashSet<>();
        for (char ch : chars) {
            charCnt[ch - 'A']++;
            set.add(ch);
        }
        letters = set.toArray(new Character[0]);

        backtracking();
        return cnt;
    }

    private void backtracking() {
        if (remain == 0) {
            return; // no available letter tiles
        }

        for (char ch : letters) {
            int j = ch - 'A';
            if (charCnt[j] != 0) {
                cnt++;

                // set states
                remain--;
                charCnt[j]--;
                backtracking();

                // reverse states
                remain++;
                charCnt[j]++;
            }
        }
    }
}
