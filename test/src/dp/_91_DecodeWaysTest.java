package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _91_DecodeWaysTest {

    _91_DecodeWays target = null;

    @Before
    public void before() throws Exception {
        target = new _91_DecodeWays();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNumDecodings1() throws Exception {
        int num = target.numDecodings("12");
        //[AB],[L]
        assertEquals(2, num);
    }

    @Test
    public void testNumDecodings2() throws Exception {
        int num = target.numDecodings("06");
        assertEquals(0, num);
    }

    @Test
    public void testNumDecodings3() throws Exception {
        int num = target.numDecodings("60");
        assertEquals(0, num);
    }

    @Test
    public void testNumDecodings4() throws Exception {
        int num = target.numDecodings("226");
        //[2,2,6],[22,6],[2,26]
        assertEquals(3, num);
    }

    @Test
    public void testNumDecodings5() throws Exception {
        int num = target.numDecodings("11106");
        //[1,1,10,6],[11,10,6]
        assertEquals(2, num);
    }


    @Test
    public void testNumDecodings6() throws Exception {
        int num = target.numDecodings("1123");
        //[1,1,2,3],[1,1,23],[1,12,3],[11,2,3],[11,23]
        assertEquals(5, num);
    }

    @Test
    public void testNumDecodings7() throws Exception {
        int num = target.numDecodings("1000");
        assertEquals(0, num);
    }

    @Test
    public void testNumDecodings8() throws Exception {
        int num = target.numDecodings("27");
        assertEquals(1, num);
    }
}
