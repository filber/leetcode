package dfs;

import dp._403_FrogJump;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _403_FrogJumpTest {

    _403_FrogJump target = null;

    @Before
    public void before() throws Exception {
        target = new _403_FrogJump();
    }

    @After
    public void after() throws Exception {
    }



    @Test
    public void testCanCrossMapFailed2() throws Exception {
        boolean can = target.canCross(new int[]{0, 2});
        assertEquals(false, can);
    }

    @Test
    public void testCanCrossMapFailed3() throws Exception {
        boolean can = target.canCross(new int[]{0, 1, 2, 5, 6, 9, 10, 12, 13, 14, 17, 19, 20, 21, 26, 27, 28, 29, 30});
        assertEquals(false, can);
    }

    @Test
    public void testCanCrossMapFailed4() throws Exception {
        boolean can = target.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11});
        assertEquals(false, can);
    }

    @Test
    public void testCanCrossMapSuccess1() throws Exception {
        boolean can = target.canCross(new int[]{0, 1, 3, 4, 5, 7, 9, 10, 12});
        assertEquals(true, can);
    }

    @Test
    public void testCanCrossMapSuccess2() throws Exception {
        boolean can = target.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
        assertEquals(true, can);
    }
}
