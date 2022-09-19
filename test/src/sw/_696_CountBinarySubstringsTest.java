package sw;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _696_CountBinarySubstringsTest {

    _696_CountBinarySubstrings target = null;

    @Before
    public void before() throws Exception {
        target = new _696_CountBinarySubstrings();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCountBinarySubstrings1() throws Exception {
        int count = target.countBinarySubstrings("00110011");
        //"0011","01","1,0","1100","0011","01"
        assertEquals(6, count);
    }

    @Test
    public void testCountBinarySubstrings2() throws Exception {
        int count = target.countBinarySubstrings("10101");
        //"10","1010","01","0101"
        assertEquals(4, count);
    }
}
