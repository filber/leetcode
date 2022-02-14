package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _797_AllPathsFromSourceToTargetTest {

    _797_AllPathsFromSourceToTarget target = null;

    @Before
    public void before() throws Exception {
        target = new _797_AllPathsFromSourceToTarget();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testAllPathsSourceTargetFourNodes() throws Exception {
        List<List<Integer>> list = target.allPathsSourceTarget(new int[][]{
                {1, 2}, // 0->1, 0->2
                {3},    // 1->3
                {3},    // 2->3
                {}
        });
        assertEquals(2, list.size());
        assertArrayEquals(new Integer[]{0, 1, 3},
                list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{0, 2, 3},
                list.get(1).toArray(new Integer[0]));
    }

    @Test
    public void testAllPathsSourceTargetFiveNodes() throws Exception {
        List<List<Integer>> list = target.allPathsSourceTarget(new int[][]{
                {4, 3, 1},    // 0->4, 0->3, 0->1
                {3, 2, 4},    // 1->3, 1->2, 1->4
                {3},        // 2->3
                {4},        // 3->4
                {}});
        assertEquals(5, list.size());
        assertArrayEquals(new Integer[]{0, 4}, list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{0, 3, 4}, list.get(1).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{0, 1, 3, 4}, list.get(2).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4}, list.get(3).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{0, 1, 4}, list.get(4).toArray(new Integer[0]));
    }

    @Test
    public void testAllPathsSourceTargetOnePath() throws Exception {
        List<List<Integer>> list = target.allPathsSourceTarget(new int[][]{
                {2},    // 0->2
                {},
                {1}     // 2->1
        });
        assertEquals(1, list.size());
        assertArrayEquals(new Integer[]{0, 2},
                list.get(0).toArray(new Integer[0]));
    }
}
