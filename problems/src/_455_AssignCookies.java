import java.util.Arrays;

public class _455_AssignCookies {

  public static int findContentChildren(int[] g, int[] s) {
    int maxContent = 0;
    Arrays.sort(g);
    Arrays.sort(s);
    int gIndex = 0;
    int sIndex = 0;

    while (gIndex < g.length && sIndex < s.length) {
      if (g[gIndex]<=s[sIndex]) {
        // assign
        gIndex++;
        sIndex++;
        maxContent++;
      } else {
        // g[gIndex]>s[sIndex]
        sIndex++;
      }
    }
    return maxContent;
  }

  public static void main(String[] args) {
    // 1
    findContentChildren(new int[] {1, 2, 3}, new int[] {1, 1});

    // 2
    findContentChildren(new int[] {1, 2}, new int[] {1, 2, 3});
  }
}
