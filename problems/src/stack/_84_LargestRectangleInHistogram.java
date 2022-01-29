package stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/

public class _84_LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length + 2;
        int[] h = new int[n];
        for (int i = 0; i < heights.length; i++) {
            h[i + 1] = heights[i];
        }

        int maxArea = 0;
        int[] stack = new int[n];
        int sIdx = -1;
        for (int i = 0; i < n; i++) {
            while (sIdx != -1 && h[stack[sIdx]] > h[i]) {
                int height = h[stack[sIdx--]];
                int width = i - 1 - stack[sIdx];
                maxArea = Math.max(maxArea, height*width);
            }
            stack[++sIdx] = i;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // 4 [2,4]/[4]
        int m2 = largestRectangleArea(new int[]{2, 4});
        // 10 [5,6]
        int m1 = largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }
}
