package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _136_SingleNumberTest {

    _136_SingleNumber target = null;

    @Before
    public void before() throws Exception {
        target = new _136_SingleNumber();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSingleNumber1() throws Exception {
        int num = target.singleNumber(new int[]{2, 2, 1});
        assertEquals(1, num);
    }

    @Test
    public void testSingleNumber2() throws Exception {
        int num = target.singleNumber(new int[]{4, 1, 2, 1, 2});
        assertEquals(4, num);
    }

    @Test
    public void testSingleNumber3() throws Exception {
        int num = target.singleNumber(new int[]{1});
        assertEquals(1, num);
    }

} 
