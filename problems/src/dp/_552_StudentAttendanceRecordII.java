package dp;

//https://leetcode.com/problems/student-attendance-record-ii/

public class _552_StudentAttendanceRecordII {

    private static final int modulo = (int) (1e9 + 7);

    public int checkRecord(int n) {
        // without A
        int p = 1;
        int l = 1;
        int ll = 0;

        // with A
        int ap = 0;
        int al = 0;
        int all = 0;

        // ending with A
        int a = 1;

        for (int i = 2; i <= n; i++) {
            int tmpAP = ap;
            ap = add(ap, add(al, add(all, a)));
            all = al;
            al = add(tmpAP, a);

            a = add(p, add(l, ll));

            int tmpP = p;
            p = add(l, add(p, ll));
            int tmpL = l;
            l = tmpP;
            ll = tmpL;
        }

        return add(p, add(l, add(ll, add(ap, add(al, add(all, a))))));
    }

    int add(int a, int b) {
        return (a + b) % modulo;
    }
}
