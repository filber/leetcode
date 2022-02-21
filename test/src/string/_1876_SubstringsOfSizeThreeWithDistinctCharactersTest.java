package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1876_SubstringsOfSizeThreeWithDistinctCharactersTest {

    _1876_SubstringsOfSizeThreeWithDistinctCharacters target = null;

    @Before
    public void before() throws Exception {
        target = new _1876_SubstringsOfSizeThreeWithDistinctCharacters();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCountGoodSubstrings1() throws Exception {
        int count = target.countGoodSubstrings("a");
        assertEquals(0, count);
    }

    @Test
    public void testCountGoodSubstrings2() throws Exception {
        int count = target.countGoodSubstrings("ab");
        assertEquals(0, count);
    }

    @Test
    public void testCountGoodSubstrings3() throws Exception {
        int count = target.countGoodSubstrings("aaa");
        assertEquals(0, count);
    }

    @Test
    public void testCountGoodSubstrings4() throws Exception {
        int count = target.countGoodSubstrings("aba");
        assertEquals(0, count);
    }

    @Test
    public void testCountGoodSubstrings5() throws Exception {
        int count = target.countGoodSubstrings("abc");
        assertEquals(1, count);
    }

    @Test
    public void testCountGoodSubstrings6() throws Exception {
        int count = target.countGoodSubstrings("xyzzaz");
        assertEquals(1, count);
    }

    @Test
    public void testCountGoodSubstrings7() throws Exception {
        int count = target.countGoodSubstrings("aababcabc");
        assertEquals(4, count);
    }

    @Test
    public void testCountGoodSubstrings8() throws Exception {
        int count = target.countGoodSubstrings("owuxoelszb");
        assertEquals(8, count);
    }
}
