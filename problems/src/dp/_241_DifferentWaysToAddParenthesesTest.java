package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class _241_DifferentWaysToAddParenthesesTest {

    _241_DifferentWaysToAddParentheses target = null;

    @Before
    public void before() throws Exception {
        target = new _241_DifferentWaysToAddParentheses();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testZeroOperator() throws Exception {
        List<Integer> list = target.diffWaysToCompute("34");
        assertArrayEquals(new Integer[]{34}, list.toArray(new Integer[0]));
    }

    @Test
    public void testOneOperator() throws Exception {
        List<Integer> list = target.diffWaysToCompute("2+1");
        assertArrayEquals(new Integer[]{3}, list.toArray(new Integer[0]));
    }

    @Test
    public void testTwoOperator() throws Exception {
        List<Integer> list = target.diffWaysToCompute("2-1-1");
        assertArrayEquals(new Integer[]{2, 0}, list.toArray(new Integer[0]));
    }

    @Test
    public void testTwoOperator2() throws Exception {
        List<Integer> list = target.diffWaysToCompute("24*34+99");
        assertArrayEquals(new Integer[]{3192, 915}, list.toArray(new Integer[0]));
    }

    @Test
    public void testThreeOperator() throws Exception {
        List<Integer> list = target.diffWaysToCompute("2*3-4*5");
        assertArrayEquals(new Integer[]{-34, -10, -14, -10, 10}, list.toArray(new Integer[0]));
    }
} 
