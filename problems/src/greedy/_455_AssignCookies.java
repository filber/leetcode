package greedy;

// https://leetcode.com/problems/assign-cookies/

import java.util.Arrays;

public class _455_AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
      Arrays.sort(g);
      Arrays.sort(s);
      int l = 0, r = 0;
      while (l < g.length && r < s.length) {
        if (g[l]<=s[r]) {
          l++;
        }
        r++;
      }
      return l;
    }

    public static void main(String[] args) {
        int n1 = findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}); // 1
        int n2 = findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}); // 2
    }
}
