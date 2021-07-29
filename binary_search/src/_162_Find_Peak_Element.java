public class _162_Find_Peak_Element {
  public static int findPeakElement(int[] nums) {
    return findPeak(nums, 0, nums.length - 1);
  }

  public static int findPeak(int[] nums, int startIndex, int endIndex) {
    if (startIndex == endIndex) {
      return startIndex;
    }

    int middleIndex = (startIndex + endIndex) / 2;
    int middleValue = nums[middleIndex];
    int middleLeft = middleIndex == 0 ? Integer.MIN_VALUE : nums[middleIndex - 1];
    int middleRight = middleIndex == nums.length - 1 ? Integer.MIN_VALUE : nums[middleIndex + 1];
    if ((middleLeft > middleValue) && middleIndex != 0) {
      return findPeak(nums, startIndex, middleIndex - 1);
    } else if ((middleRight > middleValue) && middleIndex != (nums.length - 1)) {
      return findPeak(nums, middleIndex + 1, endIndex);
    } else {
      return middleIndex;
    }
  }

  public static void main(String[] args) {
    // 2
    System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));

    // 1 or 5
    System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));

    // 0
    System.out.println(findPeakElement(new int[]{-2147483648}));

    // 1
    System.out.println(findPeakElement(new int[]{1,2}));
  }
}
