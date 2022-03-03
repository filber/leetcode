package tree;

//https://leetcode.com/problems/my-calendar-ii/

import java.util.Map;
import java.util.TreeMap;

public class _731_MyCalendarII {

    public static class MyCalendarTwo {

        public MyCalendarTwo() {
        }

        public TreeMap<Integer, Integer> firstTM = new TreeMap<>();
        public TreeMap<Integer, Integer> secondTM = new TreeMap<>();

        public boolean book(int L, int R) {
            if (conflict(L, R)) {
                return false;
            }

            addRange(L, R);

            return true;
        }

        private void addRange(int L, int R) {
            Map.Entry<Integer, Integer> preEntry = firstTM.floorEntry(L);
            if (preEntry != null) {
                if (preEntry.getValue() < L) {
                    // no overlapping
                } else if (preEntry.getValue() < R) {
                    firstTM.remove(preEntry.getKey());
                    if (L < preEntry.getValue()) {
                        secondTM.put(L, preEntry.getValue());
                    }
                    L = preEntry.getKey();// merge
                } else {
                    secondTM.put(L, R);
                    return;
                }
            }

            Map.Entry<Integer, Integer> postEntry = firstTM.ceilingEntry(L);
            while (postEntry != null && postEntry.getKey() <= R) {
                firstTM.remove(postEntry.getKey());

                if (postEntry.getKey() < Math.min(postEntry.getValue(), R)) {
                    secondTM.put(postEntry.getKey(), Math.min(postEntry.getValue(), R));
                }

                R = Math.max(R, postEntry.getValue());
                postEntry = firstTM.ceilingEntry(L);
            }

            firstTM.put(L, R);
        }

        private boolean conflict(int L, int R) {
            Map.Entry<Integer, Integer> floor = secondTM.floorEntry(L);
            Map.Entry<Integer, Integer> ceil = secondTM.ceilingEntry(L);
            if (floor == null && ceil == null) {
                return false;
            } else if (floor == null) {
                return R > ceil.getKey();
            } else if (ceil == null) {
                return floor.getValue() > L;
            } else {
                return floor.getValue() > L || R > ceil.getKey();
            }
        }

        public int[][] ranges(TreeMap<Integer, Integer> treeMap) {
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
