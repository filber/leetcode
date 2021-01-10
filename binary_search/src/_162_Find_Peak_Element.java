public class _162_Find_Peak_Element {
  public int findPeakElement(int[] nums) {
    return findPeak(nums, 0, nums.length - 1);
  }

  public int findPeak(int[] nums, int startIndex, int endIndex) {
    if (endIndex == 0) {
      return endIndex;
    } else if (startIndex == (nums.length - 1)) {
      return startIndex;
    } else if (startIndex == endIndex) {
      return startIndex;
    }

    int mid = (startIndex + endIndex) / 2;
    boolean gtLeft = false;
    if (mid == 0) {
      gtLeft = true;
    } else if (nums[mid] > nums[mid - 1]) {
      gtLeft = true;
    }

    boolean gtRight = false;
    if (mid == nums.length - 1) {
      gtRight = true;
    } else if (nums[mid] > nums[mid + 1]) {
      gtRight = true;
    }

    if (gtLeft && gtRight) {
      return mid;
    } else if (gtLeft) {
      // search in the right part
      return findPeak(nums, mid + 1, endIndex);
    } else {
      // search in the left part
      return findPeak(nums, startIndex, mid - 1);
    }
  }

  public static void main(String[] args) {
    _162_Find_Peak_Element instance = new _162_Find_Peak_Element();
    int[] nums = {1,2,1,3,5,6,4};
    int result = instance.findPeakElement(nums);
    assert result == 5;
  }
}
