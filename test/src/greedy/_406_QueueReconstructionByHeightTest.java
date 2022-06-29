package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _406_QueueReconstructionByHeightTest {

    _406_QueueReconstructionByHeight target = null;

    @Before
    public void before() throws Exception {
        target = new _406_QueueReconstructionByHeight();
    }

    @After
    public void after() throws Exception {

    }

    private int[] toArray(int[][] queue) {
        int n = queue.length;
        int[] arr = new int[2 * n];
        for (int i = 0; i < n; i++) {
            arr[i * 2] = queue[i][0];
            arr[i * 2 + 1] = queue[i][1];
        }

        return arr;
    }

    @Test
    public void testReconstructQueue1() throws Exception {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] queue = target.reconstructQueue(people);
        assertArrayEquals(new int[]{5, 0, 7, 0, 5, 2, 6, 1, 4, 4, 7, 1}, toArray(queue));
    }

    @Test
    public void testReconstructQueue2() throws Exception {
        int[][] people = {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
        int[][] queue = target.reconstructQueue(people);
        assertArrayEquals(new int[]{4, 0, 5, 0, 2, 2, 3, 2, 1, 4, 6, 0}, toArray(queue));
    }
}
