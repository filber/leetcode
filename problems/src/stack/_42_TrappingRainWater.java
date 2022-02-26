package stack;

//https://leetcode.com/problems/trapping-rain-water/

public class _42_TrappingRainWater {

    // Two Pointers
    public int trap(int[] height) {
        int lMax = height[0], rMax = height[height.length - 1];
        int l = 1, r = height.length - 2;
        int volume = 0;
        while (l <= r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if (lMax <= rMax) {
                if (height[l] < lMax) {
                    volume += lMax - height[l];
                }
                l++;
            } else {
                if (height[r] < rMax) {
                    volume += rMax - height[r];
                }
                r--;
            }
        }
        return volume;
    }

    public int trapStack(int[] height) {
        int n = height.length;
        int[] dpLeft = new int[n];
        dpLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            dpLeft[i] = Math.max(height[i], dpLeft[i - 1]);
        }
        int[] dpRight = new int[n];
        dpRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dpRight[i] = Math.max(dpRight[i + 1], height[i]);
        }

        int volume = 0;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top > 0 && height[i] > height[stack[top]]) {
                int idx = stack[top];
                int v = Math.min(dpRight[idx], dpLeft[idx]) - height[idx];
                volume += v;
                top--;
            }
            stack[++top] = i;
        }

        return volume;
    }
}
