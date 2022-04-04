package greedy;

//https://leetcode.com/problems/interval-list-intersections/

import java.util.Arrays;

public class _986_IntervalListIntersections {

    int[][] firstList;
    int[][] secondList;
    int l = 0;
    int r = 0;

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        this.firstList = firstList;
        this.secondList = secondList;
        int m = firstList.length, n = secondList.length;
        int[][] list = new int[m + n][2];
        int i = 0;
        while (l < m && r < n) {
            if (firstList[l][1] >= secondList[r][0] &&
                    secondList[r][1] >= firstList[l][0]) {
                int s = Math.max(firstList[l][0], secondList[r][0]);
                int e = Math.min(firstList[l][1], secondList[r][1]);
                list[i][0] = s;
                list[i][1] = e;
                i++;
            }

            int lE = firstList[l][1], rE = secondList[r][1];
            if (lE >= rE) {
                r++;
            }
            if (lE <= rE) {
                l++;
            }
        }

        return Arrays.copyOf(list, i);
    }
}
