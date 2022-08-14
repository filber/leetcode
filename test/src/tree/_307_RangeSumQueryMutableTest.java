package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;
import tree._307_RangeSumQueryMutable.NumArraySegmentTree;
import tree._307_RangeSumQueryMutable.NumArray;

public class _307_RangeSumQueryMutableTest {

    _307_RangeSumQueryMutable target = null;

    @Before
    public void before() throws Exception {
        target = new _307_RangeSumQueryMutable();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSumRange1() throws Exception {
        int[] nums = {1, 3, 5};
        NumArraySegmentTree numArraySegmentTree = new NumArraySegmentTree(nums);
        assertEquals(9, numArraySegmentTree.sumRange(0, 2));
        assertEquals(8, numArraySegmentTree.sumRange(1, 2));
        assertEquals(4, numArraySegmentTree.sumRange(0, 1));
        // 1, 2, 5
        numArraySegmentTree.update(1, 2);
        assertEquals(8, numArraySegmentTree.sumRange(0, 2));
        assertEquals(7, numArraySegmentTree.sumRange(1, 2));
        assertEquals(3, numArraySegmentTree.sumRange(0, 1));
    }

    @Test
    public void testSumRange2() throws Exception {
        int[] nums = {1, 3, 5};
        NumArray numArray = new NumArray(nums);
        assertEquals(9, numArray.sumRange(0, 2));
        assertEquals(8, numArray.sumRange(1, 2));
        assertEquals(4, numArray.sumRange(0, 1));
        // 1, 2, 5
        numArray.update(1, 2);
        assertEquals(8, numArray.sumRange(0, 2));
        assertEquals(7, numArray.sumRange(1, 2));
        assertEquals(3, numArray.sumRange(0, 1));
    }

    @Test
    public void testSumRange3() throws Exception {
        int[] nums = {-1};
        NumArray numArray = new NumArray(nums);
        assertEquals(-1, numArray.sumRange(0, 0));
        // 1
        numArray.update(0, 1);
        assertEquals(1, numArray.sumRange(0, 0));
    }
}
