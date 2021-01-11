public class _34_Search_For_A_Range {

  public int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid]> target) {
        // search in the left part.
        high = mid-1;
      } else if (nums[mid]< target){
        // search in the right part.
        low = mid + 1;
      } else {
        // found target!
        return mid;
      }
    }
    return -1;
  }

  public int[] searchRange(int[] nums, int target) {
    int first = findFirst(nums, target);
    int last = findLast(nums, target);
    return new int[] {first, last};
  }

  public int findFirst(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      // return condition!
      if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) {
        return mid;
      } else if (nums[mid] < target) {
        // search in the right part.
        low = mid + 1;
      } else {
        // recursively search in the left part, approximating the first position.
        high = mid-1;
      }
    }
    return -1;
  }

  public int findLast(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      // return condition!
      if (nums[mid] == target && (mid == (nums.length - 1) || nums[mid + 1] != target)) {
        return mid;
      } else if (nums[mid] > target) {
        // search in the left part.
        high = mid-1;
      } else {
        // recursively search in the right part, approximating the last position.
        low = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    _34_Search_For_A_Range instance = new _34_Search_For_A_Range();
    int[] nums = {1,1,2,2,2,3};

    int first = instance.findFirst(nums, 2);
    int last = instance.findLast(nums, 2);
  }
}
