package stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/

public class _84_LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length + 2;
        int[] h = new int[n];
        for (int i = 0; i < heights.length; i++) {
            h[i + 1] = heights[i];
        }

        int maxArea = 0;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top != -1 && h[stack[top]] > h[i]) {
                int height = h[stack[top--]];
                int width = i - 1 - stack[top];
                maxArea = Math.max(maxArea, height * width);
            }
            stack[++top] = i;
        }

        return maxArea;
    }

}
