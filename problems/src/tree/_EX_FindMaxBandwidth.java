package tree;

import java.util.Random;

public class _EX_FindMaxBandwidth {
//    For n tv channels, given show start time, end time & bandwidth needed for each channels,
//    find the maximum bandwidth required at peak.
//    a show represented as [1,30,2] meaning [show-start-time, show-end-time, bandwidth-needed].
//
//    e.g. n =3 channels,
//            [[1,30, 2],[31,60, 4],[61,120, 3],
//            [1,20,2],[21,40,4],[41,60,5],[61,120,3],
//            [1,60,4],[61,120,4]]
//
//    Ans: 13, for time slot between 41-60 each channel need 4,5,4 bandwidth respectively. 13 is highest (peek/max) bandwidth.
//
//    Note
//    Min-size-of-show = 2 (min)
//    Max-duration-for-show = 720 (min) same as 24hours
//    Max-bandwidth-per-show = 100 (mbps)
//    n<1000
//    Some channels can decide not to broadcast any show for given time-slot, which mean there will be 0 bandwidth required for that channel for given time-slot.

    SegmentTree root = null;
    int maxBandwidth = 0;

    public int maxBandwidth(int[][] channels) {
        for (int[] channel : channels) {
            root = add(root, channel[0], channel[1], channel[2]);
        }
        return maxBandwidth;
    }

    private SegmentTree add(SegmentTree node, int L, int R, int B) {
        if (L >= R) {
            return null;
        } else if (node == null) {
            node = new SegmentTree(L, R, B);
        } else if (R <= node.begin) {
            node.left = add(node.left, L, R, B);
        } else if (node.end <= L) {
            node.right = add(node.right, L, R, B);
        } else if (node.begin < L && R < node.end) {
            SegmentTree leftNode = new SegmentTree(node.begin, L, node.bandwidth);
            leftNode.left = node.left;
            node.left = leftNode;

            SegmentTree rightNode = new SegmentTree(R, node.end, node.bandwidth);
            rightNode.right = node.right;
            node.right = rightNode;

            node.bandwidth += B;
            node.begin = L;
            node.end = R;
        } else if (L <= node.begin && node.end <= R) {
            node.bandwidth += B;
            node.left = add(node.left, L, node.begin, B);
            node.right = add(node.right, node.end, R, B);
        } else if (node.begin < L && node.end <= R) {
            SegmentTree leftNode = new SegmentTree(node.begin, L, node.bandwidth);
            leftNode.left = node.left;
            node.left = leftNode;

            node.begin = L;
            node.bandwidth += B;
            node.right = add(node.right, node.end, R, B);
        } else if (L <= node.begin && R < node.end) {
            SegmentTree rightNode = new SegmentTree(R, node.end, node.bandwidth);
            rightNode.right = node.right;
            node.right = rightNode;

            node.end = R;
            node.bandwidth += B;
            node.left = add(node.left, L, node.begin, B);
        }


        maxBandwidth = Math.max(maxBandwidth, node.bandwidth);
        return node;
    }


    public class SegmentTree {
        int begin;
        int end;
        int bandwidth;
        SegmentTree left;
        SegmentTree right;

        public SegmentTree(int begin, int end, int bandwidth) {
            this.begin = begin;
            this.end = end;
            this.bandwidth = bandwidth;
        }
    }
}
