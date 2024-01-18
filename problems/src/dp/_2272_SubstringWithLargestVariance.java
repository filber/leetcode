package dp;

//https://leetcode.com/problems/substring-with-largest-variance/

import java.util.HashSet;
import java.util.Set;

public class _2272_SubstringWithLargestVariance {

    public int largestVariance(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }

        int ans = 0;
        int[] P = new int[n]; // max sum of subarray ending with i
        int[] Q = new int[n]; // max sum of subarray ending with i and contains at least one b
        for (char a: set) {
            for (char b: set) {
                if (a==b) {
                    continue;
                }
                char firstCh = chars[0];
                if (firstCh == a) {
                    P[0] = 1;
                    Q[0] = Integer.MIN_VALUE / 2; // Invalid
                } else if (firstCh == b) {
                    P[0] = -1;
                    Q[0] = -1;
                } else {
                    P[0] = 0;
                    Q[0] = Integer.MIN_VALUE / 2; // Invalid
                }

                for (int i = 1; i < n; i++) {
                    char ch = chars[i];
                    if (ch == a) {
                        P[i] = Math.max(P[i - 1] + 1, 1);
                        Q[i] = Q[i - 1] + 1;
                    } else if (ch == b) {
                        P[i] = Math.max(P[i - 1] - 1, -1);
                        Q[i] = P[i];
                    } else {
                        P[i] = Math.max(P[i - 1], 0);
                        Q[i] = Q[i - 1];
                    }
                    ans = Math.max(ans, Q[i]);
                }
            }
        }

        return ans;
    }
}
