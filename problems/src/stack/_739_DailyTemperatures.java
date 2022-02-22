package stack;

public class _739_DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] waits = new int[n];
        int[] stack = new int[n];
        int top = 0;
        stack[top] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            int temp = temperatures[i];
            while (top != -1 && temperatures[stack[top]] <= temp) {
                top--;
            }
            if (top != -1) {
                waits[i] = stack[top] - i;
            }
            stack[++top] = i;
        }

        return waits;
    }
}
