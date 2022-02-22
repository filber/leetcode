package bfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1345_JumpGameIVTest {

    _1345_JumpGameIV target = null;

    @Before
    public void before() throws Exception {
        target = new _1345_JumpGameIV();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMinJumps1() throws Exception {
        int jumps = target.minJumps(new int[]{7});
        assertEquals(0, jumps);
    }

    @Test
    public void testMinJumps2() throws Exception {
        // 1 - [0-->7]
        int jumps = target.minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7});
        assertEquals(1, jumps);
    }

    @Test
    public void testMinJumps3() throws Exception {
        // 3 - [0-->4-->3-->9]
        int jumps = target.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404});
        assertEquals(3, jumps);
    }

    @Test
    public void testMinJumps4() throws Exception {
        // 2 - [0-->n-2-->n-1]
        int jumps = target.minJumps(new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 11});
        assertEquals(2, jumps);
    }
}
