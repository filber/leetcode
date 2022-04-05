package greedy;

//https://leetcode.com/problems/container-with-most-water
//[Greedy],[Two Pointers]
public class _11_Container_With_Most_Water {

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int area = 0;
        while (l < r) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return area;
    }
}
