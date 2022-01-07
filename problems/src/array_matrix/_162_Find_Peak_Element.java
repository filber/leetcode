package array_matrix;
// https://leetcode.com/problems/find-peak-element/

// TIPS:
// Divide&Conquer
// Using graphics : Uphill vs Downhill
public class _162_Find_Peak_Element {
  public static int findPeakElement(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }

    return findPeak(nums, 0, nums.length - 1);
  }

  public static int findPeak(int[] nums, int start, int end) {
    // 0. Guard conditions
    if (start < 0 || end >= nums.length || start > end) {
      return -1; // no element
    }

    // 1. one element
    if (start == end) {
      return start;
    } else if (end-start==1) {
      //two elements
      if (judgePeak(nums,start)) {
        return start;
      } else {
        return end;
      }
    } else {
      int middle = (start+end)/2;
      int middleValue = nums[middle];
      int leftValue = nums[middle - 1];
      int rightValue = nums[middle + 1];
      if (middleValue > rightValue && middleValue > leftValue) {
        // found!
        return middle;
      }
      else if (middleValue < rightValue) {
        // uphill, move to right
        return findPeak(nums, middle + 1, end);
      } else {
        // downhill, move to left
        return findPeak(nums, start, middle - 1);
      }
    }
  }

  private static boolean judgePeak(int[] nums, int index) {
    if (index==0) {
      return nums[index] > nums[index + 1];
    } else if (index == nums.length - 1) {
      return nums[index] > nums[index - 1];
    } else {
      return nums[index] > nums[index - 1] && nums[index] > nums[index + 1];
    }
  }

  public static void main(String[] args) {
    // 2
    int p1 = findPeakElement(new int[]{1, 2, 3, 1});

    // 1 or 5
    int p2 = findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});

    // 0
    int p3 = findPeakElement(new int[]{-2147483648});

    // 1
    int p4 = findPeakElement(new int[]{1,2});
  }
}
