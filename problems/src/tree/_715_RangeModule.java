package tree;

//https://leetcode.com/problems/range-module/

import java.util.Map;
import java.util.TreeMap;

public class _715_RangeModule {

    public abstract static class RangeModule {

        public abstract void addRange(int left, int right);

        public abstract boolean queryRange(int left, int right);

        public abstract void removeRange(int left, int right);
    }

    public static class TMRangeModule extends RangeModule {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> preEntry = treeMap.floorEntry(left);
            if (preEntry != null) {
                if (preEntry.getValue() < left) {
                    // no overlapping
                } else if (preEntry.getValue() < right) {
                    treeMap.remove(preEntry.getKey());
                    left = preEntry.getKey();// merge
                } else {
                    //preEntry.getValue() >= right
                    return; // no need to add
                }
            }

            Map.Entry<Integer, Integer> postEntry = treeMap.ceilingEntry(left);
            while (postEntry != null && postEntry.getKey() <= right) {
                treeMap.remove(postEntry.getKey());
                right = Math.max(right, postEntry.getValue());
                postEntry = treeMap.ceilingEntry(left);
            }

            treeMap.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> preEntry = treeMap.floorEntry(left);
            return preEntry != null && right <= preEntry.getValue();
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> preEntry = treeMap.floorEntry(left);
            if (preEntry != null) {
                if (preEntry.getValue() <= left) {
                    // no overlapping
                } else if (preEntry.getValue() < right) {
                    if (preEntry.getKey().equals(left)) {
                        treeMap.remove(preEntry.getKey());
                    } else {
                        treeMap.replace(preEntry.getKey(), left);
                    }
                } else {
                    // pre.END >= right
                    if (preEntry.getKey().equals(left) && preEntry.getValue().equals(right)) {
                        treeMap.remove(preEntry.getKey());
                    } else if (preEntry.getKey().equals(left)) {
                        treeMap.remove(preEntry.getKey());
                        treeMap.put(right, preEntry.getValue());
                    } else if (preEntry.getValue().equals(right)) {
                        treeMap.replace(preEntry.getKey(), left);
                    } else {
                        treeMap.replace(preEntry.getKey(), left);
                        treeMap.put(right, preEntry.getValue());
                    }
                }
            }

            Map.Entry<Integer, Integer> postEntry = treeMap.ceilingEntry(left);
            while (postEntry != null && postEntry.getKey() < right) {
                treeMap.remove(postEntry.getKey());
                if (right < postEntry.getValue()) {
                    treeMap.put(right, postEntry.getValue()); // cut range
                }

                postEntry = treeMap.ceilingEntry(left);
            }
        }
    }
}
