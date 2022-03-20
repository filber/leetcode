package array_matrix;

public class _1007_MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int[] colCnt = new int[7];
        int[] topCnt = new int[7];
        int[] bottomCnt = new int[7];
        for (int i = 0; i < n; i++) {
            int top = tops[i];
            int bottom = bottoms[i];
            topCnt[top]++;
            bottomCnt[bottom]++;
            colCnt[top]++;
            if (top != bottom) {
                colCnt[bottom]++;
            }
        }

        int minRotations = Integer.MAX_VALUE;
        for (int i = 1; i < 7; i++) {
            if (colCnt[i] >= n) {
                int topRotations = n - topCnt[i];
                int bottomRotations = n - bottomCnt[i];
                minRotations = Math.min(minRotations, Math.min(topRotations, bottomRotations));
            }
        }

        return minRotations == Integer.MAX_VALUE ? -1 : minRotations;
    }
}
