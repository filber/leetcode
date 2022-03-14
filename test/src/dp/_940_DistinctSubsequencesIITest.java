package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _940_DistinctSubsequencesIITest {

    _940_DistinctSubsequencesII target = null;

    @Before
    public void before() throws Exception {
        target = new _940_DistinctSubsequencesII();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testDistinctSubseqII1() throws Exception {
        int cnt = target.distinctSubseqII("abc");
        assertEquals(7, cnt);
    }

    @Test
    public void testDistinctSubseqII2() throws Exception {
        int cnt = target.distinctSubseqII("aba");
        assertEquals(6, cnt);
    }

    @Test
    public void testDistinctSubseqII3() throws Exception {
        int cnt = target.distinctSubseqII("aaa");
        assertEquals(3, cnt);
    }

    @Test
    public void testDistinctSubseqII4() throws Exception {
        int cnt = target.distinctSubseqII("ab");
        assertEquals(3, cnt);
    }

    @Test
    public void testDistinctSubseqII5() throws Exception {
        int cnt = target.distinctSubseqII("a");
        assertEquals(1, cnt);
    }

    @Test
    public void testDistinctSubseqII6() throws Exception {
        int cnt = target.distinctSubseqII("abab");
        assertEquals(11, cnt);
    }

    @Test
    public void testDistinctSubseqII7() throws Exception {
        int cnt = target.distinctSubseqII("ababa");
        assertEquals(19, cnt);
    }

    @Test
    public void testDistinctSubseqII8() throws Exception {
        int cnt = target.distinctSubseqII("blljuffdyfrkqtwfyfztpdiyktrhftgtabxxoibcclbjvirnqyynkyaqlxgyybkgyzvcahmytjdqqtctirnxfjpktxmjkojlvvrr");
        assertEquals(589192369, cnt);
    }
}
