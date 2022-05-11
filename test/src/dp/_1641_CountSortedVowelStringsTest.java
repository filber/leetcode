package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1641_CountSortedVowelStringsTest {

    _1641_CountSortedVowelStrings target = null;

    @Before
    public void before() throws Exception {
        target = new _1641_CountSortedVowelStrings();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCountVowelStrings1() throws Exception {
        int count = target.countVowelStrings(1);
        assertEquals(5, count);
    }

    @Test
    public void testCountVowelStrings2() throws Exception {
        int count = target.countVowelStrings(2);
        assertEquals(15, count);
    }

    @Test
    public void testCountVowelStrings3() throws Exception {
        int count = target.countVowelStrings(33);
        assertEquals(66045, count);
    }
}
