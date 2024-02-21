package math;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _201_BitwiseANDOfNumbersRangeTest {

    _201_BitwiseANDOfNumbersRange target;

    @Before
    public void setUp() throws Exception {
        target = new _201_BitwiseANDOfNumbersRange();
    }

    @Test
    public void testRangeBitwiseAnd1() {
        int left = 5;
        int right = 7;
        int output = target.rangeBitwiseAnd(left, right);
        assertEquals(4, output);
    }

    @Test
    public void testRangeBitwiseAnd2() {
        int left = 0;
        int right = 0;
        int output = target.rangeBitwiseAnd(left, right);
        assertEquals(0, output);
    }

    @Test
    public void testRangeBitwiseAnd3() {
        int left = 1;
        int right = 2147483647;
        int output = target.rangeBitwiseAnd(left, right);
        assertEquals(0, output);
    }
}