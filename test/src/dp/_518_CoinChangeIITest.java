package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _518_CoinChangeIITest {

    _518_CoinChangeII target;

    @Before
    public void before() throws Exception {
        target = new _518_CoinChangeII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testChange1() throws Exception {
        int w = target.change(5, new int[]{1, 2, 5});
        //5=5
        //5=2+2+1
        //5=2+1+1+1
        //5=1+1+1+1+1
        assertEquals(4, w);
    }

    @Test
    public void testChange2() throws Exception {
        int w = target.change(3, new int[]{2});
        assertEquals(0, w);
    }

    @Test
    public void testChange3() throws Exception {
        int w = target.change(10, new int[]{10});
        assertEquals(1, w);
    }

    @Test
    public void testChange4() throws Exception {
        int w = target.change(5, new int[]{1, 2, 3, 5});
        //5=1+1+1+1+1
        //5=1+1+1+2
        //5=1+2+2
        //5=1+1+3
        //5=2+3
        //5=5
        assertEquals(6, w);
    }
}
