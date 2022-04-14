package bs;

//https://leetcode.com/problems/find-k-closest-elements/

import java.util.*;

public class _658_FindKClosestElements {

//    An integer a is closer to x than an integer b if:
//        |a - x| < |b - x|, or
//        |a - x| == |b - x| and a < b


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        if (n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            return list;
        }
        int idx = search(arr, x, 0, n - 1);
        return collect(arr, idx, k, x);
    }

    private int search(int[] arr, int x, int l, int r) {
        if (l > r) {
            if (l == arr.length) {
                return r;
            } else if (r == -1) {
                return l;
            } else {
                int lAbs = Math.abs(arr[l] - x);
                int rAbs = Math.abs(arr[r] - x);
                if (rAbs <= lAbs) {
                    return r;
                } else {
                    return l;
                }
            }
        } else if (l == r) {
            if (l == arr.length - 1) {
                int endAbs = Math.abs(arr[l] - x);
                int leftAbs = Math.abs(arr[l - 1] - x);
                if (leftAbs <= endAbs) {
                    return l - 1;
                } else {
                    return l;
                }
            } else if (l == 0) {
                int beginAbs = Math.abs(arr[l] - x);
                int rightAbs = Math.abs(arr[l + 1] - x);
                if (beginAbs <= rightAbs) {
                    return l;
                } else {
                    return l + 1;
                }
            } else {
                int leftAbs = Math.abs(arr[l - 1] - x);
                int middleAbs = Math.abs(arr[l] - x);
                int rightAbs = Math.abs(arr[l + 1] - x);
                if (leftAbs <= middleAbs && leftAbs <= rightAbs) {
                    return l - 1;
                } else if (middleAbs < leftAbs && middleAbs <= rightAbs) {
                    return l;
                } else {
                    return l + 1;
                }
            }
        } else {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                return search(arr, x, mid + 1, r);
            } else {
                return search(arr, x, l, mid - 1);
            }
        }
    }

    private List<Integer> collect(int[] arr, int idx, int k, int x) {
        int[] ans = new int[k];
        ans[0] = arr[idx];
        int len = 1;
        int l = idx - 1;
        int r = idx + 1;
        while (len < k) {
            if (l >= 0 && r < arr.length) {
                int leftAbs = Math.abs(arr[l] - x);
                int rightAbs = Math.abs(arr[r] - x);
                if (leftAbs <= rightAbs) {
                    ans[len++] = arr[l];
                    l--;
                } else {
                    ans[len++] = arr[r];
                    r++;
                }
            } else if (l >= 0) {
                ans[len++] = arr[l];
                l--;
            } else {
                ans[len++] = arr[r];
                r++;
            }
        }
        Arrays.sort(ans);
        List<Integer> list = new ArrayList<>(k);
        for (int val : ans) {
            list.add(val);
        }
        return list;
    }

    // Priority Queue
    public List<Integer> findClosestElementsPQ(int[] arr, int k, int x) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer l, Integer r) {
                int lAbs = Math.abs(arr[l] - x);
                int rAbs = Math.abs(arr[r] - x);
                if (lAbs == rAbs) {
                    return arr[l] - arr[r];
                } else {
                    return lAbs - rAbs;
                }
            }
        });

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            priorityQueue.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            ans.add(arr[priorityQueue.poll()]);
        }
        Collections.sort(ans);
        return ans;
    }
}
