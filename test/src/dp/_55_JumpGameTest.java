package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _55_JumpGameTest {

    _55_JumpGame target = null;

    @Before
    public void before() throws Exception {
        target = new _55_JumpGame();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCanJump1() throws Exception {


        boolean jump = target.canJump(new int[]{2, 3, 1, 1, 4});
        assertTrue(jump);
    }

    @Test
    public void testCanJump2() throws Exception {
        boolean jump = target.canJump(new int[]{3, 2, 1, 0, 4});
        assertFalse(jump);
    }

    @Test
    public void testCanJump3() throws Exception {
        boolean jump = target.canJump(new int[]{1, 2});
        assertTrue(jump);
    }

    @Test
    public void testCanJump4() throws Exception {
        boolean jump = target.canJump(new int[]{2, 0, 0});
        assertTrue(jump);
    }

    @Test
    public void testCanJump5() throws Exception {
        boolean jump = target.canJump(new int[]{0, 2, 3});
        assertFalse(jump);
    }

    @Test
    public void testCanJump6() throws Exception {
        boolean jump = target.canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0});
        assertTrue(jump);
    }

    @Test
    public void testCanJump7() throws Exception {
        boolean jump = target.canJump(new int[]{0});
        assertTrue(jump);
    }
}
