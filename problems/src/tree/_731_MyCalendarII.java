package tree;

//https://leetcode.com/problems/my-calendar-ii/

import java.util.Map;
import java.util.TreeMap;

public class _731_MyCalendarII {

    public interface MyCalendarTwo {
        boolean book(int L, int R);
    }

    public static class STCalendar implements MyCalendarTwo {
        SegmentTree root = null;

        public boolean book(int L, int R) {
            boolean isValid = validate(root, L, R);
            if (!isValid) {
                return false;
            }
            root = addRange(root, L, R);
            return true;
        }

        private boolean validate(SegmentTree node, int L, int R) {
            if (L >= R) {
                return true;
            } else if (node == null) {
                return true;
            } else if (R <= node.begin) {
                return validate(node.left, L, R);
            } else if (node.end <= L) {
                return validate(node.right, L, R);
            } else {
                if (node.cnt == 2) {
                    return false;
                }
                return validate(node.left, L, node.begin) &&
                        validate(node.right, node.end, R);
            }
        }

        private SegmentTree addRange(SegmentTree node, int L, int R) {
            if (L >= R) {
                return node;
            } else if (node == null) {
                return new SegmentTree(L, R);
            } else if (R <= node.begin) {
                node.left = addRange(node.left, L, R);
                return node;
            } else if (node.end <= L) {
                node.right = addRange(node.right, L, R);
                return node;
            } else {
                node.left = addRange(node.left, L, node.begin);
                node.right = addRange(node.right, node.end, R);

                if (L <= node.begin && node.end <= R) {
                    node.cnt++;
                } else if (node.begin < L && R < node.end) {
                    SegmentTree leftST = new SegmentTree(node.begin, L, 1);
                    leftST.left = node.left;
                    node.left = leftST;
                    node.begin = L;

                    SegmentTree rightST = new SegmentTree(R, node.end, 1);
                    rightST.right = node.right;
                    node.right = rightST;
                    node.end = R;

                    node.cnt = 2;
                } else if (R < node.end) {
                    SegmentTree leftST = new SegmentTree(node.begin, R, 2);
                    leftST.left = node.left;
                    node.left = leftST;
                    node.begin = R;
                } else {
                    //node.begin < L
                    SegmentTree rightST = new SegmentTree(L, node.end, 2);
                    rightST.right = node.right;
                    node.right = rightST;
                    node.end = L;
                }
                return node;
            }
        }

        public static class SegmentTree {
            int begin;
            int end;
            int cnt;

            SegmentTree left = null;
            SegmentTree right = null;

            public SegmentTree(int begin, int end) {
                this.begin = begin;
                this.end = end;
                cnt = 1;
            }

            public SegmentTree(int begin, int end, int cnt) {
                this(begin, end);
                this.cnt = cnt;
            }
        }
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
