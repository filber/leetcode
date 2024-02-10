package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _647_PalindromicSubstringsTest {

    _647_PalindromicSubstrings target;

    @Before
    public void setUp() throws Exception {
        target = new _647_PalindromicSubstrings();
    }

    @Test
    public void testCountSubstrings1() {
        int cnt = target.countSubstrings("abc");
        assertEquals(3, cnt);
    }

    @Test
    public void testCountSubstrings2() {
        int cnt = target.countSubstrings("xabax");
        assertEquals(7, cnt);
    }

    @Test
    public void testCountSubstrings3() {
        int cnt = target.countSubstrings("abccba");
        assertEquals(9, cnt);
    }

    @Test
    public void testCountSubstrings4() {
        int cnt = target.countSubstrings("aaa");
        assertEquals(6, cnt);
    }
}