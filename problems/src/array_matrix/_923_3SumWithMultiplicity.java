package array_matrix;

//https://leetcode.com/problems/3sum-with-multiplicity/

public class _923_3SumWithMultiplicity {

    long[][] count;
    int modulo = (int) 1e9 + 7;

    public int threeSumMulti(int[] arr, int target) {
        int[] bucket = new int[101];
        int n = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (bucket[num] == 0) {
                n++;
            }
            bucket[num]++;
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        count = new long[n][2];
        int idx = 0;
        for (int i = min; i <= max; i++) {
            if (bucket[i] != 0) {
                count[idx][0] = i;
                count[idx][1] = bucket[i];
                idx++;
            }
        }

        long ans = 0;

        for (int i = 0; i < count.length; i++) {
            long val = count[i][0];
            long cnt = count[i][1];
            // choose one VAL
            ans = (ans + (cnt * check(i + 1, count.length - 1, target - val)) % modulo) % modulo;

            // choose two VAL
            if (cnt >= 2) {
                int residue = (int) (target - 2 * val);
                if (residue > val && residue <= 100) {
                    long first = cnt * (cnt - 1) % modulo;
                    long second = (first / 2 * bucket[residue]) % modulo;
                    ans = (ans + second) % modulo;
                }
            }
            // choose three VAL
            if (cnt >= 3 && 3 * val == target) {
                long first = (cnt * (cnt - 1) / 2) % modulo;
                long second = (first * (cnt - 2) / 3) % modulo;
                ans = (ans + second) % modulo;
            }
        }

        return (int) ans;
    }

    private long check(int l, int r, long target) {
        if (l > r) {
            return 0;
        }
        long ans = 0;
        while (l < r) {
            long sum = count[l][0] + count[r][0];
            if (sum == target) {
                long cnt = (count[l][1] * count[r][1]) % modulo;
                ans = (ans + cnt) % modulo;
                l++;
                r--;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        if (count[l][1] >= 2 && 2 * count[l][0] == target) {
            long cnt = (count[l][1] * (count[l][1] - 1) / 2) % modulo;
            ans = (ans + cnt) % modulo;
        }
        return ans;
    }
}
