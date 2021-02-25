import java.util.PriorityQueue;

public class _973_KClosestPointsToOrigin {

    public static class Item implements Comparable<Item> {
        int[] point;
        int distance;

        @Override
        public int compareTo(Item o) {
            return Integer.compare(distance, o.distance);
        }
    }
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Item> priorityQueue = new PriorityQueue<>(points.length);
        for (int i = 0; i < points.length; i++) {
            Item item = new Item();
            item.distance = points[i][0] * points[i][0] +
                            points[i][1] * points[i][1];
            item.point = points[i];
            priorityQueue.add(item);
        }

        int[][] results = new int[K][2];
        for (int i = 0; i < K; i++) {
            Item item = priorityQueue.poll();
            results[i] = item.point;
        }
        return results;
    }

    public static void main(String[] args) {
//        Input: points = [[1,3],[-2,2]], K = 1
//        Output: [[-2,2]]
        kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
//        Input: points = [[3,3],[5,-1],[-2,4]], K = 2
//        Output: [[3,3],[-2,4]]
        kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
    }
}
