package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _870_AdvantageShuffleTest {

    _870_AdvantageShuffle target = null;

    @Before
    public void before() throws Exception {
        target = new _870_AdvantageShuffle();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testAdvantageCount1() throws Exception {
        int[] res = target.advantageCount(new int[]{2, 11, 7, 15}, new int[]{1, 10, 4, 11});
        int[] expected = {2, 11, 7, 15};
        assertArrayEquals(expected, res);
    }

    @Test
    public void testAdvantageCount2() throws Exception {
        int[] res = target.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11});
        int[] expected = {24, 32, 8, 12};
        assertArrayEquals(expected, res);
    }

    @Test
    public void testAdvantageCount3() throws Exception {
        int[] res = target.advantageCount(new int[]{1}, new int[]{2});
        int[] expected = {1};
        assertArrayEquals(expected, res);
    }

    @Test
    public void testAdvantageCount4() throws Exception {
        int[] res = target.advantageCount(new int[]{2}, new int[]{1});
        int[] expected = {2};
        assertArrayEquals(expected, res);
    }
}
