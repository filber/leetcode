package tree;

//https://leetcode.com/problems/range-module/

import java.util.Map;
import java.util.TreeMap;

public class _715_RangeModule {

    public abstract static class RangeModule {

        public abstract void addRange(int left, int right);

        public abstract boolean queryRange(int left, int right);

        public abstract void removeRange(int left, int right);

        public abstract int[][] ranges();
    }

    public static class TMRangeModule extends RangeModule {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        private void removeEntry(Map.Entry<Integer, Integer> entry) {
            treeMap.remove(entry.getKey());
        }

        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> preEntry = treeMap.floorEntry(left);
            if (preEntry != null) {
                if (preEntry.getValue() < left) {
                    // no overlapping
                } else if (preEntry.getValue() < right) {
                    removeEntry(preEntry);
                    left = preEntry.getKey();// merge
                } else {
                    return; // no need to add
                }
            }

            Map.Entry<Integer, Integer> postEntry = treeMap.ceilingEntry(left);
            while (postEntry != null && postEntry.getKey() <= right) {
                removeEntry(postEntry);
                right = Math.max(right, postEntry.getValue());
                postEntry = treeMap.ceilingEntry(left);
            }

            treeMap.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> preEntry = treeMap.floorEntry(left);
            return preEntry != null && right <= preEntry.getValue();
        }

        private void add(int L, int R) {
            if (L < R) {
                treeMap.put(L, R);
            }
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> preEntry = treeMap.floorEntry(left);
            if (preEntry != null) {
                if (preEntry.getValue() <= left) {
                    // no overlapping
                } else if (preEntry.getValue() < right) {
                    removeEntry(preEntry);
                    add(preEntry.getKey(), left);
                } else {
                    removeEntry(preEntry);
                    add(preEntry.getKey(), left);
                    add(right, preEntry.getValue());
                }
            }

            Map.Entry<Integer, Integer> postEntry = treeMap.ceilingEntry(left);
            while (postEntry != null && postEntry.getKey() < right) {
                removeEntry(postEntry);
                add(right, postEntry.getValue());
                postEntry = treeMap.ceilingEntry(left);
            }
        }

        @Override
        public int[][] ranges() {
            int[][] ans = new int[treeMap.size()][2];

            Map.Entry<Integer, Integer> cur = treeMap.firstEntry();
            for (int i = 0; i < ans.length; i++) {
                ans[i][0] = cur.getKey();
                ans[i][1] = cur.getValue();
                cur = treeMap.higherEntry(cur.getKey());
            }

            return ans;
        }
    }
}
