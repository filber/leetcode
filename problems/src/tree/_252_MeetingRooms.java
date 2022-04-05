package tree;

//https://leetcode.com/problems/meeting-rooms/

import java.util.Arrays;

public class _252_MeetingRooms {

//    Given an array of meeting time intervals consisting of start and end times
//    [[s1,e1],[s2,e2],...] (si < ei),
//    determine if a person could attend all meetings.


    public boolean attendAll(int[][] meeting) {
        Arrays.sort(meeting, (a, b) -> a[0] - b[0]);
        int n = meeting.length;
        for (int i = 1; i < n; i++) {
            int preEnd = meeting[i - 1][1];
            int curStart = meeting[i][0];
            if (curStart < preEnd) {
                return false;
            }
        }

        return true;
    }

    private SegmentTree root = null;

    public boolean attendAllST(int[][] meeting) {

        for (int[] m : meeting) {
            try {
                root = addRange(root, m[0], m[1]);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return true;
    }

    private SegmentTree addRange(SegmentTree node, int L, int R) throws IllegalArgumentException {
        if (node == null) {
            return new SegmentTree(L, R);
        } else if (R <= node.begin) {
            node.left = addRange(node.left, L, R);
            return node;
        } else if (node.end <= L) {
            node.right = addRange(node.right, L, R);
            return node;
        } else {
            // conflict with node
            throw new IllegalArgumentException();
        }
    }

    public static class SegmentTree {
        int begin;
        int end;
        SegmentTree left;
        SegmentTree right;

        public SegmentTree(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}
