package array_matrix;

//https://leetcode.com/problems/sliding-window-median/


import java.util.TreeSet;

public class _480_SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Integer> leftTreeSet = new TreeSet<>(
                (a, b) -> nums[a] == nums[b] ? b - a : Integer.compare(nums[b], nums[a])
        );
        TreeSet<Integer> rightTreeSet = new TreeSet<>(
                (a, b) -> nums[a] == nums[b] ? b - a : Integer.compare(nums[a], nums[b])
        );
        int n = nums.length;
        double[] median = new double[n - k + 1];
        for (int i = 0; i < k; i++) {
            leftTreeSet.add(i);
        }
        for (int i = 0; i < k / 2; i++) {
            rightTreeSet.add(leftTreeSet.pollFirst());
        }
        if (k % 2 == 0) {
            median[0] = ((double) nums[leftTreeSet.first()] + nums[rightTreeSet.first()]) / 2.0;
        } else {
            median[0] = nums[leftTreeSet.first()];
        }

        for (int i = 1; i + k - 1 < n; i++) {
            if (!leftTreeSet.remove(i - 1)) {
                rightTreeSet.remove(i - 1);
            }
            int val = i + k - 1;
            if (leftTreeSet.size() == rightTreeSet.size()) {
                rightTreeSet.add(val);
                leftTreeSet.add(rightTreeSet.pollFirst());
            } else if (leftTreeSet.size() > rightTreeSet.size()) {
                leftTreeSet.add(val);
                while (leftTreeSet.size() - rightTreeSet.size() > 1) {
                    rightTreeSet.add(leftTreeSet.pollFirst());
                }
            } else {
                rightTreeSet.add(val);
                while (leftTreeSet.size() < rightTreeSet.size()) {
                    leftTreeSet.add(rightTreeSet.pollFirst());
                }
            }


            if (k % 2 == 0) {
                median[i] = ((double) nums[leftTreeSet.first()] + nums[rightTreeSet.first()]) / 2.0;
            } else {
                median[i] = nums[leftTreeSet.first()];
            }
        }

        return median;
    }
}
