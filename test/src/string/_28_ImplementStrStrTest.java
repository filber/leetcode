package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _28_ImplementStrStrTest {

    _28_ImplementStrStr target = null;

    @Before
    public void before() throws Exception {
        target = new _28_ImplementStrStr();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testStrStr1() throws Exception {
        int idx = target.strStr("hello", "ll");
        assertEquals(2, idx);
    }

    @Test
    public void testStrStr2() throws Exception {
        int idx = target.strStr("aaaaa", "bba");
        assertEquals(-1, idx);
    }

    @Test
    public void testStrStr3() throws Exception {
        int idx = target.strStr("", "");
        assertEquals(0, idx);
    }

    @Test
    public void testStrStr4() throws Exception {
        int idx = target.strStr("abc", "");
        assertEquals(0, idx);
    }

    @Test
    public void testStrStr5() throws Exception {
        int idx = target.strStr("", "abc");
        assertEquals(-1, idx);
    }

    @Test
    public void testStrStr6() throws Exception {
        int idx = target.strStr("ababababfababababf", "ababf");
        assertEquals(4, idx);
    }
}
