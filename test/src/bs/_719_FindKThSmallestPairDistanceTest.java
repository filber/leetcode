package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _719_FindKThSmallestPairDistanceTest {

    _719_FindKThSmallestPairDistance target = null;

    @Before
    public void before() throws Exception {
        target = new _719_FindKThSmallestPairDistance();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSmallestDistancePair1() throws Exception {
        int[] nums = {1, 3, 1};
        // [1,1]
        assertEquals(0, target.smallestDistancePair(nums, 1));
        assertEquals(2, target.smallestDistancePair(nums, 2));
        assertEquals(2, target.smallestDistancePair(nums, 3));
    }

    @Test
    public void testSmallestDistancePair4() throws Exception {
        int[] nums = {1, 1, 1};
        assertEquals(0, target.smallestDistancePair(nums, 1));
        assertEquals(0, target.smallestDistancePair(nums, 2));
        assertEquals(0, target.smallestDistancePair(nums, 3));
    }

    @Test
    public void testSmallestDistancePair5() throws Exception {
        int[] nums = {1, 6, 1};
        assertEquals(0, target.smallestDistancePair(nums, 1));
        assertEquals(5, target.smallestDistancePair(nums, 2));
        assertEquals(5, target.smallestDistancePair(nums, 3));
    }

    @Test
    public void testSmallestDistancePair7() throws Exception {
        int[] nums = {1, 6, 2};
        assertEquals(1, target.smallestDistancePair(nums, 1));
        assertEquals(4, target.smallestDistancePair(nums, 2));
        assertEquals(5, target.smallestDistancePair(nums, 3));
    }

    @Test
    public void testSmallestDistancePair10() throws Exception {
        int[] nums = {62, 100, 4};
        // [62,100]
        assertEquals(38, target.smallestDistancePair(nums, 1));
        // [4,62]
        assertEquals(58, target.smallestDistancePair(nums, 2));
        // [4,100]
        assertEquals(96, target.smallestDistancePair(nums, 3));
    }

}