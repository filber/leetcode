package greedy;

//https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/

public class _1775_EqualSumArraysWithMinimumNumberOfOperations {

    public int minOperations(int[] N, int[] M) {
        int maxN = 6 * N.length;
        int minN = N.length;
        int maxM = 6 * M.length;
        int minM = M.length;
        if (minM > maxN || minN > maxM) {
            return -1;
        }
        int[] nCnt = new int[8];
        int[] mCnt = new int[8];
        int nSum = 0;
        int mSum = 0;

        nCnt[0] = 6;
        nCnt[7] = 1;
        for (int val : N) {
            nSum += val;
            nCnt[val]++;
            nCnt[0] = Math.min(nCnt[0], val);
            nCnt[7] = Math.max(nCnt[7], val);
        }
        mCnt[0] = 6;
        mCnt[7] = 1;
        for (int val : M) {
            mSum += val;
            mCnt[val]++;
            mCnt[0] = Math.min(mCnt[0], val);
            mCnt[7] = Math.max(mCnt[7], val);
        }
        int changes = 0;
        while (nSum != mSum) {
            if (nSum > mSum) {
                int decrease = takeLargest(nCnt) - 1;
                int increase = 6 - takeSmallest(mCnt);
                if (nSum - mSum <= Math.max(decrease, increase)) {
                    mSum = nSum;
                } else {
                    if (decrease >= increase) {
                        reduce(nCnt, decrease + 1);
                        nSum -= decrease;
                    } else {
                        reduce(mCnt, 6 - increase);
                        mSum += increase;
                    }
                }

            } else {
                int decrease = takeLargest(mCnt) - 1;
                int increase = 6 - takeSmallest(nCnt);
                if (mSum - nSum <= Math.max(decrease, increase)) {
                    nSum = mSum;
                } else {
                    if (decrease >= increase) {
                        reduce(mCnt, decrease + 1);
                        mSum -= decrease;
                    } else {
                        reduce(nCnt, 6 - increase);
                        nSum += increase;
                    }
                }
            }
            changes++;
        }

        return changes;
    }

    private void reduce(int[] cnt, int val) {
        cnt[val]--;
    }

    private int takeLargest(int[] cnt) {
        for (int i = cnt[7]; i >= 1; i--) {
            if (cnt[i] != 0) {
                cnt[7] = i;
                return i;
            }
        }
        return 0;
    }

    private int takeSmallest(int[] cnt) {
        for (int i = cnt[0]; i <= 6; i++) {
            if (cnt[i] != 0) {
                cnt[0] = i;
                return i;
            }
        }
        return 0;
    }
}
