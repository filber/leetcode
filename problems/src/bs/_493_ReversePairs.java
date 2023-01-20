package bs;

//https://leetcode.com/problems/reverse-pairs/

public class _493_ReversePairs {

    private int[] nums;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        return pairs(0, nums.length - 1);
    }

    private int pairs(int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        int left = pairs(l, mid);
        int right = pairs(mid + 1, r);
        int count = left + right;
        for (int j = mid + 1; j <= r; j++) {
            int pos = search(l, mid, 2L * nums[j]);
            count += pos;
        }

        // merge
        int p = l, q = mid + 1;
        int pos = 0;
        int[] arr = new int[r - l + 1];
        while (p <= mid && q <= r) {
            if (nums[p] <= nums[q]) {
                arr[pos++] = nums[p++];
            } else {
                arr[pos++] = nums[q++];
            }
        }
        while (p <= mid) {
            arr[pos++] = nums[p++];
        }
        while (q <= r) {
            arr[pos++] = nums[q++];
        }

        pos = l;
        for (int i = 0; i < arr.length; i++) {
            nums[pos++] = arr[i];
        }
        return count;
    }

    private int search(int l, int r, long target) {
        int p = l, q = r;
        while (p < q) {
            int mid = (p + q) / 2;
            if (nums[mid] <= target) {
                p = mid + 1;
            } else {
                q = mid;
            }
        }
        if (nums[p] > target) {
            return r - p + 1;
        } else {
            return 0;
        }
    }
}
