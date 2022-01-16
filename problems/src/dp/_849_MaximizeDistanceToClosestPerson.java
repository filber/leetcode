package dp;

// https://leetcode.com/problems/maximize-distance-to-closest-person/

public class _849_MaximizeDistanceToClosestPerson {

    public static int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] dp = new int[n];
        int maxLen = 0;
        int j = 0;
        int frontDis = 0;
        boolean firstSeatDetected = false;
        for (int i = 0; i < n; i++) {
            if (i==0) {
                dp[i] = seats[i] == 1 ? 0 : 1;
            } else if (seats[i]==1) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            if (dp[i] > maxLen) {
                j = i;
                maxLen = dp[i];
            }

            if (!firstSeatDetected) {
                if (seats[i]==0) {
                    frontDis ++;
                } else {
                    firstSeatDetected = true;
                }
            }
        }

        frontDis = Math.max(0, frontDis);
        int tailDis = Math.max(0, dp[n - 1]);
        if (j == n - 1 || j==maxLen-1) {
            // at start or at end
            return maxLen;
        } else {
            int middleDis = (maxLen + 1) / 2;
            int maxDis = Math.max(frontDis, Math.max(middleDis, tailDis));
            return maxDis;
        }
    }

    public static void main(String[] args) {
        int s1 = maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}); // 2
        int s2 = maxDistToClosest(new int[]{1, 0, 0, 0}); // 3
        int s3 = maxDistToClosest(new int[]{0, 1}); // 1
        int s4 = maxDistToClosest(new int[]{0,0,0,1,0,0,0,0}); // 4
        int s5 = maxDistToClosest(new int[]{1,0,0,0,1,0,0,0}); // 3
        int s6 = maxDistToClosest(new int[]{0,0,0,1,0,0,0,1}); // 3

    }
}
