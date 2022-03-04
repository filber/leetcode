package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _799_ChampagneTowerTest {

    _799_ChampagneTower target = null;

    @Before
    public void before() throws Exception {
        target = new _799_ChampagneTower();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testChampagneTower1() throws Exception {
        double full = target.champagneTower(1, 1, 1);
        assertEquals(0.0, full, 0.001);
    }

    @Test
    public void testChampagneTower2() throws Exception {
        double full = target.champagneTower(2, 1, 1);
        assertEquals(0.5, full, 0.001);
    }

    @Test
    public void testChampagneTower3() throws Exception {
        double full = target.champagneTower(100000009, 33, 17);
        assertEquals(1.0, full, 0.001);
    }

    @Test
    public void testChampagneTower4() throws Exception {
        double full = target.champagneTower(4, 2, 0);
        assertEquals(0.25, full, 0.001);
    }

    @Test
    public void testChampagneTower5() throws Exception {
        double full = target.champagneTower(4, 2, 1);
        assertEquals(0.5, full, 0.001);
    }
} 
