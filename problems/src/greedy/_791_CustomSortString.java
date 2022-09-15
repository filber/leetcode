package greedy;

//https://leetcode.com/problems/custom-sort-string/

import java.util.Arrays;
import java.util.Comparator;

public class _791_CustomSortString {

    public String customSortString(String order, String s) {
        int[][] charCnt = new int[26][3];
        for (int i = 0; i < charCnt.length; i++) {
            charCnt[i][2] = i;
        }
        int rank = 26;
        for (char ch : order.toCharArray()) {
            charCnt[ch - 'a'][0] = rank--;
        }
        for (char ch : s.toCharArray()) {
            charCnt[ch - 'a'][1]++;
        }

        Arrays.sort(charCnt, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return b[0] - a[0];
            }
        });
        char[] rst = new char[s.length()];
        int i = 0;
        int j = 0;
        while (j < rst.length) {
            int cnt = charCnt[i][1];
            char ch = (char) ('a' + charCnt[i][2]);
            Arrays.fill(rst, j, j + cnt, ch);
            j += cnt;
            i++;
        }
        return new String(rst);
    }
}
