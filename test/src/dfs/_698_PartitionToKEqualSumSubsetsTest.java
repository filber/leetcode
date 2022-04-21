package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _698_PartitionToKEqualSumSubsetsTest {

    _698_PartitionToKEqualSumSubsets target = null;

    @Before
    public void before() throws Exception {
        target = new _698_PartitionToKEqualSumSubsets();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCanPartitionKSubsets1() throws Exception {
        assertTrue(target.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

    @Test
    public void testCanPartitionKSubsets2() throws Exception {
        assertTrue(target.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 2));
    }

    @Test
    public void testCanPartitionKSubsets3() throws Exception {
        assertFalse(target.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3));
    }

    @Test
    public void testCanPartitionKSubsets4() throws Exception {
        assertTrue(target.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 2));
    }

    @Test
    public void testCanPartitionKSubsets5() throws Exception {
        assertTrue(target.canPartitionKSubsets(new int[]{1, 2, 3, 4, 5, 6}, 3));
    }

    @Test
    public void testCanPartitionKSubsets6() throws Exception {
        assertFalse(target.canPartitionKSubsets(new int[]{6, 5, 9, 6, 3, 5, 1, 10, 4, 1, 4, 3, 9, 9, 3, 3}, 9));
    }
}
