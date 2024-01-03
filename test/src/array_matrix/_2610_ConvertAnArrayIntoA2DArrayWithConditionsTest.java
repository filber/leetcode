package array_matrix;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class _2610_ConvertAnArrayIntoA2DArrayWithConditionsTest {

    _2610_ConvertAnArrayIntoA2DArrayWithConditions instance;

    @Before
    public void init() {
        instance = new _2610_ConvertAnArrayIntoA2DArrayWithConditions();
    }

    @Test
    public void testFindMatrix1() {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        List<List<Integer>> result = instance.findMatrix(nums);
        assertEquals(3, result.size());
        assertArrayEquals(new Object[]{1, 3, 2, 4}, result.get(0).toArray());
        assertArrayEquals(new Object[]{1, 3}, result.get(1).toArray());
        assertArrayEquals(new Object[]{1}, result.get(2).toArray());
    }

    @Test
    public void testFindMatrix2() {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> result = instance.findMatrix(nums);
        assertEquals(1, result.size());
        assertArrayEquals(new Object[]{1, 2, 3, 4}, result.get(0).toArray());
    }
}