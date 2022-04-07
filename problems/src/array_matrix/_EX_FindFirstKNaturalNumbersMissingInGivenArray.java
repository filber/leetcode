package array_matrix;

//https://www.geeksforgeeks.org/find-first-k-natural-numbers-missing-given-array/

public class _EX_FindFirstKNaturalNumbersMissingInGivenArray {

    public int[] findKMissing(int nums[], int k) {
        int n = nums.length;
        int[] ans = new int[k];

        int i = 0;
        while (i < n) {
            int cIdx = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[cIdx]) {
                int tmp = nums[i];
                nums[i] = nums[cIdx];
                nums[cIdx] = tmp;
            } else {
                i++;
            }
        }

        i = 0;
        int lastNatural = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1 && i < k) {
                ans[i] = j + 1;
                lastNatural = Math.max(lastNatural, ans[i]);
                i++;
            }
            lastNatural = Math.max(lastNatural, nums[j]);
        }

        for (int j = i; j < k; j++) {
            ans[j] = lastNatural + j - i + 1;
        }
        return ans;
    }
}
