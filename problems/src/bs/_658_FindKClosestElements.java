package bs;

//https://leetcode.com/problems/find-k-closest-elements/

import java.util.*;

public class _658_FindKClosestElements {

//    An integer a is closer to x than an integer b if:
//        |a - x| < |b - x|, or
//        |a - x| == |b - x| and a < b

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                ans.add(arr[i]);
            }
        } else if (x >= arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) {
                ans.add(arr[i]);
            }
        } else {
            int pos = search(arr, x);
            collect(arr, ans, x, k, pos);
        }
        return ans;
    }

    private void collect(int[] arr, List<Integer> ans, int x, int k, int pos) {
        int l = pos - 1, r = pos + 1;
        k--;
        while (k > 0 && l >= 0 && r < arr.length) {
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
            k--;
        }
        while (k > 0 && l >= 0) {
            l--;
            k--;
        }
        while (k > 0 && r < arr.length) {
            r++;
            k--;
        }

        k++;
        for (int i = l + 1; i < r; i++) {
            ans.add(arr[i]);
        }
    }

    private int search(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (Math.abs(arr[r] - x) <= Math.abs(arr[l] - x)) {
            return r;
        } else {
            return l;
        }
    }
}
