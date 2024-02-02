package stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/

public class _84_LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int[] H = new int[heights.length + 2];
        System.arraycopy(heights, 0, H, 1, heights.length);

        int[] stack = new int[H.length];
        int peek = 0;
        int area = 0;
        for (int i = 1; i < H.length; i++) {
            while (peek > 0 && H[stack[peek]] > H[i]) {
                int h = H[stack[peek]];
                peek--;
                int w = i - stack[peek] - 1;
                area = Math.max(area, h * w);
            }
            stack[++peek] = i;
        }
        return area;
    }

}
