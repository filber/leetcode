package stack;

public class _739_DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] stack = new int[n];
        int top = -1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (top > -1 && temperatures[stack[top]] < temperatures[i]) {
                ans[stack[top]] = i - stack[top];
                top--;
            }
            stack[++top] = i;
        }
        return ans;
    }
}
