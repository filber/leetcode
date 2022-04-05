package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _384_ShuffleAnArrayTest {

    _384_ShuffleAnArray target = null;

    @Before
    public void before() throws Exception {
        target = new _384_ShuffleAnArray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testShuffle() throws Exception {
        target.init(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int[] shuffle = target.shuffle();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, target.reset());
    }
}
