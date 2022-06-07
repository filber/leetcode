package array_matrix;

//https://leetcode.com/problems/student-attendance-record-i/

public class _551_StudentAttendanceRecordI {
    // strictly less than 2 absent days.
    // no 3 consecutive late days
    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int absentCnt = 0;
        int consecutiveLate = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == 'A') {
                absentCnt++;
            }
            if (ch == 'L') {
                consecutiveLate++;
            } else {
                consecutiveLate = 0;
            }
            if (absentCnt == 2 || consecutiveLate == 3) {
                return false;
            }
        }

        return true;
    }
}
