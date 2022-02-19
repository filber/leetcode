package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1686_StoneGameVITest {

    _1686_StoneGameVI target = null;

    @Before
    public void before() throws Exception {
        target = new _1686_StoneGameVI();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testStoneGameVI1() throws Exception {
        int res = target.stoneGameVI(new int[]{1, 3}, new int[]{2, 1});
        assertEquals(1, res);
    }

    @Test
    public void testStoneGameVI2() throws Exception {
        int res = target.stoneGameVI(new int[]{1, 2}, new int[]{3, 1});
        assertEquals(0, res);
    }

    @Test
    public void testStoneGameVI3() throws Exception {
        int res = target.stoneGameVI(new int[]{2, 4, 3}, new int[]{1, 6, 7});
        assertEquals(-1, res);
    }

    @Test
    public void testStoneGameVI4() throws Exception {
        int res = target.stoneGameVI(new int[]{9, 8, 3, 8}, new int[]{10, 6, 9, 5});
        assertEquals(1, res);
    }

} 
