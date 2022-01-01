//TOPICS:
//[String],[Prefix Sum]
public class _1781_SumOfBeautyOfAllSubstrings {
    public static int beautySum(String s) {
        int[][] prefixSum = new int[s.length() + 1][26];
        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 0; j < 26; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j];
            }
            char ch = s.charAt(i - 1);
            prefixSum[i][ch - 'a']++;
        }

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < 26; k++) {
                    int alpCnt = prefixSum[j][k] - prefixSum[i][k];
                    if (alpCnt != 0) {
                        min = Math.min(min, alpCnt);
                        max = Math.max(max, alpCnt);
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
    }
}
