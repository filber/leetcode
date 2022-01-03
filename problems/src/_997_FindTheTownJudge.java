// https://leetcode.com/problems/find-the-town-judge/
public class _997_FindTheTownJudge {

    public static int findJudge(int n, int[][] trust) {
        if (trust == null || trust.length == 0) {
            if (n == 1) {
                return 1;
            } else {
                return -1;
            }
        }

        int[] trustedIn = new int[n + 1];
        int[] trustedOut = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            int out = trust[i][0];
            int in = trust[i][1];
            trustedIn[in]++;
            trustedOut[out]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustedIn[i] == n-1 && trustedOut[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int j1 = findJudge(2, new int[][]{{1, 2}});
        int j2 = findJudge(3, new int[][]{{1, 3}, {2, 3}});
        int j3 = findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}});
    }
}
