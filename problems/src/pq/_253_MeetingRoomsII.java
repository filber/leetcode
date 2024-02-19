package pq;

//https://leetcode.com/problems/meeting-rooms-ii/

import java.util.*;

public class _253_MeetingRoomsII {

//    Given an array of meeting time intervals consisting of start and end times
//    [[s1,e1],[s2,e2],...] (si < ei),
//    find the minimum number of conference rooms required.


    public int leastRooms(int[][] meetings) {
        PriorityQueue<Integer> used = new PriorityQueue<>(Comparator.comparing(a -> a));
        int roomCnt = 0;
        int available = 0;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        for (int[] meeting : meetings) {
            while (!used.isEmpty() && meeting[0] >= used.peek()) {
                used.poll();
                available++;
            }

            if (available == 0) {
                roomCnt++;
                used.add(meeting[1]);
            } else {
                available--;
                used.add(meeting[1]);
            }
        }
        return roomCnt;
    }

    SegmentTree root = null;
    int rooms = 0;

    public int leastRoomsST(int[][] meeting) {
        for (int[] m : meeting) {
            root = addRange(root, m[0], m[1]);
        }

        return rooms;
    }

    private SegmentTree addRange(SegmentTree node, int L, int R) {
        if (L >= R) {
            return null;
        } else if (node == null) {
            node = new SegmentTree(L, R, 1);
        } else if (R <= node.begin) {
            node.left = addRange(node.left, L, R);
        } else if (node.end <= L) {
            node.right = addRange(node.right, L, R);
        } else if (L <= node.begin && node.end <= R) {
            node.left = addRange(node.left, L, node.begin);
            node.right = addRange(node.right, node.end, R);
            node.k += 1;
        } else if (node.begin < L && R < node.end) {
            SegmentTree leftNode = new SegmentTree(node.begin, L, node.k);
            leftNode.left = node.left;
            node.left = leftNode;

            SegmentTree rightNode = new SegmentTree(R, node.end, node.k);
            rightNode.right = node.right;
            node.right = rightNode;

            node.begin = L;
            node.end = R;
            node.k += 1;
        } else if (L <= node.begin) {
            SegmentTree rightNode = new SegmentTree(R, node.end, node.k);
            rightNode.right = node.right;
            node.right = rightNode;

            node.left = addRange(node.left, L, node.begin);
            node.k += 1;
            node.end = R;
        } else {
            SegmentTree leftNode = new SegmentTree(node.begin, L, node.k);
            leftNode.left = node.left;
            node.left = leftNode;

            node.right = addRange(node.right, node.end, R);
            node.k += 1;
            node.begin = L;
        }

        rooms = Math.max(rooms, node.k);
        return node;
    }

    public static class SegmentTree {
        int begin;
        int end;
        int k;
        SegmentTree left;
        SegmentTree right;

        public SegmentTree(int begin, int end, int k) {
            this.begin = begin;
            this.end = end;
            this.k = k;
            left = null;
            right = null;
        }
    }
}
