package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _45_JumpGameIITest {

    _45_JumpGameII target = null;

    @Before
    public void before() throws Exception {
        target = new _45_JumpGameII();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testJump1() throws Exception {
        // 2[0-->1-->4]
        int jumps = target.jump(new int[]{2, 3, 1, 1, 4});
        assertEquals(2, jumps);
    }

    @Test
    public void testJump2() throws Exception {
        // 2[0-->1-->4]
        int jumps = target.jump(new int[]{2, 3, 0, 1, 4});
        assertEquals(2, jumps);
    }

    @Test
    public void testJump3() throws Exception {
        // 1[0-->2]
        int jumps = target.jump(new int[]{2, 0, 0});
        assertEquals(1, jumps);
    }

    @Test
    public void testJump4() throws Exception {
        // 3[0-->1-->8-->11]
        int jumps = target.jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0});
        assertEquals(3, jumps);
    }

    @Test
    public void testJump5() throws Exception {
        int jumps = target.jump(new int[]{1});
        assertEquals(0, jumps);
    }

    @Test
    public void testJump6() throws Exception {
        // 2 [0-7-14]
        int jumps = target.jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3});
        assertEquals(2, jumps);
    }
}
