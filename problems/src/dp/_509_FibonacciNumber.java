package dp;

//https://leetcode.com/problems/fibonacci-number/

public class _509_FibonacciNumber {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int pre = 0;
        int cur = 1;
        for (int i = 1; i < n; i++) {
            int next = pre + cur;
            pre = cur;
            cur = next;
        }
        return cur;
    }
}
