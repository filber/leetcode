package array_matrix;

//https://leetcode.com/problems/maximize-the-confusion-of-an-exam/

public class _2024_MaximizeTheConfusionOfAnExam {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        int n = chars.length;
        int l = 0, r = 0;
        int mCnt = 0;
        int tCnt = 0, fCnt = 0;
        while (r < n) {
            if (chars[r++] == 'T') {
                tCnt++;
            } else {
                fCnt++;
            }

            mCnt = Math.max(mCnt, Math.max(tCnt, fCnt));

            if (r - l > mCnt + k) {
                if (chars[l++] == 'T') {
                    tCnt--;
                } else {
                    fCnt--;
                }
            }
        }

        return Math.min(mCnt + k, n);
    }
}
