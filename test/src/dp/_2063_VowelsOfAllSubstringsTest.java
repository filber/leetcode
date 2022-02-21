package dp;

import dp._2063_VowelsOfAllSubstrings;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2063_VowelsOfAllSubstringsTest {

    _2063_VowelsOfAllSubstrings target = null;

    @Before
    public void before() throws Exception {
        target = new _2063_VowelsOfAllSubstrings();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCountVowels1() throws Exception {
        // "b", "a", "ab", "ab", "ba", "a", "aba" = 0 + 1 + 1 + 1 + 1 + 2 = 6.
        long count = target.countVowels("aba");
        assertEquals(6L, count);
    }

    @Test
    public void testCountVowels2() throws Exception {
        // "a", "ab", "abc", "b", "bc", "c" = 1 + 1 + 1 + 0 + 0 + 0 = 3.
        long count = target.countVowels("abc");
        assertEquals(3L, count);
    }

    @Test
    public void testCountVowels3() throws Exception {
        // 0
        long count = target.countVowels("ltcd");
        assertEquals(0L, count);
    }

    @Test
    public void testCountVowels4() throws Exception {
        // 1
        long count = target.countVowels("a");
        assertEquals(1L, count);
    }

    @Test
    public void testCountVowels5() throws Exception {
        // 0
        long count = target.countVowels("b");
        assertEquals(0L, count);
    }

    @Test
    public void testCountVowels6() throws Exception {
        // "a" + "ab" = 1 + 1 = 2
        long count = target.countVowels("ab");
        assertEquals(2L, count);
    }

    @Test
    public void testCountVowels7() throws Exception {
        // "a" + "ba" = 1 + 1 = 2
        long count = target.countVowels("ba");
        assertEquals(2L, count);
    }

    @Test
    public void testCountVowels8() throws Exception {
        long count = target.countVowels("noosabasboosa");
        assertEquals(237L, count);
    }
}
