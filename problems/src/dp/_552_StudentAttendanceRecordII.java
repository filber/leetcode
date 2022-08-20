package dp;

//https://leetcode.com/problems/student-attendance-record-ii/

public class _552_StudentAttendanceRecordII {

    private static final int modulo = (int) (1e9 + 7);

    public int checkRecord(int n) {
        if (n == 1) {
            return 3;
        }


        long[] P = new long[n];
        long[] L = new long[n];
        long[] LL = new long[n];
        long[] A = new long[n];
        long[] wP = new long[n];
        long[] wL = new long[n];
        long[] wLL = new long[n];

        // Initialize
        A[0] = 1;
        P[0] = 1;
        L[0] = 1;
        LL[0] = 0;
        wP[0] = 0;
        wL[0] = 0;
        wLL[0] = 0;
        for (int i = 1; i < n; i++) {
            P[i] = (P[i - 1] + L[i - 1] + LL[i - 1]) % modulo;
            L[i] = P[i - 1];
            LL[i] = L[i - 1];
            A[i] = P[i];
            wP[i] = (A[i - 1] + wP[i - 1] + wL[i - 1] + wLL[i - 1]) % modulo;
            wL[i] = (A[i - 1] + wP[i - 1]) % modulo;
            wLL[i] = wL[i - 1];
        }
        int ans = (int) ((P[n - 1] + L[n - 1] + LL[n - 1] + A[n - 1] + wP[n - 1] + wL[n - 1] + wLL[n - 1]) % modulo);
        return ans;
    }
}
