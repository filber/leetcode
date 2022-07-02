package greedy;

//https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/

import java.util.Arrays;

public class _1465_MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int m = horizontalCuts.length;
        long maxH = horizontalCuts[0];
        for (int i = 0; i < m - 1; i++) {
            maxH = Math.max(maxH, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        maxH = Math.max(maxH, h - horizontalCuts[m - 1]);

        int n = verticalCuts.length;
        long maxW = verticalCuts[0];
        for (int i = 0; i < n - 1; i++) {
            maxW = Math.max(maxW, verticalCuts[i + 1] - verticalCuts[i]);
        }
        maxW = Math.max(maxW, w - verticalCuts[n - 1]);

        int modulo = (int) 1e9 + 7;
        long area = maxH * maxW;
        return (int) (area % modulo);
    }
}
