public class _11_Container_With_Most_Water {

  public int maxArea(int[] height) {
    if (height == null || height.length < 2) {
      return 0;
    }

    int maxArea = 0;
    int leftIndex = 0;
    int rightIndex = leftIndex + 1;
    while (leftIndex < height.length && rightIndex < height.length) {
      while (rightIndex < height.length) {
        int smallestHeight = Math.min(height[leftIndex], height[rightIndex]);
        int area = smallestHeight * (rightIndex - leftIndex);
        if (maxArea < area) {
          maxArea = area;
        }
        rightIndex++;
      }
      leftIndex++;
      rightIndex = leftIndex + 1;
    }

    return maxArea;
  }

  public int maxArea2(int[] height) {
    if (height == null || height.length < 2) {
      return 0;
    }

    int maxArea = 0;
    int leftIndex = 0;
    int rightIndex = height.length - 1;
    while (leftIndex < rightIndex) {
      int smallestHeight = Math.min(height[leftIndex], height[rightIndex]);
      int area = smallestHeight * (rightIndex - leftIndex);
      if (maxArea < area) {
        maxArea = area;
      }
      // move the smaller bar
      if (height[leftIndex] < height[rightIndex]) {
        leftIndex ++;
      } else {
        rightIndex--;
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int[] height = {1,8,6,2,5,4,8,3,7};
    _11_Container_With_Most_Water instance = new _11_Container_With_Most_Water();
    int result = instance.maxArea(height);
    System.out.println(result);
  }
}
