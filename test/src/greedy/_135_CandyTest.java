package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _135_CandyTest {

    _135_Candy target = null;

    @Before
    public void before() throws Exception {
        target = new _135_Candy();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCandy1() throws Exception {
        int[] ratings = {1, 2, 2};
        int candies = target.candy(ratings);
        assertEquals(4, candies);
    }

    @Test
    public void testCandy2() throws Exception {
        int[] ratings = {1, 0, 2};
        int candies = target.candy(ratings);
        assertEquals(5, candies);
    }

} 
