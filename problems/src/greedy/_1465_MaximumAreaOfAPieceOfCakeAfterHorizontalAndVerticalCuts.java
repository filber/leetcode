package greedy;

//https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/

import java.util.Arrays;

public class _1465_MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    public int maxArea(int h, int w, int[] hCuts, int[] vCuts) {
        int modulo = (int) 1e9 + 7;
        Arrays.sort(hCuts);
        Arrays.sort(vCuts);
        int hGap = hCuts[0];
        for (int i = 1; i < hCuts.length; i++) {
            hGap = Math.max(hGap, hCuts[i] - hCuts[i - 1]);
        }
        hGap = Math.max(hGap, h - hCuts[hCuts.length - 1]);

        int vGap = vCuts[0];
        for (int i = 1; i < vCuts.length; i++) {
            vGap = Math.max(vGap, vCuts[i] - vCuts[i - 1]);
        }
        vGap = Math.max(vGap, w - vCuts[vCuts.length - 1]);
        return (int) (((long) hGap * vGap) % modulo);
    }
}
