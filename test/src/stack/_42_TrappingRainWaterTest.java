package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import stack._42_TrappingRainWater;

import static org.junit.Assert.*;

public class _42_TrappingRainWaterTest {

    _42_TrappingRainWater target = null;

    @Before
    public void before() throws Exception {
        target = new _42_TrappingRainWater();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testTrap1() throws Exception {
        int volume = target.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        assertEquals(6, volume);
    }

    @Test
    public void testTrap2() throws Exception {
        int volume = target.trap(new int[]{4, 2, 0, 3, 2, 5});
        assertEquals(9, volume);
    }

} 
