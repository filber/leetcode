package array_matrix;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class _34_FindFirstAndLastPositionOfElementInSortedArray {

  public static int binarySearch(int[] nums, int target, int start, int end) {
    if (nums.length==0){
      return -1;
    } else if (start>end) {
      return -1;
    }

    int middleIndex = (start + end) / 2;
    int middleValue = nums[middleIndex];
    if (middleValue == target) {
      return middleIndex;
    } else if (target < middleValue) {
      return binarySearch(nums,target,start,middleIndex-1);
    } else {
      return binarySearch(nums, target, middleIndex + 1, end);
    }
  }

  public static int searchFirst(int[] nums, int target, int start, int end) {
    if (start == end) {
      return start;
    }
    int middleIndex = (start + end) / 2;
    int middleValue = nums[middleIndex];
    if (middleValue == target) {
      return searchFirst(nums, target, start, middleIndex);
    } else {
      return searchFirst(nums, target, middleIndex + 1, end);
    }
  }

  public static int searchLast(int[] nums, int target, int start, int end) {
    if (start == end) {
      return start;
    }
    int middleIndex = (start + end + 1) / 2;
    int middleValue = nums[middleIndex];
    if (middleValue == target) {
      return searchLast(nums, target, middleIndex, end);
    } else {
      return searchLast(nums, target, start, middleIndex - 1);
    }
  }

  public static int[] searchRange(int[] nums, int target) {
    int targetIndex = binarySearch(nums, target, 0, nums.length - 1);
    if (targetIndex<0) {
      return new int[]{-1, -1};
    }
    int firstIndex = searchFirst(nums, nums[targetIndex], 0, targetIndex);
    int lastIndex = searchLast(nums, nums[targetIndex], targetIndex,nums.length-1);
    return new int[]{firstIndex,lastIndex};
  }

  public static void main(String[] args) {
    int[] p1 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8); // 3,4
    int[] p2 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6); // -1,-1
    int[] p3 = searchRange(new int[]{}, 0); // -1,-1
    int[] p4 = searchRange(new int[]{5, 7, 7,7,7,8, 8, 10}, 7); // 1,1
  }
}
