import java.util.Comparator;
import java.util.PriorityQueue;

public class _973_KClosestPointsToOrigin {

    public static class Point {
        int x;
        int y;
        int distance;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            distance = x*x + y*y;
        }
    }

    public static class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            return Integer.compare(o1.distance, o2.distance);
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        if (n == 1) {
            return points;
        }

        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(n, new PointComparator());
        for (int i = 0; i < n; i++) {
            priorityQueue.add(new Point(points[i][0], points[i][1]));
        }

        int[][] closest = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point point = priorityQueue.poll();
            closest[i][0] = point.x;
            closest[i][1] = point.y;
        }
        return closest;
    }

    public static void main(String[] args) {
        int[][] p1 = new int[][]{{1, 3}, {-2, 2}};
        p1 = kClosest(p1, 1);

        int[][] p2 = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        p2 = kClosest(p2, 2);
    }
}
