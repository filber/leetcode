package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _2272_SubstringWithLargestVarianceTest {

    _2272_SubstringWithLargestVariance target;

    @Before
    public void init() {
        target = new _2272_SubstringWithLargestVariance();
    }

    @Test
    public void testLargestVariance1() {
        String str = "aababbb";
        int variance = target.largestVariance(str);
        assertEquals(3, variance); // babbb -> 3
    }

    @Test
    public void testLargestVariance2() {
        String str = "abcde";
        int variance = target.largestVariance(str);
        assertEquals(0, variance);
    }

    @Test
    public void testLargestVariance3() {
        String str = "tpgvobbvsudsylozthotvpmsqsgbqwuiubopxbvcg";
        int variance = target.largestVariance(str);
        assertEquals(4, variance);
    }

    @Test
    public void testLargestVariance4() {
        String str = "aabaaa";
        int variance = target.largestVariance(str);
        assertEquals(4, variance);
    }
}