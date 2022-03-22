package greedy;

import java.util.Arrays;

public class _1663_SmallestStringWithAGivenNumericValue {

    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        Arrays.fill(ans, 0, n, 'a');

        int cur = n - 1;
        while (n > 0) {
            if (n == k) {
                break; // remain leading 'a'
            } else {
                int m = k + 1 - n;
                if (m > 26) {
                    int zCnt = m / 26;
                    // fill trailing 'z'
                    Arrays.fill(ans, cur + 1 - zCnt, cur + 1, 'z');
                    n -= zCnt;
                    k -= zCnt * 26;
                    cur -= zCnt;
                } else {
                    // m<=26
                    ans[cur] += m - 1;
                    cur--;
                    n--;
                    k -= m;
                }
            }
        }

        return new String(ans);
    }
}
