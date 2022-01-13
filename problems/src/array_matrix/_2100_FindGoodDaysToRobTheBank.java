package array_matrix;

// https://leetcode.com/problems/find-good-days-to-rob-the-bank/

import java.util.ArrayList;
import java.util.List;

public class _2100_FindGoodDaysToRobTheBank {

    public static List<Integer> goodDaysToRobBank(int[] s, int time) {
        int n = s.length;
        // fDP[i]: consecutive number of non-increasing numbers before i
        int[] fDP = new int[n];
        fDP[0] = 0;
        // bDP[i]: consecutive number of non-decreasing numbers after i
        int[] bDP = new int[n];
        bDP[n - 1] = 0;

        for (int i = 1; i < n; i++) {
            if (s[i - 1] >= s[i]) {
                fDP[i] = fDP[i - 1] + 1;
            } else {
                // s[i-1] < s[i]
                fDP[i] = 0;
            }

            int j = n - i - 1;
            if (s[j] <= s[j + 1]) {
                bDP[j] = bDP[j + 1] + 1;
            } else {
                bDP[j] = 0;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (fDP[i] >= time && bDP[i] >= time) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> l1 = goodDaysToRobBank(
                new int[]{5, 3, 3, 3, 5, 6, 2}, 2);
        List<Integer> l2 = goodDaysToRobBank(
                new int[]{1, 1, 1, 1, 1}, 0);
        List<Integer> l3 = goodDaysToRobBank(
                new int[]{1, 2, 3, 4, 5, 6}, 2);
    }
}
