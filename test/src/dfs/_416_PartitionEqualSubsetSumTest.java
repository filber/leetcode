package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _416_PartitionEqualSubsetSumTest {

    _416_PartitionEqualSubsetSum target = null;

    @Before
    public void before() throws Exception {
        target = new _416_PartitionEqualSubsetSum();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCanPartition1() throws Exception {
        //[11] vs[1,5,5]
        assertTrue(target.canPartition(new int[]{1, 5, 11, 5}));
    }

    @Test
    public void testCanPartition2() throws Exception {
        assertFalse(target.canPartition(new int[]{1, 2, 3, 5}));
    }

    @Test
    public void testCanPartition3() throws Exception {
        //[1,4] vs [2,5]
        assertTrue(target.canPartition(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testCanPartition4() throws Exception {
        //[1,7] vs [3,5]
        assertTrue(target.canPartition(new int[]{1, 3, 5, 7}));
    }

    @Test
    public void testCanPartition5() throws Exception {
        assertFalse(target.canPartition(new int[]{1, 3, 5, 8}));
    }
}
