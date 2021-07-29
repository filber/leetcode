import java.util.Comparator;
import java.util.PriorityQueue;

public class _973_KClosestPointsToOrigin {
    public static class PointComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] point1, int[] point2) {
            return Integer.compare(point1[0] * point1[0] + point1[1] * point1[1],
                    point2[0] * point2[0] + point2[1] * point2[1]);
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>(k,new PointComparator());
        for (int i = 0; i < points.length; i++) {
            queue.add(points[i]);
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
//        Input: points = [[1,3],[-2,2]], K = 1
//        Output: [[-2,2]]
//        kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);

//        Input: points = [[3,3],[5,-1],[-2,4]], K = 2
//        Output: [[3,3],[-2,4]]
//        kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);

//        Input: points = [[-5,4],[-6,-5],[4,6]], K = 2
//        Output: [[-5,4],[4,6]]
        kClosest(new int[][]{{-5, 4}, {-6, -5}, {4, 6}}, 2);
    }
}
