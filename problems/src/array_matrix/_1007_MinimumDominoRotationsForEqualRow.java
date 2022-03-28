package array_matrix;

//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

public class _1007_MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] topCnt = new int[7];
        int[] bottomCnt = new int[7];
        int[] colCnt = new int[7];
        int n = tops.length;
        for (int i = 0; i < n; i++) {
            int top = tops[i];
            int bottom = bottoms[i];
            topCnt[top]++;
            bottomCnt[bottom]++;
            if (top == bottom) {
                colCnt[top]++;
            } else {
                colCnt[top]++;
                colCnt[bottom]++;
            }
        }

        int max = 0;
        int maxCnt = 0;
        for (int i = 1; i < 7; i++) {
            if (colCnt[i] > maxCnt) {
                max = i;
                maxCnt = colCnt[i];
            }
        }

        if (maxCnt < n) {
            return -1;
        }

        int rotations = n - Math.max(topCnt[max], bottomCnt[max]);
        return rotations;
    }
}
