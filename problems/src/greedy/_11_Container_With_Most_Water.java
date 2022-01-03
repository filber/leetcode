package greedy;

//https://leetcode.com/problems/container-with-most-water
//[Greedy],[Two Pointers]
public class _11_Container_With_Most_Water {

    public static int maxArea2(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = height.length-1;
        while (left < right) {
          int area = (right - left) * Math.min(height[left], height[right]);
          maxArea = Math.max(maxArea,area);
          if (height[left] < height[right]) {
            left++;
          } else {
            right--;
          }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int a1 = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        int a2 = maxArea(new int[]{1, 1});
        int a3 = maxArea(new int[]{10,14,10,4,10,2,6,1,6,12});
        int a4 = maxArea(new int[]{1,2,4,3});
        int a5 = maxArea(new int[]{1,3,2,5,25,24,5});
    }
}
