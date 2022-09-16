package greedy;

//https://leetcode.com/problems/maximum-swap/

public class _670_MaximumSwap {

    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        int n = chars.length;
        int[] suffix = new int[n];
        suffix[n-1] = n-1;
        for (int i = n - 2; i >= 0; i--) {
            if (chars[i] > chars[suffix[i + 1]]) {
                suffix[i] = i;
            } else {
                suffix[i] = suffix[i + 1];
            }
        }
        for (int i = 0; i < chars.length - 1; i++) {
            int j = suffix[i];
            if (chars[i] < chars[j]) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
