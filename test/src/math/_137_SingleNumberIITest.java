package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _137_SingleNumberIITest {

    _137_SingleNumberII target = null;

    @Before
    public void before() throws Exception {
        target = new _137_SingleNumberII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSingleNumber1() throws Exception {
        int num = target.singleNumber(new int[]{2, 2, 3, 2});
        assertEquals(3, num);
    }

    @Test
    public void testSingleNumber2() throws Exception {
        int num = target.singleNumber(new int[]{2, 1, 2, 1, 2, 1, 99});
        assertEquals(99, num);
    }
}
