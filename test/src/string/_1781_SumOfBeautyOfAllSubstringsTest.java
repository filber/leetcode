package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1781_SumOfBeautyOfAllSubstringsTest {

    _1781_SumOfBeautyOfAllSubstrings target = null;

    @Before
    public void before() throws Exception {
        target = new _1781_SumOfBeautyOfAllSubstrings();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testBeautySum1() throws Exception {
        int sum = target.beautySum("aabcb");
        assertEquals(5, sum);
    }

    @Test
    public void testBeautySum2() throws Exception {
        int sum = target.beautySum("aabcbaa");
        assertEquals(17, sum);
    }

    @Test
    public void testBeautySum3() throws Exception {
        int sum = target.beautySum("aabzzcbzzzz");
        assertEquals(91, sum);
    }
}
