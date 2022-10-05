package tp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _163_MissingRangesTest {

    _163_MissingRanges target;

    @Before
    public void before() throws Exception {
        target = new _163_MissingRanges();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindMissingRanges1() throws Exception {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        String[] expected = {"2", "4->49", "51->74", "76->99"};
        List<String> ranges = target.findMissingRanges(nums, lower, upper);
        assertArrayEquals(expected, ranges.toArray(new String[0]));
    }
}
