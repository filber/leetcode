package tree;

//https://leetcode.com/problems/my-calendar-ii/

import java.util.Map;
import java.util.TreeMap;

public class _731_MyCalendarII {

    public interface MyCalendarTwo {
        boolean book(int L, int R);

        int[][][] ranges();
    }

    public static class TMCalendar implements MyCalendarTwo {

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
            Map.Entry<Integer, Integer> floor = firstTM.floorEntry(L);
            Map.Entry<Integer, Integer> ceiling = firstTM.ceilingEntry(L);
            if (floor != null) {
                if (floor.getValue() < L) {
                    // no conflicts
                } else if (floor.getValue() < R) {
                    if (L < floor.getValue()) {
                        secondTM.put(L, floor.getValue());
                    }
                    L = floor.getKey();
                    firstTM.remove(floor.getKey());
                } else {
                    // R <= floor.getValue()
                    secondTM.put(L, R);
                    return;
                }
            }

            while (ceiling != null && ceiling.getKey() <= R) {
                firstTM.remove(ceiling.getKey());
                int minEnd = Math.min(ceiling.getValue(), R);
                if (ceiling.getKey() < minEnd) {
                    secondTM.put(ceiling.getKey(), minEnd);
                }
                R = Math.max(R, ceiling.getValue());
                ceiling = firstTM.ceilingEntry(L);
            }
            firstTM.put(L, R);
        }

        private boolean conflict(int L, int R) {
            Map.Entry<Integer, Integer> floor = secondTM.floorEntry(L);
            Map.Entry<Integer, Integer> ceiling = secondTM.ceilingEntry(L);
            if (floor != null && L < floor.getValue()) {
                return true;
            } else if (ceiling != null && ceiling.getKey() < R) {
                return true;
            } else {
                return false;
            }
        }

        public int[][][] ranges() {
            int[][][] ans = new int[2][][];

            Map.Entry<Integer, Integer> cur = firstTM.firstEntry();
            ans[0] = new int[firstTM.size()][2];
            for (int i = 0; i < ans[0].length; i++) {
                ans[0][i][0] = cur.getKey();
                ans[0][i][1] = cur.getValue();
                cur = firstTM.higherEntry(cur.getKey());
            }

            cur = secondTM.firstEntry();
            ans[1] = new int[secondTM.size()][2];
            for (int i = 0; i < ans[1].length; i++) {
                ans[1][i][0] = cur.getKey();
                ans[1][i][1] = cur.getValue();
                cur = secondTM.higherEntry(cur.getKey());
            }

            return ans;
        }
    }
}
