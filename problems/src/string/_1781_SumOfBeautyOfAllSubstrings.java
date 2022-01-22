package string;

import java.util.Arrays;

// https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

//[String],[Prefix Sum]
public class _1781_SumOfBeautyOfAllSubstrings {

    public static int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            int[] c = new int[26];
            for (int j = i; j < s.length(); ++j) {
                c[s.charAt(j) - 'a']++;
                res += diff(c);
            }
        }
        return res;
    }

    private static int diff(int[] c) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int c1 : c) {
            max = Math.max(max, c1);
            if (c1 > 0)
                min = Math.min(min, c1);
        }
        return max - min;
    }

    public static int beautySumDP(String s) {
        int n = s.length();
        int[][] prefixSum = new int[26][n + 1];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            for (int j = 0; j < 26; j++) {
                if (j == ch - 'a') {
                    prefixSum[j][i + 1] = prefixSum[j][i] + 1;
                } else {
                    prefixSum[j][i + 1] = prefixSum[j][i];
                }
            }
        }


        Arrays.sort(prefixSum, (a, b) -> Integer.compare(b[n], a[n]));
        int charSize = 0;
        while (charSize < 26 && prefixSum[charSize][n] != 0) {
            charSize ++;
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < charSize; k++) {
                    int cnt = prefixSum[k][j] - prefixSum[k][i-1];
                    if (cnt!=0) {
                        min = Math.min(min,cnt);
                        max = Math.max(max,cnt);
                    }
                }
                sum += max - min;
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        int s1 = beautySum("aabcb"); // 5
        int s2 = beautySum("aabcbaa"); // 17
        int s3 = beautySum("aabzzcbzzzz"); // 91
    }
}
