package tp;

//https://leetcode.com/problems/assign-cookies/

import java.util.Arrays;

public class _455_AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, content = 0;

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                content++;
                i++;
            }
            j++;
        }
        return content;
    }
}
