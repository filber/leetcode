package stack;

public class _1944_NumberOfVisiblePeopleInAQueue {

    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n];
        int top = -1;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && heights[i] > heights[stack[top]]) {
                ans[i]++;
                top--;
            }
            stack[++top] = i;
            if (top > 0) ans[i]++;
        }
        return ans;
    }
}
