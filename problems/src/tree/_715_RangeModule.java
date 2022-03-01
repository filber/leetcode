package tree;

//https://leetcode.com/problems/range-module/

import java.util.Map;
import java.util.TreeMap;

public class _715_RangeModule {

    public static class RangeModule {
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        public RangeModule() {
        }

        public void addRange(int left, int right) {
            while (true) {
                Map.Entry<Integer, Integer> entry = tree.floorEntry(right);
                if (entry != null && entry.getValue() >= left) {
                    right = Math.max(entry.getValue(), right);
                    left = Math.min(entry.getKey(), left);
                    tree.remove(entry.getKey());
                } else {
                    break;
                }
            }
            tree.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = tree.floorEntry(left);
            return entry != null && entry.getValue() >= right;
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = tree.lowerEntry(left);
            if (entry != null && entry.getValue() > left) {
                tree.put(entry.getKey(), left);
                if (entry.getValue() > right) {
                    tree.put(right, entry.getValue());
                    return;
                }
            }
            while (true) {
                entry = tree.ceilingEntry(left);
                if (entry != null && entry.getKey() < right) {
                    tree.remove(entry.getKey());
                    if (entry.getValue() > right) {
                        tree.put(right, entry.getValue());
                        return;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
