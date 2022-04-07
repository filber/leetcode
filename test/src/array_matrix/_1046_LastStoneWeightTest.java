package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1046_LastStoneWeightTest {

    _1046_LastStoneWeight target = null;

    @Before
    public void before() throws Exception {
        target = new _1046_LastStoneWeight();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testLastStoneWeight1() throws Exception {
        int lastStone = target.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        assertEquals(1, lastStone);
    }

    @Test
    public void testLastStoneWeight2() throws Exception {
        int lastStone = target.lastStoneWeight(new int[]{1});
        assertEquals(1, lastStone);
    }

    @Test
    public void testLastStoneWeight3() throws Exception {
        int lastStone = target.lastStoneWeight(new int[]{1, 1});
        assertEquals(0, lastStone);
    }

    @Test
    public void testLastStoneWeight4() throws Exception {
        int lastStone = target.lastStoneWeight(new int[]{1, 1, 1, 1});
        assertEquals(0, lastStone);
    }
}
